package app.services.api;

import java.util.List;

import app.entities.Sale;

public interface SaleService {
	
	void save(Sale entity);
	
	void save(List<Sale> entities);
	
	List<Sale> findAll();
	
	Sale findById(Long id);

	List<Sale> findAllWithAppliedDiscount();
	
}
