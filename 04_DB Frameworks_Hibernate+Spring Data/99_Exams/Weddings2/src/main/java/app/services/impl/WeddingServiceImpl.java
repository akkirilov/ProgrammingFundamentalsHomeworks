package app.services.impl;

import static org.assertj.core.api.Assertions.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.invitations.InvitationDto;
import app.domain.dtos.weddings.WeddingDto;
import app.domain.dtos.weddings.WeddingExportJsonDto;
import app.domain.entities.Invitation;
import app.domain.entities.Person;
import app.domain.entities.Wedding;
import app.domain.enums.Family;
import app.repositories.WeddingRepository;
import app.services.api.AgencyService;
import app.services.api.InvitationService;
import app.services.api.PersonService;
import app.services.api.WeddingService;
import app.utils.*;

@Service
public class WeddingServiceImpl implements WeddingService {
	
	private WeddingRepository repository;
	private PersonService personService;
	private AgencyService agencyService;
	private InvitationService invitationService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public WeddingServiceImpl(WeddingRepository repository, 
							PersonService personService,
							AgencyService agencyService,
							InvitationService invitationService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.personService = personService;
		this.agencyService = agencyService;
		this.invitationService = invitationService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Wedding entity) {
		try {
			repository.save(entity);
			System.out.println("Successfully imported wedding of "
					+ entity.getBride().getFirstName() + " and "
					+ entity.getBridegroom().getFirstName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void checkedSave(Wedding entity) {
		repository.save(entity);
	}
	
	public Wedding saveAndGet(Wedding entity) {
		Wedding toReturn = null;
		try {
			toReturn = repository.save(entity);
			System.out.println("Successfully imported wedding of "
					+ entity.getBride().getFirstName() 
					+ entity.getBridegroom().getFirstName());
			return toReturn;
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
		return toReturn;
	}
	
	@Override
	public void save(List<Wedding> entities) {
		for (Wedding e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Wedding> findAll() {
		return repository.findAll();
	}

	@Override
	public Wedding findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(List<WeddingDto> dtos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		for (WeddingDto dto : dtos) {
			Wedding tempWedding = new Wedding();
			try {
				tempWedding.setDate(sdf.parse(dto.getStringovaData()));
			} catch (ParseException e) {
				System.out.println("Cant parse " + dto.getStringovaData() + " to java.util.Date");
			}
			tempWedding.setAgency(agencyService.findOneByName(dto.getAgencyName()));
			tempWedding.setBride(personService.findByFullName(dto.getBride()));
			tempWedding.setBridegroom(personService.findByFullName(dto.getBridegroom()));
			tempWedding = this.saveAndGet(tempWedding);
			
			if (dto.getInvitations() != null && tempWedding != null ) {
				for (InvitationDto invitationDto : dto.getInvitations()) {
					Invitation tempInvitation = mapper.mapOne(invitationDto, Invitation.class);
					Person tempGuest = personService.findByFullName(invitationDto.getFullName());
					if (tempGuest == null) {
						continue;
					}
					tempInvitation.setGuest(tempGuest);
					tempInvitation.setWedding(tempWedding);
					invitationService.save(tempInvitation);
				}			
			}
			
		}
	}

	@Override
	public List<WeddingExportJsonDto> findAllWeddingExportJsonDtoOrdered() {
		List<WeddingExportJsonDto> dtos = mapper.mapToList(repository.findAll(), WeddingExportJsonDto.class);
		for (WeddingExportJsonDto w : dtos) {
			w.setTotalGuests(w.getInvitations().size());
			Integer attendingGuests = 0;
			Integer brideGuests = 0;
			Integer bridegroomGuests = 0;
			List<String> guestsList = new ArrayList<>();
			for (Invitation i : w.getInvitations()) {
				if (i.getAttending() != null && i.getAttending()) {
					attendingGuests++;
				}
				if (i.getFamily().equals(Family.Bride)) {
					brideGuests++;
				} else {
					bridegroomGuests++;
				}
				guestsList.add(i.getGuest().getFullName());
			}
			w.setBridegroomGuests(bridegroomGuests);
			w.setBrideGuests(brideGuests);
			w.setAttendingGuests(attendingGuests);
			w.setGuestList(guestsList);
		}
		
		dtos = dtos
				.stream()
				.sorted((a, b) -> {
					int res = b.getTotalGuests().compareTo(a.getTotalGuests());
					if (res == 0) {
						res = a.getAttendingGuests().compareTo(b.getAttendingGuests());
					}
					return res;
				})
				.collect(Collectors.toList());
		
		return dtos;
	}

}
