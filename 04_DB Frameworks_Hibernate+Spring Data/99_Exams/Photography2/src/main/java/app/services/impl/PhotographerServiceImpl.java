package app.services.impl;

import static org.mockito.Matchers.endsWith;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.cameras.CameraJsonDto;
import app.domain.dtos.photographers.LensXmlDto;
import app.domain.dtos.photographers.PhotographerJsonDto;
import app.domain.dtos.photographers.PhotographerLandscapeJsonDto;
import app.domain.dtos.photographers.PhotographerOrderedJsonDto;
import app.domain.dtos.photographers.PhotographerWithSameCamera;
import app.domain.entities.Camera;
import app.domain.entities.DSLRCamera;
import app.domain.entities.Lens;
import app.domain.entities.MirrorlessCamera;
import app.domain.entities.Photographer;
import app.repositories.PhotographerRepository;
import app.services.api.CameraService;
import app.services.api.LensService;
import app.services.api.PhotographerService;
import app.utils.*;

@Service
public class PhotographerServiceImpl implements PhotographerService {
	
	private static final Random random = new Random();
	
	private PhotographerRepository photographerRepository;
	
	private LensService lensService;
	private CameraService cameraService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public PhotographerServiceImpl(PhotographerRepository photographerRepository, 
							LensService lensService,
							CameraService cameraService,
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.photographerRepository = photographerRepository;
		this.lensService = lensService;
		this.cameraService = cameraService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Photographer entity) {
		try {
			photographerRepository.save(entity);
			System.out.println("Successfully imported "
					+ entity.getFirstName() + " "
					+ entity.getLastName() + " | Lenses: "
					+ entity.getLenses().size());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}

	@Override
	public List<Photographer> findAll() {
		return photographerRepository.findAll();
	}

	@Override
	public Photographer findOneById(Long id) {
		return photographerRepository.findOne(id);
	}

	@Override
	public Long count() {
		return photographerRepository.count();
	}

	@Override
	public void save(List<PhotographerJsonDto> entities) {
		List<Camera> cameras = cameraService.findAll();
		Integer maxIndex = cameras.size();
		for (PhotographerJsonDto dto : entities) {
			
			Photographer temp = mapper.mapOne(dto, Photographer.class);
			temp.setPrimaryCamera(cameras.get(random.nextInt(maxIndex)));	
			temp.setSecondaryCamera(cameras.get(random.nextInt(maxIndex)));
			
			Set<Lens> lensesToSet = lensService.findAllByIdInList(dto.getLenses());
			temp.setLenses(lensesToSet);
			
			this.save(temp);
		}
	}

	@Override
	public Photographer findByFullName(String fullName) {
		return photographerRepository.findByFullName(fullName);
	}

	@Override
	public List<Photographer> findAllOrdered() {
		return photographerRepository.findAllByOrderByFirstNameAscLastNameDesc();
	}

	@Override
	public List<PhotographerOrderedJsonDto> getPhotographerOrderedJsonDto() {
		return mapper.mapToList(this.findAllOrdered(), 
				PhotographerOrderedJsonDto.class);
	}

	@Override
	public List<PhotographerLandscapeJsonDto> getLandscapePhotographersJsonDto() {
		List<PhotographerLandscapeJsonDto> dtos = new ArrayList<>();
		List<Photographer> photographers = photographerRepository.findAllByOrderByFirstNameAsc();
		for (Photographer p : photographers) {
			if (p.getPrimaryCamera().getClass().getAnnotation(DiscriminatorValue.class).value().equals("Mirrorless")
					|| p.getLenses() == null
					|| p.getLenses().size() < 1) {
				continue;
			}
			
			PhotographerLandscapeJsonDto temp = mapper.mapOne(p, PhotographerLandscapeJsonDto.class);
			Boolean haveMoreTham30mm = false;
			for (Lens l : p.getLenses()) {
				if (l.getFocalLength() != null && l.getFocalLength() > 30) {
					haveMoreTham30mm = true;
				}
			}
			temp.setCount(p.getLenses().size());
			
			dtos.add(temp);
		}
		return dtos;
	}

	@Override
	public List<PhotographerWithSameCamera> getSameCamerasPhotographersJsonDto() {
		List<Photographer> photographers = this.photographerRepository.findAllWithSameCameras();
		List<PhotographerWithSameCamera> dtos = mapper.mapToList(photographers, PhotographerWithSameCamera.class);
		return dtos;
	}

}
