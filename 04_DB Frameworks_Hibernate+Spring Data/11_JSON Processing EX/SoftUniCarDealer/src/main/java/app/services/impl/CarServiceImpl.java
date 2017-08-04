package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Car;
import app.repositories.CarRepository;
import app.services.api.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	private CarRepository repository;
	
	@Autowired
	public CarServiceImpl(CarRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public void save(Car entity) {
		repository.save(entity);
	}

	@Override
	public void save(List<Car> entities) {
		repository.save(entities);
	}

	@Override
	public List<Car> findAll() {
		return repository.findAll();
	}

	@Override
	public Car findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Car> findAllToyota() {
		return repository.findAllToyota();
	}

}
