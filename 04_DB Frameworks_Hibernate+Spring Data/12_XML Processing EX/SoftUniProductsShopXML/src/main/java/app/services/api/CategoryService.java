package app.services.api;

import java.util.List;

import app.entities.Category;

public interface CategoryService {
	
	void save(Category category);
	
	void save(List<Category> categories);
	
	Category findById(Long id);
	
	List<Category> findAll();
	
	List<Category> findAllByProductsCount();
	
}
