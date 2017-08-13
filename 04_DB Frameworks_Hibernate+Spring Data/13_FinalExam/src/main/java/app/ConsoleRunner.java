package app;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.*;
import app.services.api.*;
import app.domain.dtos.branches.BranchJsonDto;
import app.domain.dtos.branches.BranchWrapperXmlDto;
import app.domain.dtos.branches.BranchXmlDto;
import app.domain.dtos.towns.TownJsonDto;
import app.domain.dtos.towns.TownWrapperXmlDto;
import app.domain.dtos.towns.TownXmlDto;
import app.domain.dtos.employeeCards.EmployeeCardJsonDto;
import app.domain.dtos.employees.EmployeeJsonDto;
import app.domain.dtos.employees.EmployeeWrapperXmlDto;
import app.domain.dtos.products.ProductWrapperXmlDto;
import app.domain.entities.*;
import app.utils.*;

@Component
public class ConsoleRunner implements CommandLineRunner{

	private EmployeeService employeeService;
	private EmployeeCardService employeeCardService;
	private ProductService productService;
	private TownService townService;
	private BranchService branchService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;

	@Autowired
	public ConsoleRunner(EmployeeService employeeService, EmployeeCardService employeeCardService,
			ProductService productService, TownService townService, BranchService branchService, JsonParser jsonParser,
			XmlParser xmlParser, Mapper mapper) {
		super();
		this.employeeService = employeeService;
		this.employeeCardService = employeeCardService;
		this.productService = productService;
		this.townService = townService;
		this.branchService = branchService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void run(String... args) throws Exception {
		
		importTowns();
		importBranches();
		importEmployeeCards();
		importProducts();
		importEmployees();
		
		exportFreeCards();
		exportProductiveEmployees();
		exportTowns();
		exportTopBranches();
		
	}
	
	private void exportTopBranches() {
		String fileName = "top-branches.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
	
		BranchWrapperXmlDto wrapperXmlDto = new BranchWrapperXmlDto();
		List<BranchXmlDto> dtos =	branchService.findAllTownsWithClients();
		wrapperXmlDto.setBranchXmlDtos(dtos);
		try {
			xmlParser.exportXml(wrapperXmlDto, path);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void exportTowns() {
		String fileName = "towns.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
	
		TownWrapperXmlDto wrapperXmlDto = new TownWrapperXmlDto();
		List<TownXmlDto> dtos =	townService.findAllTownsWithClients();
		wrapperXmlDto.setTownXmlDtos(dtos);
		try {
			xmlParser.exportXml(wrapperXmlDto, path);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void exportProductiveEmployees() {
		String fileName = "productive-employees.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
	
		List<EmployeeJsonDto> dtos = employeeService.findProductiveEmployees();
		try {
			jsonParser.exportJson(dtos, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void exportFreeCards() {
		String fileName = "free_cards.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
	
		List<EmployeeCard> source = employeeCardService.findFreeCards();
		List<EmployeeCardJsonDto> dtos = mapper.mapToList(source, EmployeeCardJsonDto.class);
		try {
			jsonParser.exportJson(dtos, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void importEmployees() {
		String fileName = "employees.xml";
		String path = Config.IMPORT_XML_PATH + fileName;

		try {
			EmployeeWrapperXmlDto wrapperXmlDto = xmlParser.importXml(EmployeeWrapperXmlDto.class, path);
			employeeService.saveFromDto(wrapperXmlDto);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importProducts() {
		String fileName = "products.xml";
		String path = Config.IMPORT_XML_PATH + fileName;

		try {
			ProductWrapperXmlDto wrapperXmlDto = xmlParser.importXml(ProductWrapperXmlDto.class, path);
			productService.saveFromDto(wrapperXmlDto);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importEmployeeCards() {
		String fileName = "employee_cards.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<EmployeeCardJsonDto> dtos = jsonParser.importJsonList(EmployeeCardJsonDto.class, path);
			employeeCardService.saveFromDto(dtos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importBranches() {
		String fileName = "branches.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<BranchJsonDto> dtos = jsonParser.importJsonList(BranchJsonDto.class, path);
			branchService.saveFromDto(dtos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importTowns() {
		String fileName = "towns.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<TownJsonDto> dtos = jsonParser.importJsonList(TownJsonDto.class, path);
			townService.saveFromDto(dtos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
