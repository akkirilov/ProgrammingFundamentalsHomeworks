package app.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.agencies.AgenciesByTownXmlDto;
import app.domain.dtos.agencies.AgencyJsonDto;
import app.domain.dtos.agencies.TownXmlDto;
import app.domain.dtos.persons.GuestByWeddingByAgencyXmlDto;
import app.domain.dtos.weddings.WeddingByAgencyXmlDto;
import app.domain.entities.Agency;
import app.domain.entities.Cash;
import app.domain.entities.Gift;
import app.domain.entities.Invitation;
import app.domain.entities.Wedding;
import app.domain.enums.Size;
import app.repositories.AgencyRepository;
import app.services.api.AgencyService;
import app.utils.*;

@Service
public class AgencyServiceImpl implements AgencyService {
	
	private AgencyRepository agencyRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public AgencyServiceImpl(AgencyRepository agencyRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.agencyRepository = agencyRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Agency entity) {
		try {
			agencyRepository.save(entity);
			System.out.println("Successfully imported " + entity.getName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public List<Agency> findAll() {
		return agencyRepository.findAll();
	}

	@Override
	public Agency findOneById(Long id) {
		return agencyRepository.findOne(id);
	}

	@Override
	public Long count() {
		return agencyRepository.count();
	}

	@Override
	public void createFromAgencyJsonDto(List<AgencyJsonDto> entities) {
		List<Agency> agencies = Mapper.mapToList(entities, Agency.class);
		for (Agency agency : agencies) {
			this.save(agency);
		}
	}

	@Override
	public Agency findOneByName(String name) {
		return agencyRepository.findFirstByName(name);
	}

	@Override
	public List<Agency> findAllAgnciesOrdered() {
		return agencyRepository.findAllByOrderByEmployeesCountDescNameAsc();
	}

	@Override
	public List<Agency> findAllByOrderByTownAsc() {
		return  agencyRepository.findAllByOrderByTownAsc();
	}

	@Override
	public List<TownXmlDto> getAllTownXmlDtos() {
		List<TownXmlDto> townXmlDto = new ArrayList<>();
		List<AgenciesByTownXmlDto>agenciesByTownXmlDtos = new ArrayList<>();
		String lastTown = null;
		List<Agency> agencies = this.findAllByOrderByTownAsc();
		TownXmlDto tempTown = new TownXmlDto();
		for (Agency agency : agencies) {
			List<WeddingByAgencyXmlDto> weddingByAgencyXmlDtos = new ArrayList<>();
			AgenciesByTownXmlDto agencyDto = Mapper.mapOne(agency, AgenciesByTownXmlDto.class);
			BigDecimal totalSum = BigDecimal.ZERO;
			Integer giftsCount = 0;
			for (Wedding w : agency.getWeddings()) {
				List<GuestByWeddingByAgencyXmlDto> guestByWeddingByAgencyXmlDtos = new ArrayList<>();
				for (Invitation i : w.getInvitations()) {
					GuestByWeddingByAgencyXmlDto tempGuest = new GuestByWeddingByAgencyXmlDto();
					if (i.getPresent() == null) {
						continue;
					}
					tempGuest.setFamily(i.getFamily());
					tempGuest.setGuestFullName(i.getGuest().getFullName());
					guestByWeddingByAgencyXmlDtos.add(tempGuest);
					if (i.getPresent().getClass().getAnnotation(DiscriminatorValue.class).value().equals("cash")) {
						Cash tempCash = (Cash)i.getPresent();
						totalSum = totalSum.add(tempCash.getCashAmount());
					} else {
						Gift tempGift = (Gift)i.getPresent();
						if (!tempGift.getSize().equals(Size.NotSpecified)) {
							giftsCount++;
						}
					}
				}
				WeddingByAgencyXmlDto weddingDto = Mapper.mapOne(w, WeddingByAgencyXmlDto.class);
				weddingDto.setCash(totalSum);
				weddingDto.setGuests(guestByWeddingByAgencyXmlDtos);
				weddingDto.setPresents(giftsCount);
				weddingByAgencyXmlDtos.add(weddingDto);
			}
			agencyDto.setWeddings(weddingByAgencyXmlDtos);
			agencyDto.setProfit(totalSum.multiply(BigDecimal.valueOf(0.2)));
			agenciesByTownXmlDtos.add(agencyDto);
			if (lastTown == null || !agency.getTown().equals(lastTown)) {
				lastTown = agency.getTown();
				tempTown.setName(lastTown);
				tempTown.setAgenciesByTownXmlDtos(agenciesByTownXmlDtos);
				agenciesByTownXmlDtos = new ArrayList<>();
				townXmlDto.add(tempTown);
				tempTown = new TownXmlDto();
			}
		}
		
		return townXmlDto;
	}

}
