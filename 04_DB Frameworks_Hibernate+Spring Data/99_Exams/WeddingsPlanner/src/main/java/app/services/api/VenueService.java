package app.services.api;

import java.util.List;

import app.domain.dtos.venues.VenueXmlDto;
import app.domain.entities.Venue;

public interface VenueService {

	void save(Venue entity);
	
	Venue saveAndGet(Venue entity);
	
	List<Venue> findAll();
	
	Venue findOneById(Long id);
	
	void createFromVenueXmlDto(List<VenueXmlDto> entities);
	
	Long count();

	List<Venue> findAllWithMoreThanThreeWeddings();
		
}
