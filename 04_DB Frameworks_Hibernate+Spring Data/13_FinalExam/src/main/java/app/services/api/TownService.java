package app.services.api;

import java.util.List;

import app.domain.dtos.towns.TownJsonDto;
import app.domain.dtos.towns.TownXmlDto;
import app.domain.entities.Town;

public interface TownService {

	void save(Town town);
	
	void save(List<Town> towns);
	
	List<Town> findAll();
	
	Town findOneById(Long id);
	
	Long count();

	void saveFromDto(List<TownJsonDto> dtos);

	Town findOneByName(String name);

	List<TownXmlDto> findAllTownsWithClients();
	
}
