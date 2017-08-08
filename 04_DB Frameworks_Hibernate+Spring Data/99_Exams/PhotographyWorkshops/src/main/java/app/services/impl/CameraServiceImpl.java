package app.services.impl;

import javax.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Camera;
import app.repositories.CameraRepository;
import app.services.api.CameraService;

@Service
public class CameraServiceImpl implements CameraService {

	private CameraRepository cameraRepository;

	@Autowired
	public CameraServiceImpl(CameraRepository cameraRepository) {
		super();
		this.cameraRepository = cameraRepository;
	}

	@Override
	public void create(Camera camera) {
		try {
			cameraRepository.save(camera);
			System.out.println("Successfully imported " 
			+ camera.getClass().getAnnotation(DiscriminatorValue.class).value() 
			+ " " + camera.getMake() + " " + camera.getModel());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}
}
