package app;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.*;
import app.services.api.*;
import app.domain.dtos.agencies.AgencyJsonDto;
import app.domain.dtos.persons.PeopleJsonDto;
import app.domain.dtos.weddings.WeddingJsonDto;
import app.domain.entities.*;
import app.utils.*;
import app.domain.enums.*;

@Component
public class ConsoleRunner implements CommandLineRunner{
    
	private static final Random random = new Random();
	
	private PersonService personService;
	private AgencyService agencyService;
	private WeddingService weddingService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public ConsoleRunner(PersonService personService,
							AgencyService agencyService,
							WeddingService weddingService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		this.personService = personService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.agencyService = agencyService;
		this.weddingService = weddingService;
	}

	@Override
	public void run(String... args) throws Exception {
	
		importAgencies();
		importPersons();
		importWeddingsAndInvitations();
		
	}
	
	private void importAgencies() {
		
		String fileName = "agencies.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<AgencyJsonDto> agencyJsonDtos = jsonParser.importJsonList(AgencyJsonDto.class, path);
			agencyService.createFromAgencyJsonDto(agencyJsonDtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't read " + path);
		}
	}
	
	private void importPersons() {
		
		String fileName = "people.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<PeopleJsonDto> peopleJsonDtos = jsonParser.importJsonList(PeopleJsonDto.class, path);
			personService.createFromPeopleJsonDto(peopleJsonDtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't read " + path);
		}
	}
	
private void importWeddingsAndInvitations() {
		
		String fileName = "weddings.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<WeddingJsonDto> weddingJsonDtos = jsonParser.importJsonList(WeddingJsonDto.class, path);
			weddingService.createFromWeddingJsonDto(weddingJsonDtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't read " + path);
		}
	}
		
	private void exportE() {
		
		String fileName = "";
		
	}
	
}
