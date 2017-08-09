package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.venues.VenueXmlDto;
import app.domain.entities.Venue;
import app.repositories.VenueRepository;
import app.services.api.VenueService;
import app.utils.*;

@Service
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository venueRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public VenueServiceImpl(VenueRepository venueRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.venueRepository = venueRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Venue entity) {
		try {
			venueRepository.save(entity);
			System.out.println("Successfully imported " 
					+ entity.getName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public List<Venue> findAll() {
		return venueRepository.findAll();
	}

	@Override
	public Venue findOneById(Long id) {
		return venueRepository.findOne(id);
	}

	@Override
	public Long count() {
		return venueRepository.count();
	}

	@Override
	public Venue saveAndGet(Venue entity) {
		Venue toReturn = null;
		try {
			toReturn = venueRepository.save(entity);
		} catch (Exception e) {
		}
		return toReturn;
	}

	@Override
	public void createFromVenueXmlDto(List<VenueXmlDto> entities) {
		List<Venue> venues = Mapper.mapToList(entities, Venue.class);
		for (Venue venue : venues) {
			this.save(venue);
		}
		
	}


}
