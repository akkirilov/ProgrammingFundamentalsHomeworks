package app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.Category;
import app.entities.Product;
import app.entities.User;
import app.models.categoriesDto.CategoriesDto;
import app.models.categoriesDto.CategoryWithProductsDto;
import app.models.productsDto.ProductsDto;
import app.models.productsDto.SoldProductDto;
import app.models.usersDto.UserWithProductsInfoDto;
import app.models.usersDto.UserWithSoldProductsDto;
import app.models.usersDto.UsersDto;
import app.services.api.CategoryService;
import app.services.api.ProductService;
import app.services.api.UserService;
import app.utils.JsonParser;
import app.utils.Mapper;
import app.utils.XmlParser;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private final String EXPORT_XML_PATH = System.getProperty("user.dir") + "/src/main/resources/files/xml/output/";
	private final String IMPORT_XML_PATH = "/files/xml/input/";
	private final String EXPORT_JSON_PATH = System.getProperty("user.dir") + "/src/main/resources/files/json/output/";
	private final String IMPORT_JSON_PATH = "/files/json/input/";
	
	private UserService userService;
	private CategoryService categoryService;
	private ProductService productService;
    private JsonParser jsonParser;
    private XmlParser xmlParser;
    
	@Autowired
	public ConsoleRunner(UserService userService, 
							CategoryService categoryService, 
							ProductService productService, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		this.userService = userService;
		this.categoryService = categoryService;
		this.productService = productService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
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
		UsersDto usersDto = new UsersDto();
		List<UserWithProductsInfoDto> userWithProductsInfo = Mapper.mapToList(users, UserWithProductsInfoDto.class);
		for (UserWithProductsInfoDto u : userWithProductsInfo) {
			SoldProductDto soldProducts = new SoldProductDto();
			soldProducts.setSoldProducts(u.getSoldProducts());
			u.setProductAttributeDto(soldProducts);
		}
		usersDto.setUserWithProductsInfo(userWithProductsInfo);
		try {
			xmlParser.exportXml(usersDto, EXPORT_XML_PATH + "usersWithProductsInfo.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (UserWithProductsInfoDto u : userWithProductsInfo) {
			u.getProductAttributeDto().setCount(u.getProductAttributeDto().getCount());
		}
		try {
			jsonParser.exportJson(usersDto.getUserWithProductsInfo(), EXPORT_JSON_PATH + "usersWithProductsInfo.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportCategoriesByProductsCount() {
		List<Category> categories = categoryService.findAllByProductsCount();
		CategoriesDto categoriesDto = new CategoriesDto();
		List<CategoryWithProductsDto> categoryWithProductsDto = Mapper.mapToList(categories, CategoryWithProductsDto.class);
		categoriesDto.setCategoryWithProductsDto(categoryWithProductsDto);
		try {
			xmlParser.exportXml(categoriesDto, EXPORT_XML_PATH + "categoriesWithProductsInfo.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (CategoryWithProductsDto c : categoryWithProductsDto) {
			c.setAveragePrice(c.getAveragePrice());
			c.setTotalRevenue(c.getTotalRevenue());
			c.setProductsCount(c.getProductsCount());
		}
		try {
			jsonParser.exportJson(categoriesDto, EXPORT_JSON_PATH + "categoriesWithProductsInfo.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportSuccessfullySoldProducts() {
		List<User> users = userService.findAllSuccessfullUser();
		UsersDto usersDto = new UsersDto();
		List<UserWithSoldProductsDto> successfullUsers = Mapper.mapToList(users, UserWithSoldProductsDto.class);
		usersDto.setSuccessfullUsers(successfullUsers);
		try {
			xmlParser.exportXml(usersDto, EXPORT_XML_PATH + "usersWithSoldProducts.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			jsonParser.exportJson(usersDto.getSuccessfullUsers(), EXPORT_JSON_PATH + "usersWithSoldProducts.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportProductsInGivenRange(BigDecimal min, BigDecimal max) {
		List<Product> products = productService.findProductsByPriceInGivenRange(min, max);
		ProductsDto productsDto = Mapper.mapToProductsWithSellerDtoXml(products);
		try {
			xmlParser.exportXml(productsDto, EXPORT_XML_PATH + "productsInRange.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			jsonParser.exportJson(productsDto, EXPORT_JSON_PATH + "productsInRange.json");
		} catch (IOException e) {
			e.printStackTrace();
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
		
		UsersDto usersDto = null;
		try {
			usersDto = xmlParser.importXml(UsersDto.class, IMPORT_XML_PATH + "users.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<User> users = Mapper.mapToList(usersDto.getUsers(), User.class);
		userService.save(users);
		
		CategoriesDto categoriesDto = null;
		try {
			categoriesDto = xmlParser.importXml(CategoriesDto.class, IMPORT_XML_PATH + "categories.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Category> categories = Mapper.mapToList(categoriesDto.getCategoryDtos(), Category.class);
		categoryService.save(categories);
		
		ProductsDto productsDto = null;
		try {
			productsDto = xmlParser.importXml(ProductsDto.class, IMPORT_XML_PATH + "products.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Product> products = Mapper.mapToList(productsDto.getProductDtos(), Product.class);
		productService.save(products);
				
		Random random = new Random();
		int maxUserIndex = users.size();		
		List<Integer> skipIds = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			skipIds.add(random.nextInt(maxUserIndex));			
		}
		
		users = userService.findAll();
		categories = categoryService.findAll();
		products = productService.findAll();
		int sellerId;
		int buyerId;
		int categoryId;
		int maxCount;
		int maxCategoryIndex = categories.size();
		for (Product product : products) {
			maxCount = random.nextInt(5);
			if (maxCount < 2) {
				maxCount = 2;
			}
			while (product.getCategories().size() < maxCount) {
				categoryId = random.nextInt(maxCategoryIndex);
				product.addCategory(categories.get(categoryId));
			}
			
			sellerId = random.nextInt(maxUserIndex);
			product.setSeller(users.get(sellerId));
			buyerId = random.nextInt(maxUserIndex);
			while (sellerId == buyerId) {
				buyerId = random.nextInt(maxUserIndex);
			}
			if (skipIds.contains(buyerId)) {
				continue;
			}
			product.setBuyer(users.get(buyerId));
		}
		productService.save(products);
		
	}
    
}
