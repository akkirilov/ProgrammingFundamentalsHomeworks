package app.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.venues.VenueNameCapacityXmlDto;
import app.domain.dtos.venues.VenueXmlDto;
import app.domain.entities.Venue;
import app.domain.entities.Wedding;
import app.repositories.VenueRepository;
import app.services.api.VenueService;
import app.services.api.WeddingService;
import app.utils.*;

@Service
public class VenueServiceImpl implements VenueService {
	
	private VenueRepository venueRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private WeddingService weddingService;
	
	@Autowired
	public VenueServiceImpl(VenueRepository venueRepository, 
							WeddingService weddingService,
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.venueRepository = venueRepository;
		this.weddingService = weddingService;
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
		venues = this.findAll();
		List<Wedding> weddings = weddingService.findAll();
		Random random = new Random();
		Integer maxIndex = venues.size();
		for (Wedding wedding : weddings) {
			Set<Venue> venuesToSet = new HashSet<>();
			while (venuesToSet.size() < 3) {
				venuesToSet.add(venues.get(random.nextInt(maxIndex)));
			}
			wedding.setVenues(venuesToSet);
			weddingService.save(wedding);
		}
				
	}

	@Override
	public List<Venue> findAllWithMoreThanThreeWeddings() {
		return venueRepository.findAllWithMoreThanThreeWeddings();
	}

	@Override
	public List<VenueNameCapacityXmlDto> getVenueNameCapacityXmlDtos() {
		List<Venue> venues = this.findAllWithMoreThanThreeWeddings();
		List<VenueNameCapacityXmlDto> venueNameCapacityXmlDtos = Mapper.mapToList(venues, VenueNameCapacityXmlDto.class);
		for (VenueNameCapacityXmlDto v : venueNameCapacityXmlDtos) {
			v.setWeddingsCount(v.getWeddings().size());
		}
		return venueNameCapacityXmlDtos;
	}


}
