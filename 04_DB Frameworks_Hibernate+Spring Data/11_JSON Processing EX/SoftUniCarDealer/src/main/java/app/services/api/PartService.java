package app.services.api;

import java.util.List;

import app.entities.Part;

public interface PartService {
	
	void save(Part entity);
	
	void save(List<Part> entities);
	
	List<Part> findAll();
	
	Part findById(Long id);
	
}
