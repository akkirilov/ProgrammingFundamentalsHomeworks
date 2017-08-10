package app.services.impl;

import java.util.List;

import javax.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.cameras.CameraJsonDto;
import app.domain.entities.Camera;
import app.domain.entities.DSLRCamera;
import app.domain.entities.Lens;
import app.domain.entities.MirrorlessCamera;
import app.repositories.CameraRepository;
import app.services.api.CameraService;
import app.utils.*;

@Service
public class CameraServiceImpl implements CameraService {
	
	private CameraRepository cameraRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public CameraServiceImpl(CameraRepository cameraRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser,
							Mapper mapper) {
		super();
		this.cameraRepository = cameraRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Camera entity) {
		try {
			cameraRepository.save(entity);
			System.out.println("Successfully imported "
					+ entity.getClass().getAnnotation(DiscriminatorValue.class).value()
					+ " " + entity.getMake() + " "
					+ entity.getModel());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}

	@Override
	public List<Camera> findAll() {
		return cameraRepository.findAll();
	}

	@Override
	public Camera findOneById(Long id) {
		return cameraRepository.findOne(id);
	}

	@Override
	public Long count() {
		return cameraRepository.count();
	}

	@Override
	public void save(List<CameraJsonDto> entities) {
		for (CameraJsonDto e : entities) {
			
			if (e.getType() == null) {
				continue;
			}
			if (e.getType().equals("DSLR")) {
				this.save(mapper.mapOne(e, DSLRCamera.class));
			} else if (e.getType().equals("Mirrorless")) {
				this.save(mapper.mapOne(e, MirrorlessCamera.class));
			}
						
		}
	}

}
