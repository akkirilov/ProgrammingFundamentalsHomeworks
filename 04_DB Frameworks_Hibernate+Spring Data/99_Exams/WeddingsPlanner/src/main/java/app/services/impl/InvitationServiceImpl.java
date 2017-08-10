package app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.agencies.AgencyBasicJsonDto;
import app.domain.dtos.persons.GuestsListJsonDto;
import app.domain.dtos.weddings.WeddingBasicJsonDto;
import app.domain.entities.Invitation;
import app.domain.enums.Family;
import app.repositories.InvitationRepository;
import app.services.api.InvitationService;
import app.services.api.WeddingService;
import app.utils.*;

@Service
public class InvitationServiceImpl implements InvitationService {
	
	private InvitationRepository invitationRepository;
	private WeddingService weddingService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public InvitationServiceImpl(InvitationRepository invitationRepository, 
							WeddingService weddingService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.invitationRepository = invitationRepository;
		this.weddingService = weddingService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Invitation entity) {
		try {
			invitationRepository.save(entity);
		} catch (Exception e) {
		}
	}

	@Override
	public List<Invitation> findAll() {
		return invitationRepository.findAll();
	}

	@Override
	public Invitation findOneById(Long id) {
		return invitationRepository.findOne(id);
	}

	@Override
	public Long count() {
		return invitationRepository.count();
	}

	@Override
	public Invitation saveAndGet(Invitation entity) {
		Invitation toReturn = null;
		try {
			toReturn = invitationRepository.save(entity);
		} catch (Exception e) {
		}
		return toReturn;
	}
	
	public List<GuestsListJsonDto> findAllGuestsListJsonDto(){
		List<GuestsListJsonDto> guestsListJsonDto = new ArrayList<>();
		List<WeddingBasicJsonDto> weddingBasicJsonDto = Mapper.mapToList(weddingService.findAll(), WeddingBasicJsonDto.class);
		for (WeddingBasicJsonDto wedding : weddingBasicJsonDto) {
			Integer attendings = 0;
			Integer fromBride = 0;
			Integer fromBrideroom = 0;
			Integer total = wedding.getInvitations().size();
			List<String> guests = new ArrayList<>();
			GuestsListJsonDto temp = new GuestsListJsonDto();
			for (Invitation inv : wedding.getInvitations()) {
				if (inv.getAttending() != null
					&& inv.getAttending() == true) {
					attendings++;
				}
				if (inv.getFamily().equals(Family.Bride)) {
					fromBride++;
				}
				if (inv.getFamily().equals(Family.Bridegroom)) {
					fromBrideroom++;
				}
				guests.add(inv.getGuest().getFullName());
			}
			temp.setAttendingGuests(attendings);
			temp.setBridegroomGuests(fromBrideroom);
			temp.setBrideGuests(fromBride);
			temp.setInvitedGuests(total);
			temp.setGuests(guests);
			temp.setBride(wedding.getBrideFullName());
			temp.setBrideroom(wedding.getBridegroomFullName());
			temp.setAgency(Mapper.mapOne(wedding.getAgency(), AgencyBasicJsonDto.class));
			guestsListJsonDto.add(temp);			
		}
		return guestsListJsonDto;
	}

}
