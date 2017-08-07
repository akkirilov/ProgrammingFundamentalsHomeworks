package app.services.api;

import java.util.List;

import app.entities.Car;

public interface CarService {
	
	void save(Car entity);
	
	void save(List<Car> entities);
	
	List<Car> findAll();
	
	Car findById(Long id);

	List<Car> findAllToyota();
	
}
