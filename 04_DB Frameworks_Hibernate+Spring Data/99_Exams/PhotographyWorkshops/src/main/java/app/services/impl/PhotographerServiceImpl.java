package app.services.impl;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.photographers.PhotographerImportJsonDto;
import app.domain.entities.Camera;
import app.domain.entities.Lens;
import app.domain.entities.Photographer;
import app.repositories.CameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import app.services.api.PhotographerService;
import app.utils.Mapper;

@Service
public class PhotographerServiceImpl implements PhotographerService {

	private PhotographerRepository photographerRepository;
	private LensRepository lensRepository;
	private CameraRepository cameraRepository;

	@Autowired
	public PhotographerServiceImpl(PhotographerRepository photographerRepository, 
			LensRepository lensRepository, CameraRepository cameraRepository) {
		super();
		this.photographerRepository = photographerRepository;
		this.lensRepository = lensRepository;
		this.cameraRepository = cameraRepository;
	}

	@Override
	public void create(Photographer photographer) {
		try { 
			photographerRepository.save(photographer);
			System.out.println("Successfully imported " + 
					photographer.getFirstName() + " " +
					photographer.getLastName() + " | " +
					"Lenses: " + photographer.getLenses().size()
			);
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public void create(List<Photographer> photographers) {
		for (Photographer photographer : photographers) {
			this.create(photographer);
		}
	}

	@Override
	public void createFromJsonImport(List<PhotographerImportJsonDto> photographerImportJsonDtos) {
		photographerImportJsonDtos = Mapper.mapToList(photographerImportJsonDtos, PhotographerImportJsonDto.class);
		Random random = new Random();
		List<Camera> cameras = cameraRepository.findAll();
		List<Lens> lenses = lensRepository.findAll();
		for (PhotographerImportJsonDto photographerImportJsonDto : photographerImportJsonDtos) {
			Photographer photographer = Mapper.mapOne(photographerImportJsonDto, Photographer.class);
			photographer.setPrimaryCamera(cameras.get(random.nextInt(cameras.size())));
			photographer.setSecondaryCamera(cameras.get(random.nextInt(cameras.size())));
			Set<Lens> lensesToSet = lenses
					.stream()
					.filter(x -> photographerImportJsonDto.getLenses().contains(x.getId())
							&& (x.getCompatibleWith().equals(photographer.getPrimaryCamera().getMake())
									|| x.getCompatibleWith().equals(photographer.getSecondaryCamera().getMake())))
					.collect(Collectors.toSet());
			photographer.setLenses(lensesToSet);
			this.create(photographer);
		}
	}

	@Override
	public List<Photographer> findAll() {
		return photographerRepository.findAll();
	}

	@Override
	public List<Photographer> findAllOrderedByFirstAndLastNames() {
		return photographerRepository.findAllByOrderByFirstNameAscLastNameDesc();
	}

	@Override
	public List<Photographer> findAllByOrderByFirstNameAsc() {
		return photographerRepository.findAllByOrderByFirstNameAsc();
	}
}
