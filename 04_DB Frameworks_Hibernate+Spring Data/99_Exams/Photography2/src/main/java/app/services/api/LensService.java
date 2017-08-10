package app.services.api;

import java.util.List;
import java.util.Set;

import app.domain.entities.Lens;

public interface LensService {

	void save(Lens entity);
	
	List<Lens> findAll();
	
	Lens findOneById(Long id);
	
	Long count();

	void save(List<Lens> entities);

	Set<Lens> findAllByIdInList(Set<Long> ids);
	
}
