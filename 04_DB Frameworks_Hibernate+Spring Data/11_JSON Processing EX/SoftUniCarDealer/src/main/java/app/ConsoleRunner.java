package app;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.*;
import app.models.*;
import app.models.cars.CarWithPartsDto;
import app.models.cars.CarWithoutSetsDto;
import app.models.customers.CustomerStatisticDto;
import app.models.customers.CustumerWithBasicSaleDto;
import app.models.sales.SaleWithDiscountDto;
import app.models.suppliers.SupplierWithPartsCountDto;
import app.services.api.*;
import app.utils.JsonParser;
import app.utils.Mapper;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private final String EXPORT_PATH = System.getProperty("user.dir") + "/src/main/resources/files/json/output/";
	private final String IMPORT_PATH = "/files/json/input/";
	
	private final CustomerService customerService;
	private final PartService partService;
	private final SaleService saleService;
	private final SupplierService supplierService;
	private final CarService carService;
	
	private JsonParser jsonParser;
    
	@Autowired
	public ConsoleRunner(CustomerService customerService, PartService partService, SaleService saleService,
			SupplierService supplierService, CarService carService, JsonParser jsonParser) {
		super();
		this.customerService = customerService;
		this.partService = partService;
		this.saleService = saleService;
		this.supplierService = supplierService;
		this.carService = carService;
		this.jsonParser = jsonParser;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);

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
				exportCustomers();
				break;
			case "2":
				exportToyota();
				break;
			case "3":
				exportLocalSuppliers();
				break;
			case "4":
				exportCarsWithParts();
				break;
			case "5":
				exportCustomerStatistics();
				break;
			case "6":
				exportSalesWithDiscount();
				break;
			default:
				break;
			}
			
		}
		scanner.close();
		
	}

	private void exportSalesWithDiscount() {
		List<Sale> sales = saleService.findAllWithAppliedDiscount();
		List<SaleWithDiscountDto> toExport = Mapper.mapSaleWithDiscountDto(sales);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "salesWithDiscount.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportCustomerStatistics() {
		List<Customer> customers = customerService.findAllByOrderByBirthDateAsc();
		List<CustomerStatisticDto> toExport = Mapper.mapCustomerStatisticDto(customers);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "customerStatistic.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportCarsWithParts() {
		List<Car> cars = carService.findAllToyota();
		List<CarWithPartsDto> toExport = Mapper.mapToList(cars, CarWithPartsDto.class);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "carsWithParts.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportLocalSuppliers() {
		List<Supplier> suppliers = supplierService.findAllLocalSuppliers();
		List<SupplierWithPartsCountDto> toExport = Mapper.mapToSupplierWithParts(suppliers);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "localSuppliers.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportToyota() {
		List<Car> cars = carService.findAllToyota();
		List<CarWithoutSetsDto> toExport = Mapper.mapToList(cars, CarWithoutSetsDto.class);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "allToyota.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void exportCustomers() {
		List<Customer> customers = customerService.findAllByOrderByBirthDateAsc();
		List<CustumerWithBasicSaleDto> toExport = Mapper.mapToList(customers, CustumerWithBasicSaleDto.class);
		try {
			jsonParser.exportJson(toExport, EXPORT_PATH + "customersByBirthDate.json");
		} catch (IOException e) {
			System.out.println("ERROR during file write!");
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("exit = Exit");
		System.out.println("init = Initialize Database");
		System.out.println("1 = Ordered Customers");
		System.out.println("2 = Cars from make Toyota");
		System.out.println("3 = Local Suppliers");
		System.out.println("4 = Cars with Their List of Parts");
		System.out.println("5 = Total Sales by Customer");
		System.out.println("6 = Sales with Applied Discount");
		System.out.println();
	}

	public void initializeDatabase() throws IOException, ParseException {
		
		if (carService.findAll().size() > 0) {
			System.out.println("Dtabase is already initialized!");
			return;
		}
		
		List<CustomerBasicDto> customersBasicDtos = jsonParser.importJsonToList(CustomerBasicDto.class, IMPORT_PATH + "customers.json");
		List<Customer> customers = Mapper.mapToList(customersBasicDtos, Customer.class);
		customerService.save(customers);
		
		List<SupplierBasicDto> suppliersBasicDtos = jsonParser.importJsonToList(SupplierBasicDto.class, IMPORT_PATH + "suppliers.json");
		List<Supplier> suppliers = Mapper.mapToList(suppliersBasicDtos, Supplier.class);
		supplierService.save(suppliers);
		
		List<PartBasicDto> partsBasicDtos = jsonParser.importJsonToList(PartBasicDto.class, IMPORT_PATH + "parts.json");
		List<Part> parts = Mapper.mapToList(partsBasicDtos, Part.class);
		partService.save(parts);
		
		List<CarBasicDto> carsBasicDtos = jsonParser.importJsonToList(CarBasicDto.class, IMPORT_PATH + "cars.json");
		List<Car> cars = Mapper.mapToList(carsBasicDtos, Car.class);
		carService.save(cars);
		
		suppliers = supplierService.findAll();
		parts = partService.findAll();
		int maxIndex = suppliers.size();		
		Random random = new Random();
		for (Part p : parts) {
			p.setSupplier(suppliers.get(random.nextInt(maxIndex)));
		}
		partService.save(parts);
		parts = partService.findAll();
		int maxCount;
		maxIndex = parts.size();
		cars = carService.findAll();
		for (Car c : cars) {
			Set<Part> partsToSet = new HashSet<>();
			maxCount = random.nextInt(21);
			if (maxCount < 11) {
				maxCount = 11;
			}
			while (partsToSet.size() < maxCount) {
				partsToSet.add(parts.get(random.nextInt(maxIndex)));
			}
			c.setParts(partsToSet);
		}
		carService.save(cars);
		
		cars = carService.findAll();
		customers = customerService.findAll();
		String[] discounts = new String[]{"0", "5", "10", "15", "20", "30", "40", "50"};
		int maxDiscountIndex = discounts.length;
		int maxCarIndex = cars.size();
		int maxCustomerIndex = customers.size();
		List<Sale> sales = new ArrayList<>();		
		for (int i = 0; i < maxCustomerIndex * 4; i++) {
			Sale tempSale = new Sale();
			tempSale.setCar(cars.get(random.nextInt(maxCarIndex)));
			tempSale.setCustomer(customers.get(random.nextInt(maxCustomerIndex)));
			tempSale.setDiscount(new BigDecimal(discounts[random.nextInt(maxDiscountIndex)]));
			sales.add(tempSale);
		}
		saleService.save(sales);
		
	}
    
}
