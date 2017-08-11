package app.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.venues.VenueXmlDto;
import app.domain.dtos.venues.VenueinSofiaXmlDto;
import app.domain.entities.Venue;
import app.domain.entities.Wedding;
import app.repositories.VenueRepository;
import app.services.api.VenueService;
import app.services.api.WeddingService;
import app.utils.*; 

@Service
public class VenueServiceImpl implements VenueService {
	
	private static final Random random = new Random();
	
	private VenueRepository repository;
	private WeddingService weddingService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public VenueServiceImpl(VenueRepository repository, 
							WeddingService weddingService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.weddingService = weddingService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Venue entity) {
		try {
			repository.save(entity);
			System.out.println("Successfully imported "
						+ entity.getName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void save(List<Venue> entities) {
		for (Venue e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Venue> findAll() {
		return repository.findAll();
	}

	@Override
	public Venue findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromVenueXmlDtos(List<VenueXmlDto> venueXmlDtos) {
		for (VenueXmlDto venueXmlDto : venueXmlDtos) {
			this.save(mapper.mapOne(venueXmlDto, Venue.class));
		}
		List<Venue> venues = this.findAll();
		List<Wedding> weddings = weddingService.findAll();
		for (Wedding w : weddings) {
			Set<Venue> venueToSet = new HashSet<>();
			while (venueToSet.size() < 2) {
				venueToSet.add(venues.get(random.nextInt(venues.size())));
			}
			w.setVenues(venueToSet);
			weddingService.checkedSave(w);
		}
		
	}

	@Override
	public List<VenueinSofiaXmlDto> findAllVenuesInSofia() {
		List<VenueinSofiaXmlDto> dtos = mapper.mapToList(repository.findAllInSofia(), VenueinSofiaXmlDto.class);
		for (VenueinSofiaXmlDto v : dtos) {
			v.setWeddingCount(v.getWeddings().size());
		}
		return dtos;
	}

}
