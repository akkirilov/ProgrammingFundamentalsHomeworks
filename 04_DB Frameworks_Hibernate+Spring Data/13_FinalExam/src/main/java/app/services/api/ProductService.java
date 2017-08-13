package app.services.api;

import java.util.List;

import app.domain.dtos.products.ProductWrapperXmlDto;
import app.domain.entities.Product;

public interface ProductService {

	void save(Product product);
	
	void save(List<Product> products);
	
	List<Product> findAll();
	
	Product findOneById(Long id);
	
	Long count();

	void saveFromDto(ProductWrapperXmlDto wrapperXmlDto);
	
}
