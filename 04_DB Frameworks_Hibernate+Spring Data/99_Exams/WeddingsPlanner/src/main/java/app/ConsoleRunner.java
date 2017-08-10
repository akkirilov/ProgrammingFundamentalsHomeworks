package app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.*;
import app.services.api.*;
import app.test.TestDto;
import app.domain.dtos.agencies.AgenciesByTownXmlDto;
import app.domain.dtos.agencies.AgencyBasicJsonDto;
import app.domain.dtos.agencies.AgencyJsonDto;
import app.domain.dtos.agencies.TownXmlDto;
import app.domain.dtos.agencies.TownsWrapperXmlDto;
import app.domain.dtos.persons.GuestByWeddingByAgencyXmlDto;
import app.domain.dtos.persons.GuestsListJsonDto;
import app.domain.dtos.persons.PeopleJsonDto;
import app.domain.dtos.presents.PresentsWrapperXmlDto;
import app.domain.dtos.venues.VenueNameCapacityXmlDto;
import app.domain.dtos.venues.VenuesInSofiaWrapperXmlDto;
import app.domain.dtos.venues.VenuesWrapperXmlDto;
import app.domain.dtos.weddings.WeddingBasicJsonDto;
import app.domain.dtos.weddings.WeddingByAgencyXmlDto;
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
	private PresentService presentService;
	private VenueService venueService;
	private InvitationService invitationService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public ConsoleRunner(PersonService personService,
							AgencyService agencyService,
							WeddingService weddingService,
							VenueService venueService,
							PresentService presentService,
							InvitationService invitationService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		this.personService = personService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.agencyService = agencyService;
		this.weddingService = weddingService;
		this.presentService = presentService;
		this.invitationService = invitationService;
		this.venueService = venueService;
	}

	@Override
	public void run(String... args) throws Exception {
	
//		importAgencies();
//		importPersons();
//		importWeddingsAndInvitations();
//		importVenues();
//		importPresents();
//		
//		exportAgenciesOrdered();
//		exportGuestLists();
//		exportVenuesInSofia();
//		exportAgencyByTown();
		
		test();
		
	}
	
	private void test() {
		String fileName = "agencies.json";
		String path = Config.IMPORT_JSON_PATH + fileName;
		try {
			List<TestDto> tests = jsonParser.importJsonListTest(TestDto.class, path);
			for (TestDto test : tests) {
				System.out.println(test.getMeins() + " " + test.getTangrs()  + " " + test.getEmc());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void exportAgencyByTown() {
		String fileName = "agencies-by-town.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
		
		TownsWrapperXmlDto townsWrapperXmlDto = new TownsWrapperXmlDto();
		List<TownXmlDto> townXmlDtos = agencyService.getAllTownXmlDtos();
		
		townsWrapperXmlDto.setTownDtos(townXmlDtos);
		try {
			xmlParser.exportXml(townsWrapperXmlDto, path);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
	}

	private void exportVenuesInSofia() {

		String fileName = "sofia-venues.xml";
		String path = Config.EXPORT_XML_PATH + fileName;
		
		VenuesInSofiaWrapperXmlDto venuesInSofiaWrapperXmlDto = new VenuesInSofiaWrapperXmlDto();
		venuesInSofiaWrapperXmlDto.setVenueNameCapacityXmlDtos(venueService.getVenueNameCapacityXmlDtos());
				
		try {
			xmlParser.exportXml(venuesInSofiaWrapperXmlDto, path);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
			
		
	}

	private void exportGuestLists() {
		String fileName = "guests.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
		
		List<GuestsListJsonDto> guestsListJsonDtos = invitationService.findAllGuestsListJsonDto()
				.stream()
				.sorted((a, b) -> {
					int res = b.getInvitedGuests().compareTo(a.getInvitedGuests());
					if (res == 0) {
						res = a.getAttendingGuests().compareTo(b.getAttendingGuests());
					}
					return res;
				})
				.collect(Collectors.toList());
		
		try {
			jsonParser.exportJson(guestsListJsonDtos, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
		
	}

	private void exportAgenciesOrdered() {
		
		String fileName = "agencies-ordered.json";
		String path = Config.EXPORT_JSON_PATH + fileName;
		
		List<Agency> agencies = agencyService.findAllAgnciesOrdered();
		List<AgencyJsonDto> agencyJsonDtos = Mapper.mapToList(agencies, AgencyJsonDto.class);
		try {
			jsonParser.exportJson(agencyJsonDtos, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}
		
	}

	private void importPresents() {
	
		String fileName = "presents.xml";
		String path = Config.IMPORT_XML_PATH + fileName;
		try {
			PresentsWrapperXmlDto presentsWrapperXmlDto = xmlParser.importXml(PresentsWrapperXmlDto.class, path);
			presentService.createFromPresentXmlDto(presentsWrapperXmlDto.getPresentXmlDtos());
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't read " + path);
		}
		
	}

	private void importVenues() {
		
		String fileName = "venues.xml";
		String path = Config.IMPORT_XML_PATH + fileName;
		try {
			VenuesWrapperXmlDto venuesWrapperXmlDto = xmlParser.importXml(VenuesWrapperXmlDto.class, path);
			venueService.createFromVenueXmlDto(venuesWrapperXmlDto.getVenueXmlDtos());
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't read " + path);
		}
		
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
	
}
