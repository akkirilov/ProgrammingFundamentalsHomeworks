package app;

import app.service.api.IngredientService;
import app.service.api.LabelService;
import app.service.api.ProductionBatchService;
import app.service.api.ShampoosService;
import app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private ProductionBatchService<ProductionBatch, Long> productionBatchService;

    @Autowired
    private IngredientService<BasicIngredient, Long> basicIngredientService;

    @Autowired
    private ShampoosService<BasicShampoo, Long> basicShampoosService;
    
    @Autowired
    private LabelService<ClassicLabel, Long> classicLabelService;

    @Override
    public void run(String... strings) throws Exception {
    	
    	List<BasicShampoo> basicShampoos;
    	List<ProductionBatch> productionBatches;
    	ProductionBatch productionBatch;
    	List<BasicIngredient> basicIngredients;
    	ClassicLabel classicLabel;
    	List<Long> ids;
    	Long id;
    	List<String> names;
    	String subTitle;
    	BigDecimal price;
    	Date date;
    	Integer number;
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	String input;
    	String command;
    	while (true) {
    		
    		printMenu();
    		
    		command = scanner.nextLine();
    		if (command.equals("e")) {
				break;
			}
    		
    		switch (command) {
			case "0":
				initializeDB();
				break;
			case "1":
				System.out.println("Enter brand name: ");
				input = scanner.nextLine();
				basicShampoos = basicShampoosService.findByBrand(input);
				printShampoos(basicShampoos);
				break;
			case "2":
				basicShampoos = basicShampoosService.findByBrandAndSize("Brand1", 1);
				printShampoos(basicShampoos);
				break;
			case "3":
				classicLabel = classicLabelService.findById(1L);
				basicShampoos = basicShampoosService.findBySizeAndLabel(1, classicLabel);
				printShampoos(basicShampoos);
				break;
			case "4":
				System.out.println("Enter price: ");
				price = new BigDecimal(scanner.nextLine());
				basicShampoos = basicShampoosService.findByPriceGreaterThanOrderByBrandDesc(price);
				printShampoos(basicShampoos);
				break;
			case "5":
				System.out.println("Enter date in format 'yyyy-MM-dd': ");
				date = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
				productionBatches = productionBatchService.findByDate(date);
				printProductionBatches(productionBatches);
				break;
			case "6":
				basicIngredients = basicIngredientService.findByPriceIsNullOrderByNameDesc();
				printBasicIngredients(basicIngredients);
				break;
			case "7":
				input = scanner.nextLine();
				basicIngredients = basicIngredientService.findByNameStartingWith(input);
				printBasicIngredients(basicIngredients);
				break;
			case "8":
				ids = new ArrayList<>();
				ids.add(2L);
				ids.add(3L);
				basicIngredients = basicIngredientService.findByIdIn(ids);
				printBasicIngredients(basicIngredients);
				break;
			case "9":
				productionBatches = productionBatchService.findByShampoosIsNull();
				printProductionBatches(productionBatches);
				break;
			case "10":
				System.out.println("Enter price: ");
				price = new BigDecimal(scanner.nextLine());
				basicShampoos = basicShampoosService.findByPriceLowerThan(price);
				System.out.println("Count: " + basicShampoos.size());
				printShampoos(basicShampoos);
				break;
			case "11":
				classicLabel = classicLabelService.findById(1L);
				basicShampoos = basicShampoosService.findByLabelJPQL(classicLabel);
				printShampoos(basicShampoos);
				break;
			case "12":
				names = new ArrayList<>();
				names.add("Mint");
				names.add("Levander");
				basicIngredients = basicIngredientService.findByNameInListJPQL(names);
				printBasicIngredients(basicIngredients);
				break;
			case "13":
				names = new ArrayList<>();
				names.add("Mint");
				names.add("Levander");
				basicIngredients = basicIngredientService.findByNameInListJPQL(names);
				basicShampoos = basicShampoosService.findByIngredientInListJPQL(basicIngredients);
				printShampoos(basicShampoos);
				break;
			case "14":
				System.out.println("Enter number: ");
				number = Integer.parseInt(scanner.nextLine());
				basicShampoos = basicShampoosService.findByIngredientCountLowerThanNumberJPQL(number);
				printShampoos(basicShampoos);
				break;
			case "15":
				System.out.println("Enter date in format 'yyyy-MM-dd': ");
				date = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
				basicShampoos = basicShampoosService.findByBatchDateBeforeGivenDateJPQL(date);
				printShampoos(basicShampoos);
				break;
			case "16":
				System.out.println("Enter price: ");
				price = new BigDecimal(scanner.nextLine());
				basicShampoos = basicShampoosService.findByIngredientsSumLowerThanGivenPriceJPQL(price);
				printShampoos(basicShampoos);
				break;
			case "17":
				System.out.println("Enter batch's id: ");
				id = Long.parseLong(scanner.nextLine());
				productionBatch = productionBatchService.findById(id);
				System.out.println("Enter sub title: ");
				subTitle = scanner.nextLine();
				basicShampoos = basicShampoosService.findByBatchIdAndSubTitleDifferentThanGivenJPQL(productionBatch, subTitle);
				printShampoos(basicShampoos);
				break;
			case "18":
				System.out.println("Enter price: ");
				price = new BigDecimal(scanner.nextLine());
				basicIngredients = basicIngredientService.findByPriceSumsGreaterThanGivenPriceNJPQL(price);
				printBasicIngredients(basicIngredients);
				break;
			case "19":
				basicIngredients = basicIngredientService.findAll(BasicIngredient.class);
				printBasicIngredientsAndShampoosBrands(basicIngredients);
				break;
			case "20":
				productionBatches = productionBatchService.findAll(ProductionBatch.class);
				printProductionBatchesDatesAndShampoosLabelTitles(productionBatches);
				break;
			case "21":
				System.out.println("Enter name: ");
				input = scanner.nextLine();
				basicIngredientService.deleteByNameNJPQL(input);
				break;
			case "22":
				System.out.println("Enter percent(integer): ");
				number = Integer.parseInt(scanner.nextLine());
				basicIngredientService.increasePriceByGivenPercentNJPQL(number);
				break;
			case "23":
				System.out.println("Enter percent(integer): ");
				number = Integer.parseInt(scanner.nextLine());
				ids = new ArrayList<>();
				ids.add(5L);
				ids.add(6L);
				basicIngredients = basicIngredientService.findByIdIn(ids);
				basicIngredientService.increasePriceByGivenPercentOfListedIngredientsNJPQL(number, basicIngredients);
				break;
			default:
				break;
			}
    		
    	}
    	
		scanner.close();
    	
    }
    
    private void printMenu(){
    	System.out.println("e = exit");
		System.out.println("0 = Initialize Database (seed data)");
		System.out.println("1 = Select Shampoos by Brand");
		System.out.println("2 = Select Shampoos by Brand and Size");
		System.out.println("3 = Select Shampoos by Size or Label");
		System.out.println("4 = Select Shampoos by Price higher than a given price");
		System.out.println("5 = Select Batches by Date after a given date");
		System.out.println("6 = Select Ingredients without Price");
		System.out.println("7 = Select all ingredients which name starts with given letters");
		System.out.println("8 = select all ingredients which are contained in a given list.");
		System.out.println("9 = select all batches without shampoos.");
		System.out.println("10 = counts all shampoos with price lower than a given price.");
		System.out.println("11 = select all shampoos by label.");
		System.out.println("12 = select all ingredients by names given in a list.");
		System.out.println("13 = select all shampoos with ingredients in a given list.");
		System.out.println("14 = select all shampoos with ingredients less than a given number.");
		System.out.println("15 = select all shampoos in a batch with a date before a given date.");
		System.out.println("16 = select all shampoos with ingredients's sum is less than a given number.");
		System.out.println("17 = select all shampoos in a batch with a given id and with a label subtitle different than a given string.");
		System.out.println("18 = select all ingredients and their sum of price which is higher than a given price.");
		System.out.println("19 = select all ingredients names and their shampoo brands.");
		System.out.println("20 = select batch date and shampoo label title.");
		System.out.println("21 = delete ingredients by a given name.");
		System.out.println("22 = increases the price of all ingredients by given percen.");
		System.out.println("23 = increases the price of all ingredients in list by given percen.");		
    }

    private void printProductionBatchesDatesAndShampoosLabelTitles(List<ProductionBatch> productionBatches) {
		for (ProductionBatch productionBatch : productionBatches) {
			System.out.println(productionBatch.getDate());
			for (BasicShampoo basicShampoo : productionBatch.getShampoos()) {
				System.out.println("---" + basicShampoo.getLabel().getName());
			}
		}
		
	}

	private void printBasicIngredientsAndShampoosBrands(List<BasicIngredient> basicIngredients) {
    	for (BasicIngredient basicIngredient : basicIngredients) {
			System.out.println(basicIngredient.getName());
			for (BasicShampoo basicShampoo : basicIngredient.getShampoos()) {
				System.out.println("---" + basicShampoo.getBrand());
			}
		}
	}

	private void printBasicIngredients(List<BasicIngredient> basicIngredients) {
    	for (BasicIngredient basicIngredient : basicIngredients) {
			System.out.println(basicIngredient);
		}
	}

	private void printProductionBatches(List<ProductionBatch> productionBatches) {
    	for (ProductionBatch productionBatch : productionBatches) {
			System.out.println(productionBatch);
		}
	}

	private void printShampoos(List<BasicShampoo> basicShampoos) {
    	for (BasicShampoo basicShampoo : basicShampoos) {
			System.out.println(basicShampoo);
		}
    }
    
	private void initializeDB() throws ParseException {
		BasicIngredient ingredient1 = new Mint();
        BasicIngredient ingredient2 = new Nettle();
        BasicIngredient ingredient3 = new Strawberry();
        BasicIngredient ingredient4 = new Levander();
        BasicIngredient ingredient5 = new AmoniumCloride();
        BasicIngredient ingredient6 = new AmoniumCloride();
        ingredient6.setPrice(null);

        Set<BasicIngredient> ingredients1 = new HashSet<>();
        ingredients1.add(ingredient1);
        ingredients1.add(ingredient2);
        ingredients1.add(ingredient3);
        ingredients1.add(ingredient4);
        ingredients1.add(ingredient6);
        
        Set<BasicIngredient> ingredients2 = new HashSet<>();
        ingredients2.add(ingredient1);
        ingredients2.add(ingredient2);
        ingredients2.add(ingredient4);
        
        Set<BasicIngredient> ingredients3 = new HashSet<>();
        ingredients3.add(ingredient3);
        ingredients3.add(ingredient5);        
        
        ClassicLabel label1 = new ClassicLabel("Fresh");
        label1.setSubTitle("Fresh 4Ever");
        ClassicLabel label2 = new ClassicLabel("Shine");
        label2.setSubTitle("Shine 4Ever");
        ClassicLabel label3 = new ClassicLabel("Bald");
        label3.setSubTitle("Bald 4Ever");
        
        ProductionBatch batch1 = new ProductionBatch();
        batch1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2013-10-10"));
        batch1.setName("FirstSeries");
        
        ProductionBatch batch2 = new ProductionBatch();
        batch2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-10"));
        batch2.setName("SecondSeries");
        
        ProductionBatch batch3 = new ProductionBatch();
        batch3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-10"));
        batch3.setName("NullShampoos");
        productionBatchService.save(batch3);
        
        BasicShampoo shampoo1 = new FreshNuke();
        shampoo1.setIngredients(ingredients1);
        shampoo1.setLabel(label1);
        shampoo1.setBrand("Brand1");
        shampoo1.setSize(1);
        shampoo1.setPrice(BigDecimal.valueOf(3.5));
        shampoo1.setBatch(batch1);
                
        BasicShampoo shampoo2 = new PinkPanter();
        shampoo2.setIngredients(ingredients2);
        shampoo2.setBatch(batch2);
        shampoo2.setLabel(label2);
        shampoo2.setBrand("Brand2");
        shampoo2.setSize(2);
        shampoo2.setPrice(BigDecimal.valueOf(4.28));
        
        BasicShampoo shampoo3 = new SuperBald();
        shampoo3.setIngredients(ingredients3);
        shampoo3.setBatch(batch2);
        shampoo3.setLabel(label3);
        shampoo3.setBrand("Brand3");
        shampoo3.setSize(3);
        shampoo3.setPrice(BigDecimal.valueOf(7.54));
        
        List<BasicShampoo> shampoosToSave = new ArrayList<BasicShampoo>();
        shampoosToSave.add(shampoo1);
        shampoosToSave.add(shampoo2);
        shampoosToSave.add(shampoo3);
        basicShampoosService.save(shampoosToSave);
		
	}
}
