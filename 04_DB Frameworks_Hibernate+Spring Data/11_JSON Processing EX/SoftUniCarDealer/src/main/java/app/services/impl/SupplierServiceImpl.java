package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Supplier;
import app.repositories.SupplierRepository;
import app.services.api.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository repository;
	
	@Autowired
	public SupplierServiceImpl(SupplierRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void save(Supplier entity) {
		repository.save(entity);
	}

	@Override
	public void save(List<Supplier> entities) {
		repository.save(entities);
	}

	@Override
	public List<Supplier> findAll() {
		return repository.findAll();
	}

	@Override
	public Supplier findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Supplier> findAllLocalSuppliers() {
		return repository.findAllByIsImporterFalse();
	}

}
