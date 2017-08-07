package app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.*;
import app.models.cars.*;
import app.models.customers.*;
import app.models.parts.PartsDto;
import app.models.sales.*;
import app.models.suppliers.*;
import app.services.api.*;
import app.utils.*;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private final String EXPORT_XML_PATH = System.getProperty("user.dir") + "/src/main/resources/files/xml/output/";
	private final String IMPORT_XML_PATH = "/files/xml/input/";
	
	private final CustomerService customerService;
	private final PartService partService;
	private final SaleService saleService;
	private final SupplierService supplierService;
	private final CarService carService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
    
	@Autowired
	public ConsoleRunner(CustomerService customerService, PartService partService, SaleService saleService,
			SupplierService supplierService, CarService carService, JsonParser jsonParser, XmlParser xmlParser) {
		super();
		this.customerService = customerService;
		this.partService = partService;
		this.saleService = saleService;
		this.supplierService = supplierService;
		this.carService = carService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
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
		SalesDto salesDto = new SalesDto();
		List<SaleWithDiscountDto> saleWithDiscountDtos = Mapper.mapToList(sales, SaleWithDiscountDto.class);
		salesDto.setSaleWithDiscountDtos(saleWithDiscountDtos);
		try {
			xmlParser.exportXml(salesDto, EXPORT_XML_PATH + "salesStatistic.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void exportCustomerStatistics() {
		List<Customer> customers = customerService.findAllWithCars();
		CustomersDto customersDto = new CustomersDto();
		List<CustomerStatisticDto> customerStatisticDtos = Mapper.mapToList(customers, CustomerStatisticDto.class);
		customerStatisticDtos = customerStatisticDtos
				.stream()
				.sorted((a, b) -> {
					int res = b.getSpentMoney().compareTo(a.getSpentMoney());
					if (res == 0) {
						res = b.getBoughtCars().compareTo(a.getBoughtCars());
					}
					return res;
				})
				.collect(Collectors.toList());
		customersDto.setCustomerStatisticDtos(customerStatisticDtos);
		try {
			xmlParser.exportXml(customersDto, EXPORT_XML_PATH + "customerStatistic.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportCarsWithParts() {
		List<Car> cars = carService.findAllToyota();
		CarsDto carsDto = new CarsDto();
		List<CarWithPartsDto> carWithPartsDtos = Mapper.mapToList(cars, CarWithPartsDto.class);
		carsDto.setCarWithPartsDtos(carWithPartsDtos);
		try {
			xmlParser.exportXml(carsDto, EXPORT_XML_PATH + "carsWithParts.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportLocalSuppliers() {
		List<Supplier> suppliers = supplierService.findAllLocalSuppliers();
		SuppliersDto suppliersDto = new SuppliersDto();
		List<SupplierWithPartsCountDto> supplierWithPartsCountDtos = Mapper.mapToList(suppliers, SupplierWithPartsCountDto.class);
		suppliersDto.setSupplierWithPartsCountDtos(supplierWithPartsCountDtos);
		try {
			xmlParser.exportXml(suppliersDto, EXPORT_XML_PATH + "localSuppliers.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportToyota() {
		List<Car> cars = carService.findAllToyota();
		CarsDto carsDto = new CarsDto();
		List<CarWithoutSetsDto> carWithoutSetsDtos = Mapper.mapToList(cars, CarWithoutSetsDto.class);
		carsDto.setCarWithoutSetsDtos(carWithoutSetsDtos);
		try {
			xmlParser.exportXml(carsDto, EXPORT_XML_PATH + "toyotaCars.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exportCustomers() {
		List<Customer> customers = customerService.findAllByOrderByBirthDateAsc();
		CustomersDto customersDto = new CustomersDto();
		List<CustumerWithoutSalesDto> custumerWithoutSalesDtos = Mapper.mapToList(customers, CustumerWithoutSalesDto.class);
		customersDto.setCustumerWithoutSalesDtos(custumerWithoutSalesDtos);
		try {
			xmlParser.exportXml(customersDto, EXPORT_XML_PATH + "customersByBirtDate.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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

	public void initializeDatabase() {
		
		if (carService.findAll().size() > 0) {
			System.out.println("Database is already initialized!");
			return;
		}
		
		SuppliersDto suppliersDto = null;	
		try {
			suppliersDto = xmlParser.importXml(SuppliersDto.class, IMPORT_XML_PATH + "suppliers.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Supplier> suppliers = Mapper.mapToList(suppliersDto.getSupplierBasicDtos(), Supplier.class);
		supplierService.save(suppliers);
		
		CarsDto carsDto = null;
		try {
			carsDto = xmlParser.importXml(CarsDto.class, IMPORT_XML_PATH + "cars.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Car> cars = Mapper.mapToList(carsDto.getCarBasicDtos(), Car.class);
		carService.save(cars);
		
		PartsDto partsDto = null;
		try {
			partsDto = xmlParser.importXml(PartsDto.class, IMPORT_XML_PATH + "parts.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		suppliers = supplierService.findAll();
		List<Part> parts = Mapper.mapToList(partsDto.getPartBasicDtos(), Part.class);
		int maxIndex = suppliers.size();		
		Random random = new Random();
		for (Part p : parts) {
			p.setSupplier(suppliers.get(random.nextInt(maxIndex)));
		}
		partService.save(parts);
		
		CustomersDto custumersDto = null;
		try {
			custumersDto = xmlParser.importXml(CustomersDto.class, IMPORT_XML_PATH + "customers.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Customer> customers = Mapper.mapToList(custumersDto.getBasicDtos(), Customer.class);
		customerService.save(customers);
		
		cars = carService.findAll();
		parts = partService.findAll();
		int maxCount;
		maxIndex = parts.size();
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
