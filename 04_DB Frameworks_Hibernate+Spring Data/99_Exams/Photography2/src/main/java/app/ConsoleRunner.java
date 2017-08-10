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
import app.domain.dtos.accessories.AccessoryWrapperXmlDto;
import app.domain.dtos.accessories.AccessoryXmlDto;
import app.domain.dtos.cameras.CameraJsonDto;
import app.domain.dtos.lenses.LensJsonDto;
import app.domain.dtos.photographers.PhotographerJsonDto;
import app.domain.dtos.photographers.PhotographerLandscapeJsonDto;
import app.domain.dtos.photographers.PhotographerOrderedJsonDto;
import app.domain.dtos.photographers.PhotographerWithSameCamera;
import app.domain.dtos.photographers.PhotographerWrapperXmlDto;
import app.domain.dtos.workshops.LocationXmlDto;
import app.domain.dtos.workshops.WorkshopLocationWrapperXmlDto;
import app.domain.dtos.workshops.WorkshopWrapperXmlDto;
import app.domain.entities.*;
import app.utils.*;
import app.domain.enums.*;

@Component
public class ConsoleRunner implements CommandLineRunner{
    
	private static final Random random = new Random();
	
	private LensService lensService;
	private WorkshopService workshopService;
	private CameraService cameraService;
	private PhotographerService photographerService;
	private AccessoryService accessoryService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public ConsoleRunner(LensService lensService, 
						CameraService cameraService,
						PhotographerService photographerService,
						WorkshopService workshopService,
						AccessoryService accessoryService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		this.lensService = lensService;
		this.cameraService = cameraService;
		this.photographerService = photographerService;
		this.accessoryService = accessoryService;
		this.workshopService = workshopService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void run(String... args) throws Exception {
		
		importLenses();
		importCameras();
		importPhotographers();
		importAccessories();
		importWorkShops();
		
		exportPhotographerOrdered();
		exportLandscapePhotographers();
		exportSameCamerasPhotographers();
		exportWorkshopsByLocation();
		
	}
	
	private void exportWorkshopsByLocation() {
		String fileName = "workshops-by-location.xml";
		String path = Config.EXPORT_XML_PATH + fileName;

		List<LocationXmlDto> dtos = workshopService.getWorkshopsByLocation();
		WorkshopLocationWrapperXmlDto wrapper = new WorkshopLocationWrapperXmlDto();
		wrapper.setWorkshopLocationDtos(dtos);
			try {
				xmlParser.exportXml(wrapper, path);
			} catch (JAXBException | IOException e) {
				e.printStackTrace();
				System.out.println("ERROR: Can't export " + path);
			}
		
	}
	
	private void exportSameCamerasPhotographers() {
		String fileName = "same-cameras-photographers.xml";
		String path = Config.EXPORT_XML_PATH + fileName;

		List<PhotographerWithSameCamera> dtos = photographerService.getSameCamerasPhotographersJsonDto();
		PhotographerWrapperXmlDto wrapper = new PhotographerWrapperXmlDto();
		wrapper.setPhotographerWithSameCameras(dtos);

			try {
				xmlParser.exportXml(wrapper, path);
			} catch (JAXBException | IOException e) {
				e.printStackTrace();
				System.out.println("ERROR: Can't export " + path);
			}
		
	}
	
	private void exportLandscapePhotographers() {
		String fileName = "landscape-photographers.json";
		String path = Config.EXPORT_JSON_PATH + fileName;

		List<PhotographerLandscapeJsonDto> dto = photographerService.getLandscapePhotographersJsonDto();
		try {
			jsonParser.exportJson(dto, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}		
	}
	
	private void exportPhotographerOrdered() {
		String fileName = "photographers-ordered.json";
		String path = Config.EXPORT_JSON_PATH + fileName;

		List<PhotographerOrderedJsonDto> dto = photographerService.getPhotographerOrderedJsonDto();
		try {
			jsonParser.exportJson(dto, path);
		} catch (IOException e) {
			System.out.println("ERROR: Can't export " + path);
		}		
	}

	private void importWorkShops() {
		String fileName = "workshops.xml";
		String path = Config.IMPORT_XML_PATH + "" + fileName;

		WorkshopWrapperXmlDto wrapperXmlDto = new WorkshopWrapperXmlDto();
		try {
			wrapperXmlDto = xmlParser.importXml(WorkshopWrapperXmlDto.class, path);
			workshopService.save(wrapperXmlDto);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}

	}
	
	private void importAccessories() {
		String fileName = "accessories.xml";
		String path = Config.IMPORT_XML_PATH + "" + fileName;

		AccessoryWrapperXmlDto accessoryWrapperXmlDto = new AccessoryWrapperXmlDto();
		try {
			accessoryWrapperXmlDto = xmlParser.importXml(AccessoryWrapperXmlDto.class, path);
			accessoryService.save(accessoryWrapperXmlDto);
		} catch (JAXBException | IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}

	}
	
	private void importPhotographers() {
		String fileName = "photographers.json";
		String path = Config.IMPORT_JSON_PATH + "" + fileName;
		
		try {
			List<PhotographerJsonDto> dtos = jsonParser.importJsonList(PhotographerJsonDto.class, path);
			photographerService.save(dtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
	private void importCameras() {
		String fileName = "cameras.json";
		String path = Config.IMPORT_JSON_PATH + "" + fileName;
		
		try {
			List<CameraJsonDto> dtos = jsonParser.importJsonList(CameraJsonDto.class, path);
			cameraService.save(dtos);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
	private void importLenses() {
		String fileName = "lenses.json";
		String path = Config.IMPORT_JSON_PATH + "" + fileName;
		
		try {
			List<LensJsonDto> dtos = jsonParser.importJsonList(LensJsonDto.class, path);
			List<Lens> lenses = mapper.mapToList(dtos, Lens.class);
			lensService.save(lenses);
		} catch (IOException e) {
			System.out.println("ERROR: Can't import " + path);
		}
	}
	
}
