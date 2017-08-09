package app;

import static org.mockito.Matchers.contains;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.Config;
import app.domain.dtos.accesoaries.AccessoryWrapperDto;
import app.domain.dtos.cameras.CameraImportJsonDto;
import app.domain.dtos.lenses.LensImportJsonDto;
import app.domain.dtos.photographers.LandscapePhotographerExportJsonDto;
import app.domain.dtos.photographers.LensExportXmlDto;
import app.domain.dtos.photographers.PhotographerExportJsonDto;
import app.domain.dtos.photographers.PhotographerImportJsonDto;
import app.domain.dtos.photographers.PhotographerWrapperDto;
import app.domain.dtos.photographers.PhotographersWithSameCamerasExportXmlDto;
import app.domain.dtos.workshops.LocationDto;
import app.domain.dtos.workshops.LocationWrapperDto;
import app.domain.dtos.workshops.ParticipantDto;
import app.domain.dtos.workshops.ParticipantsDto;
import app.domain.dtos.workshops.WorkshopByLocationDto;
import app.domain.dtos.workshops.WorkshopWrapperDto;
import app.domain.entities.Accessory;
import app.domain.entities.DSLRCamera;
import app.domain.entities.Lens;
import app.domain.entities.MirrorlessCamera;
import app.domain.entities.Photographer;
import app.domain.entities.Workshop;
import app.services.api.AccessoryService;
import app.services.api.CameraService;
import app.services.api.LensService;
import app.services.api.PhotographerService;
import app.services.api.WorkshopService;
import app.utils.JsonParser;
import app.utils.Mapper;
import app.utils.XmlParser;

@Component
public class ConsoleRunner implements CommandLineRunner{
    
	private final CameraService cameraService;
	private final LensService lensService;
	private final AccessoryService accessoryService;
	private final WorkshopService workshopService;
	private final PhotographerService photographerService;
	private final JsonParser jsonParser;
	private final XmlParser xmlParser;
	
	@Autowired
	public ConsoleRunner(CameraService cameraService, JsonParser jsonParser,
							LensService lensService, PhotographerService photographerService,
							XmlParser xmlParser, AccessoryService accessoryService,
							WorkshopService workshopService) {
		this.cameraService = cameraService;
		this.jsonParser = jsonParser;
		this.lensService = lensService;
		this.photographerService = photographerService;
		this.xmlParser = xmlParser;
		this.accessoryService = accessoryService;
		this.workshopService = workshopService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		initializeCameras();
		initializeLenses();
		initializePhotographers();
		initializeAccessories();
		initializeWorkshops();
		
		exportPhotographersOrderedByFirstAndLastNames();
		exportLandscapePhotographers();
		exportSameCamerasPhotographers();
		exportWorkshopsByLocation();
		
	}

	private void exportWorkshopsByLocation() {
		String currentLocation = null;
		LocationDto locationDto = null;
		LocationWrapperDto locationWrapperDto = new LocationWrapperDto();
		List<Workshop> workshops = workshopService.findAllByOrderByLocation();
		for (Workshop w : workshops) {
			if (currentLocation == null || !currentLocation.equals(w.getLocation())) {
				currentLocation = w.getLocation();
				locationDto = new LocationDto();
				locationDto.setName(currentLocation);
			}
			WorkshopByLocationDto workshopByLocationDto = Mapper.mapOne(w, WorkshopByLocationDto.class);
			ParticipantsDto participantsDto = new ParticipantsDto();
			participantsDto.setParticipants(workshopByLocationDto.getParticipants());
			workshopByLocationDto.setWorkshopParticipants(participantsDto);
			locationDto.addWorkshopByLocationDtos(workshopByLocationDto);
			locationWrapperDto.addLocationDtos(locationDto);
		}
		try {
			xmlParser.exportXml(locationWrapperDto, Config.EXPORT_XML_PATH + "workshops-by-location.xml");
		} catch (IOException | JAXBException e) {
			System.out.println("ERROR: Can't export to " + "workshops-by-location.xml");
		}
	}

	private void exportSameCamerasPhotographers() {
		List<Photographer> photographers = photographerService.findAllByOrderByFirstNameAsc();
		for (int i = 0; i < photographers.size(); i++) {
			if (photographers.get(i).getPrimaryCamera() == null
					|| photographers.get(i).getSecondaryCamera() == null
					|| !photographers.get(i).getPrimaryCamera().getMake().equals(photographers.get(i).getSecondaryCamera().getMake())
					|| photographers.get(i).getLenses() == null
					|| photographers.get(i).getLenses().size() < 1) {
				photographers.remove(i);
				i--;
			}
		}
		
		List<PhotographersWithSameCamerasExportXmlDto> photographersWithSameCamerasExportXmlDtos 
			= Mapper.mapToList(photographers, PhotographersWithSameCamerasExportXmlDto.class);
		PhotographerWrapperDto photographerWrapperDto = new PhotographerWrapperDto();
		photographerWrapperDto.setPhotographersWithSameCamerasExportXmlDtos(photographersWithSameCamerasExportXmlDtos);

		try {
			xmlParser.exportXml(photographerWrapperDto, Config.EXPORT_XML_PATH + "same-cameras-photographers.xml");
		} catch (IOException | JAXBException e) {
			System.out.println("ERROR: Can't export to " + "same-cameras-photographers.xml");
		}
	}

	private void exportLandscapePhotographers() {
		List<Photographer> photographers = photographerService.findAllByOrderByFirstNameAsc();
		for (int i = 0; i < photographers.size(); i++) {
			Boolean haveMoreTham30mm = false;
			for (Lens lens : photographers.get(i).getLenses()) {
				if (lens.getFocalLength() > 30) {
					haveMoreTham30mm = true;
					break;
				}
			}
			if (!photographers.get(i).getPrimaryCamera().getClass().getAnnotation(DiscriminatorValue.class).value().equals("DSLR")
					|| photographers.get(i).getLenses() == null
					|| photographers.get(i).getLenses().size() < 1
					|| haveMoreTham30mm) {
				photographers.remove(i);
				i--;
			}
		}

		List<LandscapePhotographerExportJsonDto> landscapePhotographerExportJsonDtos = Mapper.mapToList(photographers, LandscapePhotographerExportJsonDto.class);
		for (LandscapePhotographerExportJsonDto landscapePhotographerExportJsonDto : landscapePhotographerExportJsonDtos) {
			landscapePhotographerExportJsonDto.setLensesCount(landscapePhotographerExportJsonDto.getLenses().size());
		}
		try {
			jsonParser.exportJson(landscapePhotographerExportJsonDtos, Config.EXPORT_JSON_PATH + "landscape-photographers.json");
		} catch (IOException e) {
			System.out.println("ERROR: Can't export to " + "landscape-photographers.json");
		}
	}

	private void exportPhotographersOrderedByFirstAndLastNames() {
		List<Photographer> photographers = photographerService.findAllOrderedByFirstAndLastNames();
		List<PhotographerExportJsonDto> photographerExportJsonDtos = Mapper.mapToList(photographers, PhotographerExportJsonDto.class);
		try {
			jsonParser.exportJson(photographerExportJsonDtos, Config.EXPORT_JSON_PATH + "photographers-ordered.json");
		} catch (IOException e) {
			System.out.println("ERROR: Can't export to " + "photographers-ordered.json");
		}
	}

	private void initializeWorkshops() {
		
		WorkshopWrapperDto workshopWrapperDto = null;
		try {
			workshopWrapperDto = xmlParser.importXml(WorkshopWrapperDto.class, Config.IMPORT_XML_PATH + "workshops.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		workshopService.createFromJsonImport(workshopWrapperDto.getWorkshopImportXmlDto());
	}

	private void initializeAccessories() {
		AccessoryWrapperDto accessoryWrapperDto = null;
		try {
			accessoryWrapperDto = xmlParser.importXml(AccessoryWrapperDto.class, Config.IMPORT_XML_PATH + "accessories.xml");
		} catch (JAXBException e) {
			System.out.println("ERROR: Can't parse " + "accessories.xml");
		} catch (IOException e) {
			System.out.println("ERROR: Can't read " + "accessories.xml");
		}
		List<Accessory> accessories = Mapper.mapToList(accessoryWrapperDto.getAccessoryImportXmlDto(), Accessory.class);
		List<Photographer> photographers = photographerService.findAll();
		Random random = new Random();
		for (Accessory accessory : accessories) {
			accessory.setOwner(photographers.get(random.nextInt(photographers.size())));
		}
		accessoryService.create(accessories);
	}

	private void initializeCameras() {
		try {
			List<CameraImportJsonDto> cameraImportJsonDtos = jsonParser.importJsonList(CameraImportJsonDto.class, Config.IMPORT_JSON_PATH + "cameras.json");
			cameraImportJsonDtos = Mapper.mapToList(cameraImportJsonDtos, CameraImportJsonDto.class);
			for (CameraImportJsonDto c : cameraImportJsonDtos) {
				if (c.getType() != null && c.getType().equals("Mirrorless")) {
					cameraService.create(Mapper.mapOne(c, MirrorlessCamera.class));
				} else if (c.getType() != null && c.getType().equals("DSLR")) {
					cameraService.create(Mapper.mapOne(c, DSLRCamera.class));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void initializeLenses() {
		try {
			List<LensImportJsonDto> lensImportDtos = jsonParser.importJsonList(LensImportJsonDto.class, Config.IMPORT_JSON_PATH + "lenses.json");
			List<Lens> lenses = Mapper.mapToList(lensImportDtos, Lens.class);
			lensService.create(lenses);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void initializePhotographers() {
		try {
			List<PhotographerImportJsonDto> photographImportDtos = jsonParser.importJsonList(PhotographerImportJsonDto.class, Config.IMPORT_JSON_PATH + "photographers.json");
			photographerService.createFromJsonImport(photographImportDtos);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
