package app.services.api;

import java.util.List;

import app.domain.dtos.cameras.CameraJsonDto;
import app.domain.entities.Camera;
import app.domain.entities.Lens;

public interface CameraService {

	void save(Camera entity);
	
	List<Camera> findAll();
	
	Camera findOneById(Long id);
	
	Long count();
	
	void save(List<CameraJsonDto> entities);
	
}
