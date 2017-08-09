package app.services.api;

import java.util.List;

import app.domain.dtos.weddings.WeddingJsonDto;
import app.domain.entities.Wedding;

public interface WeddingService {

	void save(Wedding entity);
	
	List<Wedding> findAll();
	
	Wedding findOneById(Long id);
	
	Long count();
	
	void createFromWeddingJsonDto(List<WeddingJsonDto> entities);
	
}
