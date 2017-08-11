package app.services.api;

import java.util.List;

import app.domain.dtos.weddings.WeddingDto;
import app.domain.dtos.weddings.WeddingExportJsonDto;
import app.domain.entities.Wedding;

public interface WeddingService {

	void save(Wedding entity);
	
	void save(List<Wedding> entity);
	
	List<Wedding> findAll();
	
	Wedding findOneById(Long id);
	
	Long count();

	void saveFromDto(List<WeddingDto> dtos);

	List<WeddingExportJsonDto> findAllWeddingExportJsonDtoOrdered();

	void checkedSave(Wedding entity);
	
}
