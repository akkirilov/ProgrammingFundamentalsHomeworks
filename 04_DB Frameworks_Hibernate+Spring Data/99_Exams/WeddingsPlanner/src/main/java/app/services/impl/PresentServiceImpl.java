package app.services.impl;

import static org.mockito.Matchers.endsWith;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.presents.*;
import app.domain.entities.Cash;
import app.domain.entities.Gift;
import app.domain.entities.Invitation;
import app.domain.entities.Person;
import app.domain.entities.Present;
import app.repositories.PresentRepository;
import app.services.api.InvitationService;
import app.services.api.PresentService;
import app.utils.*;

@Service
public class PresentServiceImpl implements PresentService {
	
	private PresentRepository presentRepository;
	InvitationService invitationService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public PresentServiceImpl(PresentRepository presentRepository,
							InvitationService invitationService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.presentRepository = presentRepository;
		this.invitationService = invitationService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Present entity) {
		try {
			presentRepository.save(entity);
			System.out.println("Successfully imported gift from "
					+ entity.getOwner().getFullName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public List<Present> findAll() {
		return presentRepository.findAll();
	}

	@Override
	public Present findOneById(Long id) {
		return presentRepository.findOne(id);
	}

	@Override
	public Long count() {
		return presentRepository.count();
	}

	@Override
	public Present saveAndGet(Present entity) {
		Present toReturn = null;
		try {
			toReturn = presentRepository.save(entity);
		} catch (Exception e) {
		}
		return toReturn;
	}

	@Override
	public void createFromVenueXmlDto(List<PresentXmlDto> entities) {
		for (PresentXmlDto p : entities) {
			Invitation invitation = null;
			Person owner = null;
			if (p.getInvitationId() != null) {
				invitation = invitationService.findOneById(p.getInvitationId());
				if (invitation != null) {
					owner = invitationService.findOneById(p.getInvitationId()).getGuest();									
				}
			}
			if (null != p.getType()
					&& p.getType().equals("gift")) {
				Gift tempGift = Mapper.mapOne(p, Gift.class);
				if (owner != null) {
					tempGift.setOwner(owner);					
				}
				this.save(tempGift);
			} else if (null != p.getType()
					&& p.getType().equals("cash")) {
				Cash tempCash = Mapper.mapOne(p, Cash.class);
				if (owner != null) {
					tempCash.setOwner(owner);					
				}
				this.save(tempCash);
			}
		}
		
		
	}


}
