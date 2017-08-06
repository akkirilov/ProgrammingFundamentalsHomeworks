package app.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Product;
import app.repositories.ProductRepository;
import app.services.api.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Product entity) {
		repository.saveAndFlush(entity);

	}

	@Override
	public void save(List<Product> entities) {
		repository.save(entities);
	}

	@Override
	public Product findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Product> findProductsByPriceInGivenRange(BigDecimal min, BigDecimal max) {
		return repository.findByPriceBetween(min, max);
	}

}
