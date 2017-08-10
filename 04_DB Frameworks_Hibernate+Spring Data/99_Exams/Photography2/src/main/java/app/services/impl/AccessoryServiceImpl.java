package app.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.accessories.AccessoryWrapperXmlDto;
import app.domain.dtos.accessories.AccessoryXmlDto;
import app.domain.entities.Accessory;
import app.domain.entities.Photographer;
import app.repositories.AccessoryRepository;
import app.services.api.AccessoryService;
import app.services.api.PhotographerService;
import app.utils.*;

@Service
public class AccessoryServiceImpl implements AccessoryService {
    
	private static final Random random = new Random();
	
	private AccessoryRepository accesoryRepository;
	private PhotographerService photographerService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public AccessoryServiceImpl(AccessoryRepository accesoryRepository,
							PhotographerService photographerService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.accesoryRepository = accesoryRepository;
		this.photographerService = photographerService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Accessory entity) {
		try {
			accesoryRepository.save(entity);
			System.out.println("Successfully imported "
					+ entity.getName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}

	@Override
	public List<Accessory> findAll() {
		return accesoryRepository.findAll();
	}

	@Override
	public Accessory findOneById(Long id) {
		return accesoryRepository.findOne(id);
	}

	@Override
	public Long count() {
		return accesoryRepository.count();
	}

	@Override
	public void save(AccessoryWrapperXmlDto accessoryWrapperXmlDto) {
		List<Photographer> photographers = photographerService.findAll();
		Integer maxIndex = photographers.size();
		for (AccessoryXmlDto a : accessoryWrapperXmlDto.getAccessoryXmlDtos()) {
			Accessory temp = mapper.mapOne(a, Accessory.class);
			temp.setOwner(photographers.get(random.nextInt(maxIndex)));
			this.save(temp);
		}
	}

}
