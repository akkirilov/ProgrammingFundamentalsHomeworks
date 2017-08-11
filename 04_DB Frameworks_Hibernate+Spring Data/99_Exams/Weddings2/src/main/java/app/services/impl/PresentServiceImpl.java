package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.presents.PresentXmlDto;
import app.domain.entities.Cash;
import app.domain.entities.Gift;
import app.domain.entities.Invitation;
import app.domain.entities.Person;
import app.domain.entities.Present;
import app.repositories.PresentRepository;
import app.services.api.InvitationService;
import app.services.api.PersonService;
import app.services.api.PresentService;
import app.utils.*;

@Service
public class PresentServiceImpl implements PresentService {
	
	private PresentRepository repository;
	private InvitationService invitationService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public PresentServiceImpl(PresentRepository repository,
							InvitationService invitationService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.invitationService = invitationService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Present entity) {
		try {
			repository.save(entity);
			System.out.println("Successfully imported gift from "
					+ entity.getOwner().getFullName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	public Present saveAndGet(Present entity) {
		Present toReturn = null;
		try {
			toReturn = repository.save(entity);
			System.out.println("Successfully imported gift from "
					+ entity.getOwner().getFullName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
		return toReturn;
	}
	
	@Override
	public void save(List<Present> entities) {
		for (Present e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Present> findAll() {
		return repository.findAll();
	}

	@Override
	public Present findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromPresentXmlDtos(List<PresentXmlDto> presentXmlDtos) {
		for (PresentXmlDto dto : presentXmlDtos) {
			if (dto.getType() == null
				|| dto.getInvitationId() == null) {
				continue;
			}
			Invitation tempInvitation = invitationService.findOneById(dto.getInvitationId());
			if (tempInvitation == null) {
				continue;
			}
			if (dto.getType().equals("gift")) {
				Gift tempGift = mapper.mapOne(dto, Gift.class);
				tempGift.setOwner(tempInvitation.getGuest());
				tempGift = (Gift) this.saveAndGet(tempGift);
				tempInvitation.setPresent(tempGift);
				invitationService.save(tempInvitation);
			} else if (dto.getType().equals("cash")) {
				Cash tempCash = mapper.mapOne(dto, Cash.class);
				tempCash.setOwner(tempInvitation.getGuest());
				tempCash = (Cash) this.saveAndGet(tempCash);
				tempInvitation.setPresent(tempCash);
				invitationService.save(tempInvitation);
			}
		}
	}

}
