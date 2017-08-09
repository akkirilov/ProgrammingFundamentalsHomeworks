package app.services.api;

import java.util.List;

import app.domain.dtos.workshops.WorkshopImportXmlDto;
import app.domain.entities.Workshop;

public interface WorkshopService {
	
	void create(Workshop workshop);

	void create(List<Workshop> workshops);
	
	void createFromJsonImport(List<WorkshopImportXmlDto> workshopImportXmlDtos);

	List<Workshop> findAllByOrderByLocation();
	
}
