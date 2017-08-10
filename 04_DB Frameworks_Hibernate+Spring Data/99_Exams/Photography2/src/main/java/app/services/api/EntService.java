package app.services.api;

import java.util.List;

import app.domain.entities.Ent;

public interface EntService {

	Ent save(Ent entity);
	
	List<Ent> findAll();
	
	Ent findOneById(Long id);
	
	Long count();
	
}
