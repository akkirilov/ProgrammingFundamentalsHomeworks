package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Part;
import app.repositories.PartRepository;
import app.services.api.PartService;

@Service
@Transactional
public class PartServiceImpl implements PartService {

	private PartRepository repository;
	
	@Autowired
	public PartServiceImpl(PartRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public void save(Part entity) {
		repository.save(entity);
	}

	@Override
	public void save(List<Part> entities) {
		repository.save(entities);
	}

	@Override
	public List<Part> findAll() {
		return repository.findAll();
	}

	@Override
	public Part findById(Long id) {
		return repository.findOne(id);
	}

}
