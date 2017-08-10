package app.services.api;

import java.util.List;

import app.domain.dtos.accessories.AccessoryWrapperXmlDto;
import app.domain.entities.Accessory;

public interface AccessoryService {

	void save(Accessory entity);
		
	List<Accessory> findAll();
	
	Accessory findOneById(Long id);
	
	Long count();

	void save(AccessoryWrapperXmlDto accessoryWrapperXmlDto);
	
}
