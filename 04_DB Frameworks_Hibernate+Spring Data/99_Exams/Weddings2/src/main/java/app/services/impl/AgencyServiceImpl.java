package app.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.agencies.AgencyByTownXmlDto;
import app.domain.dtos.agencies.AgencyExportJsonDto;
import app.domain.dtos.agencies.GuestByWeddingXmlDto;
import app.domain.dtos.agencies.TownXmlDto;
import app.domain.dtos.agencies.WeddingByAgencyXmlDto;
import app.domain.entities.Agency;
import app.domain.entities.Cash;
import app.domain.entities.Gift;
import app.domain.entities.Invitation;
import app.repositories.AgencyRepository;
import app.services.api.AgencyService;
import app.utils.*;

@Service
public class AgencyServiceImpl implements AgencyService {
	
	private AgencyRepository repository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public AgencyServiceImpl(AgencyRepository repository, 
							JsonParser jsonParser,
							XmlParser xmlParser,
						 Mapper mapper) {
		super();
		this.repository = repository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Agency entity) {
		try {
			repository.save(entity);
			System.out.println("Successfully imported "
						+ entity.getName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void save(List<Agency> entities) {
		for (Agency e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Agency> findAll() {
		return repository.findAll();
	}

	@Override
	public Agency findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Agency findOneByName(String agencyName) {
		return repository.findFirstByName(agencyName);
	}

	@Override
	public List<AgencyExportJsonDto> findAllAgencyExportJsonDtoOrdered() {
		return mapper.mapToList(repository.findAllByOrderByEmployeesCountDescNameAsc(), AgencyExportJsonDto.class);
	}

	@Override
	public List<TownXmlDto> findAllTownXmlDtos() {
		List<TownXmlDto> towns = new ArrayList<>();
		
		List<Agency> agencies = repository.findAllByTownAndWeddingsCount();
		if (agencies == null || agencies.size() < 1) {
			return towns;
		}
		
		String lastTown = agencies.get(0).getTown();
		TownXmlDto tempTown = new TownXmlDto();
		List<AgencyByTownXmlDto> agenciesByTown = new ArrayList<>();
		for (Agency agency : agencies) {
			if (!agency.getTown().equals(lastTown)) {
				tempTown.setAgencyByTownXmlDtos(agenciesByTown);
				tempTown.setName(lastTown);
				towns.add(tempTown);
				
				agenciesByTown = new ArrayList<>();
				tempTown = new TownXmlDto();
				lastTown = agency.getTown();
			}
			
			BigDecimal profit = BigDecimal.ZERO;
			BigDecimal cash = BigDecimal.ZERO;
			Integer giftsCount = 0;
			
			AgencyByTownXmlDto tempAgency = mapper.mapOne(agency, AgencyByTownXmlDto.class);
			List<WeddingByAgencyXmlDto> tempWeddings = mapper.mapToList(tempAgency.getWeddings(), WeddingByAgencyXmlDto.class);
			List<GuestByWeddingXmlDto> guestByWeddingXmlDtos = new ArrayList<>();
			for (WeddingByAgencyXmlDto w : tempWeddings) {
				for (Invitation i : w.getInvitations()) {
					GuestByWeddingXmlDto tempGuest = new GuestByWeddingXmlDto();
					tempGuest.setFamily(i.getFamily().name());
					tempGuest.setGuestFullName(i.getGuest().getFullName());
					guestByWeddingXmlDtos.add(tempGuest);
					if (i.getPresent() == null) {
						continue;
					}
					String type = i.getPresent().getClass().getAnnotation(DiscriminatorValue.class).value();
					if (type.equals("cash")) {
						Cash tempCash = (Cash) i.getPresent();
						cash = cash.add(tempCash.getCashAmount());
					} else {
						giftsCount++;
					}
					
				}
				w.setGuestByWeddingXmlDtos(guestByWeddingXmlDtos);
				w.setCash(cash);
				w.setGiftsCount(giftsCount);
				profit = profit.add(cash);
			}
			
			profit = profit.multiply(BigDecimal.valueOf(0.2));
			tempAgency.setProfit(profit);
			tempAgency.setWeddingsByAgencies(tempWeddings);
			agenciesByTown.add(tempAgency);

		}
		
		return towns;
	}

}
