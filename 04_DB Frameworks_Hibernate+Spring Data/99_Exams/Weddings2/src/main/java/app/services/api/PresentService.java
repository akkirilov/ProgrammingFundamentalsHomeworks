package app.services.api;

import java.util.List;

import app.domain.dtos.presents.PresentXmlDto;
import app.domain.entities.Present;

public interface PresentService {

	void save(Present entity);
	
	void save(List<Present> entity);
	
	List<Present> findAll();
	
	Present findOneById(Long id);
	
	Long count();

	void saveFromPresentXmlDtos(List<PresentXmlDto> presentXmlDtos);
	
}
