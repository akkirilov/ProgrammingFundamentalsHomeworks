package app.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.workshops.LocationXmlDto;
import app.domain.dtos.workshops.ParticipantByLocation;
import app.domain.dtos.workshops.ParticipantXmlDto;
import app.domain.dtos.workshops.ParticipantsWrapperXmlDto;
import app.domain.dtos.workshops.WorkshopByLocation;
import app.domain.dtos.workshops.WorkshopWrapperXmlDto;
import app.domain.dtos.workshops.WorkshopXmlDto;
import app.domain.entities.Photographer;
import app.domain.entities.Workshop;
import app.repositories.WorkshopRepository;
import app.services.api.PhotographerService;
import app.services.api.WorkshopService;
import app.utils.*;

@Service
public class WorkshopServiceImpl implements WorkshopService {
	
	private WorkshopRepository workshopRepository;
	private PhotographerService photographerService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public WorkshopServiceImpl(WorkshopRepository workshopRepository,
							PhotographerService photographerService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.workshopRepository = workshopRepository;
		this.photographerService = photographerService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Workshop entity) {
		try {
			workshopRepository.save(entity);
			System.out.println("Successfully imported "
					+ entity.getName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}

	@Override
	public List<Workshop> findAll() {
		return workshopRepository.findAll();
	}

	@Override
	public Workshop findOneById(Long id) {
		return workshopRepository.findOne(id);
	}

	@Override
	public Long count() {
		return workshopRepository.count();
	}

	@Override
	public void save(WorkshopWrapperXmlDto wrapperXmlDto) {
		for (WorkshopXmlDto w : wrapperXmlDto.getWorkshopXmlDtos()) {
			Workshop temp = mapper.mapOne(w, Workshop.class);
			Set<Photographer> tempPaticipants = new HashSet<>();
			if (w.getParticipants() != null && w.getParticipants().size() > 0) {
				for (ParticipantXmlDto p : w.getParticipants()) {
					tempPaticipants.add(photographerService.findByFullName(p.getFullName()));
				}				
			}
			temp.setParticipants(tempPaticipants);	
			
			temp.setTrainer(photographerService.findByFullName(w.getTrainerFullName()));
			this.save(temp);
		}
		
	}

	@Override
	public List<LocationXmlDto> getWorkshopsByLocation() {
		List<LocationXmlDto> dtos = new ArrayList<>();
		List<Workshop> workshops = workshopRepository.findAllByOrderByLocationAsc();
		String lastLocation = workshops.get(0).getLocation();
		LocationXmlDto tempLocation = new LocationXmlDto();
		List<WorkshopByLocation> tempWorkshops = new ArrayList<>();
		List<ParticipantByLocation> tempParticipants = new ArrayList<>();
		tempLocation.setName(lastLocation);
		for (Workshop w : workshops) {
			if (!w.getLocation().equals(lastLocation)) {
				tempLocation.setWorkshopByLocations(tempWorkshops);
				tempLocation.setName(lastLocation);
				dtos.add(tempLocation);
				lastLocation = w.getLocation();
				tempLocation = new LocationXmlDto();
				tempWorkshops = new ArrayList<>();
			}
			WorkshopByLocation tempWorkshop = mapper.mapOne(w, WorkshopByLocation.class);
			BigDecimal sum = w.getPricePerParticipant().multiply(BigDecimal.valueOf(w.getParticipants().size()));
			sum = sum.subtract(sum.multiply(BigDecimal.valueOf(0.2)));
			
			ParticipantsWrapperXmlDto participantsWrapper = new ParticipantsWrapperXmlDto();
			List<ParticipantByLocation> tempParticipantByWorkshop = mapper.mapToList(w.getParticipants(), ParticipantByLocation.class);
			participantsWrapper.setCount(tempParticipantByWorkshop.size());
			participantsWrapper.setParticipants(tempParticipantByWorkshop);
			tempWorkshop.setParticipantsWrapper(participantsWrapper);
			tempWorkshop.setTotalProfit(sum);
			tempWorkshops.add(tempWorkshop);
		}
		return dtos;
	}

}
