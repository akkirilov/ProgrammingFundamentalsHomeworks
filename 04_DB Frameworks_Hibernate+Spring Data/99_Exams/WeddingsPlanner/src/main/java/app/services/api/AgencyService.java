package app.services.api;

import java.util.List;

import app.domain.dtos.agencies.AgencyJsonDto;
import app.domain.entities.Agency;

public interface AgencyService {

	void save(Agency entity);
	
	List<Agency> findAll();
	
	Agency findOneById(Long id);
	
	Long count();
	
	void createFromAgencyJsonDto(List<AgencyJsonDto> entities);
	
	Agency findOneByName(String name);
	
}
