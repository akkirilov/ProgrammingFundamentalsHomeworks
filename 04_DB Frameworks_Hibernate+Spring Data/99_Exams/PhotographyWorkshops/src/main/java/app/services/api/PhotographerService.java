package app.services.api;

import java.util.List;

import app.domain.dtos.photographers.PhotographerImportJsonDto;
import app.domain.entities.Photographer;

public interface PhotographerService {
	
	void create(Photographer photographer);

	void create(List<Photographer> photographers);

	void createFromJsonImport(List<PhotographerImportJsonDto> photographers);

	List<Photographer> findAll();

	List<Photographer> findAllOrderedByFirstAndLastNames();

	List<Photographer> findAllByOrderByFirstNameAsc();
	
}
