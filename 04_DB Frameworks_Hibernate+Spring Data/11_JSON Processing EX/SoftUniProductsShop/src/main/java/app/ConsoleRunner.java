package app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.Category;
import app.entities.Product;
import app.entities.User;
import app.models.bindingModels.CategoryInfo;
import app.models.bindingModels.CategoryJsonInDto;
import app.models.bindingModels.ProductInRangeJsonDto;
import app.models.bindingModels.ProductJsonInDto;
import app.models.bindingModels.SuccessfullUserJsonDto;
import app.models.bindingModels.UserJsonInDto;
import app.models.bindingModels.UsersInfoDto;
import app.services.api.CategoryService;
import app.services.api.ProductService;
import app.services.api.UserService;
import app.utils.JsonParser;
import app.utils.Mapper;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private final String EXPORT_PATH = System.getProperty("user.dir") + "/src/main/resources/files/json/output/";
	private final String IMPORT_PATH = "/files/json/input/";
	
	private UserService userService;
	private CategoryService categoryService;
	private ProductService productService;
    private JsonParser jsonParser;
    
	@Autowired
	public ConsoleRunner(UserService userService, CategoryService categoryService, ProductService productService, JsonParser jsonParser) {
		this.userService = userService;
		this.categoryService = categoryService;
		this.productService = productService;
		this.jsonParser = jsonParser;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
	
		BigDecimal min;
		BigDecimal max;
		String command;
		while (true) {
			
			printMenu();

			command = scanner.nextLine();
			if (command.equals("exit")) {
				break;
			}
			
			switch (command) {
			case "init":
				initializeDatabase();
				break;
			case "1":
				System.out.println("Enter min price... ");
				min = new BigDecimal(scanner.nextLine());
				System.out.println("Enter max price... ");
				max = new BigDecimal(scanner.nextLine());
				exportProductsInGivenRange(min, max);
				break;
			case "2":
				exportSuccessfullySoldProducts();
				break;
			case "3":
				exportCategoriesByProductsCount();
				break;
			case "4":
				exportUserProductsInfo();
				break;
			default:
				break;
			}
			
		}
		scanner.close();
		
	}
		
	private void exportUserProductsInfo() {
		List<User> users = userService.findAllSuccessfullUser();
		for (User user : users) {
			Set<Product> productsToRemove = new HashSet<>();
			for (Product p : user.getSoldProducts()) {
				if (p.getBuyer() == null) {
					productsToRemove.add(p);
				}
			}
			for (Product p : productsToRemove) {
				user.getSoldProducts().remove(p);
			}
		}
		UsersInfoDto usersInfoToExport = Mapper.mapToUsersInfo(users);
		try {
			jsonParser.exportJson(usersInfoToExport, EXPORT_PATH + "UsersProductsInfo.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportCategoriesByProductsCount() {
		List<Category> categories = categoryService.findAllByProductsCount();
		List<CategoryInfo> categoryToExport = Mapper.mapToCategoryInfoList(categories);
		try {
			jsonParser.exportJson(categoryToExport, EXPORT_PATH + "CategoryInfo.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportSuccessfullySoldProducts() {
		List<User> users = userService.findAllSuccessfullUser();
		for (User user : users) {
			Set<Product> productsToRemove = new HashSet<>();
			for (Product p : user.getSoldProducts()) {
				if (p.getBuyer() == null) {
					productsToRemove.add(p);
				}
			}
			for (Product p : productsToRemove) {
				user.getSoldProducts().remove(p);
			}
		}
		List<SuccessfullUserJsonDto> usersToExport = Mapper.mapToList(users, SuccessfullUserJsonDto.class);
		try {
			jsonParser.exportJson(usersToExport, EXPORT_PATH + "SuccessfullUser.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportProductsInGivenRange(BigDecimal min, BigDecimal max) {
		List<Product> products = productService.findProductsByPriceInGivenRange(min, max); 
		List<ProductInRangeJsonDto> productsToExport = Mapper.mapToProductInRangeList(products);
		try {
			jsonParser.exportJson(productsToExport, EXPORT_PATH + "ProductsInRange.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("exit = Exit");
		System.out.println("init = Initialize Database");
		System.out.println("1 = Products In Range");
		System.out.println("2 = Successfully Sold Products");
		System.out.println("3 = Categories By Products Count");
		System.out.println("4 = Users and Products");
		System.out.println();
	}

	public void initializeDatabase() {
		
		if (userService.count() > 0) {
			System.out.println("Database already initialized!");
			return;
		}
		
		List<UserJsonInDto> usersDtos = null;
		try {
			usersDtos = jsonParser.importJsonToList(UserJsonInDto.class, IMPORT_PATH + "users.json");
		} catch (IOException e) {
			System.out.println("EROR during read userJsonFile!");
		}
		userService.save(Mapper.mapToList(usersDtos, User.class));
		
		List<CategoryJsonInDto> categoriesDtos = null;
		try {
			categoriesDtos = jsonParser.importJsonToList(CategoryJsonInDto.class, IMPORT_PATH + "categories.json");
		} catch (IOException e) {
			System.out.println("EROR during read userJsonFile!");
		}
		categoryService.save(Mapper.mapToList(categoriesDtos, Category.class));

		List<ProductJsonInDto> productsDtos = null;
		try {
			productsDtos = jsonParser.importJsonToList(ProductJsonInDto.class, IMPORT_PATH + "products.json");
		} catch (IOException e) {
			System.out.println("EROR during read userJsonFile!");
		}
		
		List<User> users = userService.findAll();
		int maxIndex = users.size();		
		Random random = new Random();
		List<Integer> skipIds = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			skipIds.add(random.nextInt(maxIndex));			
		}
		List<Product> products = Mapper.mapToList(productsDtos, Product.class);		
		
		int sellerId;
		int buyerId;
		for (Product product : products) {
			sellerId = random.nextInt(maxIndex);
			product.setSeller(users.get(sellerId));
			buyerId = random.nextInt(maxIndex);
			if (skipIds.contains(buyerId)) {
				continue;
			}
			while (sellerId == buyerId) {
				buyerId = random.nextInt(maxIndex);
			}
			product.setBuyer(users.get(buyerId));
		}
		productService.save(products);
		
		products = productService.findAll();
		List<Category> categories = categoryService.findAll();
		int categoryId;
		int maxCount;
		maxIndex = categories.size();
		for (Product product : products) {
			maxCount = random.nextInt(5);
			if (maxCount == 0) {
				maxCount = 3;
			}
			while (product.getCategories().size() < maxCount) {
				categoryId = random.nextInt(maxIndex);
				product.addCategory(categories.get(categoryId));
			}
		}
		productService.save(products);
		
	}
    
}
