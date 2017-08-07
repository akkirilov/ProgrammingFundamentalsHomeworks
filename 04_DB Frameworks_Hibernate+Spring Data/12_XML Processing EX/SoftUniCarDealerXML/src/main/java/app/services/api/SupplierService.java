package app.services.api;

import java.util.List;

import app.entities.Supplier;

public interface SupplierService {
	
	void save(Supplier entity);
	
	void save(List<Supplier> entities);
	
	List<Supplier> findAll();
	
	Supplier findById(Long id);

	List<Supplier> findAllLocalSuppliers();
	
}
