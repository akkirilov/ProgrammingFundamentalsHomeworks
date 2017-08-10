package app.services.api;

import java.util.List;

import app.domain.dtos.workshops.LocationXmlDto;
import app.domain.dtos.workshops.WorkshopWrapperXmlDto;
import app.domain.entities.Workshop;

public interface WorkshopService {

	void save(Workshop entity);
	
	List<Workshop> findAll();
	
	Workshop findOneById(Long id);
	
	Long count();

	void save(WorkshopWrapperXmlDto wrapperXmlDto);

	List<LocationXmlDto> getWorkshopsByLocation();
	
}
