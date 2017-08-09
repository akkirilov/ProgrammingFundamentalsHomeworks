package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.workshops.ParticipantImportXmlDto;
import app.domain.dtos.workshops.WorkshopImportXmlDto;
import app.domain.entities.Photographer;
import app.domain.entities.Workshop;
import app.repositories.PhotographerRepository;
import app.repositories.WorkshopRepository;
import app.services.api.WorkshopService;
import app.utils.Mapper;

@Service
public class WorkshopServiceImpl implements WorkshopService {

	private WorkshopRepository workshopRepository;
	private PhotographerRepository photographyRepository;

	@Autowired
	public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographyRepository) {
		super();
		this.photographyRepository = photographyRepository;
		this.workshopRepository = workshopRepository;
	}

	@Override
	public void create(Workshop workshop) {
		try {
			workshopRepository.save(workshop);
			System.out.println("Successfully imported " 
					+ workshop.getName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public void create(List<Workshop> workshops) {
		for (Workshop workshop : workshops) {
			this.create(workshop);
		}
	}

	@Override
	public void createFromJsonImport(List<WorkshopImportXmlDto> workshopImportXmlDtos) {
		workshopImportXmlDtos = Mapper.mapToList(workshopImportXmlDtos, WorkshopImportXmlDto.class);
		for (WorkshopImportXmlDto workshopImportXmlDto : workshopImportXmlDtos) {
			Workshop workshop = Mapper.mapOne(workshopImportXmlDto, Workshop.class);
			Photographer trainer = photographyRepository.findByFullName(workshopImportXmlDto.getTrainerName());
			workshop.setTrainer(trainer);
			for (ParticipantImportXmlDto paricipant : workshopImportXmlDto.getParticipantImportXmlDto()) {
				Photographer temp = photographyRepository.findByFirstNameAndLastName(paricipant.getFirstName(), paricipant.getLastName());
				workshop.addParticipant(temp);
			}
			this.create(workshop);
		}
		
	}

	@Override
	public List<Workshop> findAllByOrderByLocation() {
		return this.workshopRepository.findAllByOrderByLocation();
	}
}
