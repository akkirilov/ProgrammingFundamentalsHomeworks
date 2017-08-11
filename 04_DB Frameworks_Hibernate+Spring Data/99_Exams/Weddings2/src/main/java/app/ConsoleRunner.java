package app;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.*;
import app.services.api.*;
import app.domain.dtos.agencies.AgencyDto;
import app.domain.dtos.agencies.AgencyExportJsonDto;
import app.domain.dtos.agencies.TownXmlDto;
import app.domain.dtos.agencies.TownsWrapperXmlDto;
import app.domain.dtos.persons.PersonDto;
import app.domain.dtos.presents.PresentWrapperXmlDto;
import app.domain.dtos.venues.VenueWrapperXmlDto;
import app.domain.dtos.venues.VenueinSofiaXmlDto;
import app.domain.dtos.venues.VenuesInSofiaWrapperXmlDto;
import app.domain.dtos.weddings.WeddingDto;
import app.domain.dtos.weddings.WeddingExportJsonDto;
import app.domain.entities.*;
import app.utils.*;
import app.domain.enums.*;

@Component
public class ConsoleRunner implements CommandLineRunner{
    
	private static final Random random = new Random();
	
	private PersonService personService;
	private VenueService venuService;
	private AgencyService agencyService;
	private PresentService presentService;
	private InvitationService invitationService;
	private WeddingService weddingService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public ConsoleRunner(PersonService personService,
							VenueService venuService,
							AgencyService agencyService,
							PresentService presentService,
							InvitationService invitationService,
							WeddingService weddingService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		this.personService = personService;
		this.venuService = venuService;
		this.agencyService = agencyService;
		this.presentService = presentService;
		this.invitationService = invitationService;
		this.weddingService = weddingService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void run(String... args) throws Exception {
		
		importAgencies();
		importPeople();
		importWeddingsAndInvitations();
		importVenues();
		importPresents();
		exportOrderedAgencies();
		exportGuestLists();
		exportVenuesInSofia();
		exportAgenciesByTowns();
		
		
	}
	
	private void exportAgenciesByTowns() {
		String fileName = "agencies-by-town.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
		
		TownsWrapperXmlDto dto = new TownsWrapperXmlDto();
		
		List<TownXmlDto> dtos = agencyService.findAllTownXmlDtos();
		dto.setTownXmlDto(dtos);
		try {
			xmlParser.exportXml(dto, path);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
	}
	
	private void exportVenuesInSofia() {
		String fileName = "sofia-venues.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
		
		VenuesInSofiaWrapperXmlDto dto = new VenuesInSofiaWrapperXmlDto();
		
		List<VenueinSofiaXmlDto> dtos = venuService.findAllVenuesInSofia();
		if (dtos == null || dtos.size() < 1) {
			return;
		}
		dto.setVenueXmlDtos(dtos);
		dto.setTown("Sofia");
		
		try {
			xmlParser.exportXml(dto, path);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
	}
	
	private void exportGuestLists() {
		String fileName = "guests.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
		
		List<WeddingExportJsonDto> dtos = weddingService.findAllWeddingExportJsonDtoOrdered();
		try {
			jsonParser.exportJson(dtos, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
	}
	
	private void exportOrderedAgencies() {
		String fileName = "agencies-ordered.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
		
		List<AgencyExportJsonDto> dtos = agencyService.findAllAgencyExportJsonDtoOrdered();
		try {
			jsonParser.exportJson(dtos, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
	}

	private void importPresents(){
		String fileName = "presents.xml";
		String path = Config.IMPORT_XML_PATH + fileName;
		
		try {
			PresentWrapperXmlDto dto = xmlParser.importXml(PresentWrapperXmlDto.class, path);
			presentService.saveFromPresentXmlDtos(dto.getPresentXmlDtos());
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}

	}
	
	private void importVenues(){
		String fileName = "venues.xml";
		String path = Config.IMPORT_XML_PATH + fileName;
		
		try {
			VenueWrapperXmlDto dto = xmlParser.importXml(VenueWrapperXmlDto.class, path);
			venuService.saveFromVenueXmlDtos(dto.getVenueXmlDtos());
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}

	}
	
	private void importWeddingsAndInvitations(){
		String fileName = "weddings.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<WeddingDto> dtos = jsonParser.importJsonList(WeddingDto.class, path);
			weddingService.saveFromDto(dtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
	private void importPeople(){
		String fileName = "people.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<PersonDto> dtos = jsonParser.importJsonList(PersonDto.class, path);
			personService.saveFromDto(dtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
	private void importAgencies(){
		String fileName = "agencies.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		
		try {
			List<AgencyDto> dtos = jsonParser.importJsonList(AgencyDto.class, path);
			List<Agency> agencies = mapper.mapToList(dtos, Agency.class);
			agencyService.save(agencies);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
}
