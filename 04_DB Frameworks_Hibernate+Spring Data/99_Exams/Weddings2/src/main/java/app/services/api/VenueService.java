package app.services.api;

import java.util.List;

import app.domain.dtos.venues.VenueXmlDto;
import app.domain.dtos.venues.VenueinSofiaXmlDto;
import app.domain.entities.Venue;

public interface VenueService {

	void save(Venue entity);
	
	void save(List<Venue> entity);
	
	List<Venue> findAll();
	
	Venue findOneById(Long id);
	
	Long count();

	void saveFromVenueXmlDtos(List<VenueXmlDto> venueXmlDtos);

	List<VenueinSofiaXmlDto> findAllVenuesInSofia();
	
}
