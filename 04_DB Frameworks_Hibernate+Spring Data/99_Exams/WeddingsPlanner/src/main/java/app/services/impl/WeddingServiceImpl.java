package app.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.invitations.InvitationJsonDto;
import app.domain.dtos.weddings.WeddingJsonDto;
import app.domain.entities.Invitation;
import app.domain.entities.Person;
import app.domain.entities.Wedding;
import app.repositories.PersonRepository;
import app.repositories.WeddingRepository;
import app.services.api.AgencyService;
import app.services.api.PersonService;
import app.services.api.WeddingService;
import app.utils.*;

@Service
public class WeddingServiceImpl implements WeddingService {
	
	private WeddingRepository weddingRepository;
	private PersonService personService;
	private AgencyService agencyService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public WeddingServiceImpl(WeddingRepository weddingRepository,
							PersonService personService,
							AgencyService agencyService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.weddingRepository = weddingRepository;
		this.personService = personService;
		this.agencyService = agencyService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Wedding entity) {
		try {
			weddingRepository.save(entity);
			System.out.println("Successfully imported " );
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public List<Wedding> findAll() {
		return weddingRepository.findAll();
	}

	@Override
	public Wedding findOneById(Long id) {
		return weddingRepository.findOne(id);
	}

	@Override
	public Long count() {
		return weddingRepository.count();
	}

	@Override
	public void createFromWeddingJsonDto(List<WeddingJsonDto> entities) {
		
		for (WeddingJsonDto weddingJsonDto : entities) {
			Wedding wedding = Mapper.mapOne(weddingJsonDto, Wedding.class);
			wedding.setBride(personService.findByFullName(weddingJsonDto.getBride()));
			wedding.setBridegroom(personService.findByFullName(weddingJsonDto.getBridegroom()));
			wedding.setAgency(agencyService.findOneByName(weddingJsonDto.getAgencyName()));

			Set<Invitation> invitations = new HashSet<>();
			for (InvitationJsonDto invitationJsonDto : weddingJsonDto.getGuests()) {
				Invitation invitation = Mapper.mapOne(invitationJsonDto, Invitation.class);
				
				invitation.setGuest(personService.findByFullName(invitationJsonDto.getName()));
				invitations.add(invitation);
			}
			wedding.setInvitations(invitations);
			this.save(wedding);
		}
	
	}

}
