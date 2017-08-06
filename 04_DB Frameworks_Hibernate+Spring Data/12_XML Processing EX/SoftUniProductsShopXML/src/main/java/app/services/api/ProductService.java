package app.services.api;

import java.math.BigDecimal;
import java.util.List;

import app.entities.Product;

public interface ProductService {
	
	void save(Product product);
	
	void save(List<Product> products);
	
	Product findById(Long id);
	
	List<Product> findAll();

	List<Product> findProductsByPriceInGivenRange(BigDecimal min, BigDecimal max);
	
}
