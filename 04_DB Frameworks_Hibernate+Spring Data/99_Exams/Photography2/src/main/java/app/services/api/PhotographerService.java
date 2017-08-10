package app.services.api;

import java.util.List;

import app.domain.dtos.photographers.PhotographerWithSameCamera;
import app.domain.dtos.photographers.PhotographerJsonDto;
import app.domain.dtos.photographers.PhotographerLandscapeJsonDto;
import app.domain.dtos.photographers.PhotographerOrderedJsonDto;
import app.domain.entities.Photographer;

public interface PhotographerService {

	void save(Photographer entity);
	
	List<Photographer> findAll();
	
	Photographer findOneById(Long id);
	
	Long count();
	
	void save(List<PhotographerJsonDto> entities);

	Photographer findByFullName(String trainerFullName);

	List<Photographer> findAllOrdered();
	
	List<PhotographerOrderedJsonDto> getPhotographerOrderedJsonDto();

	List<PhotographerLandscapeJsonDto> getLandscapePhotographersJsonDto();

	List<PhotographerWithSameCamera> getSameCamerasPhotographersJsonDto();
	
}
