package app.services.api;

import java.util.List;

import app.domain.dtos.agencies.AgencyExportJsonDto;
import app.domain.dtos.agencies.TownXmlDto;
import app.domain.entities.Agency;

public interface AgencyService {

	void save(Agency entity);
	
	void save(List<Agency> entity);
	
	List<Agency> findAll();
	
	Agency findOneById(Long id);
	
	Long count();

	Agency findOneByName(String agencyName);

	List<AgencyExportJsonDto> findAllAgencyExportJsonDtoOrdered();

	List<TownXmlDto> findAllTownXmlDtos();
	
}
