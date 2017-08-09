package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.agencies.AgencyJsonDto;
import app.domain.entities.Agency;
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

}
