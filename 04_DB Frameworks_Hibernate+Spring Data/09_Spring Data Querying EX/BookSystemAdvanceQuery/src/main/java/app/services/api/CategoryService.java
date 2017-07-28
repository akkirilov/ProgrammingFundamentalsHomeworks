package app.services.api;

import java.util.List;

import app.models.Category;

public interface CategoryService{
	
	void save(Category category);
	
	void save(List<Category> categories);
	
}
