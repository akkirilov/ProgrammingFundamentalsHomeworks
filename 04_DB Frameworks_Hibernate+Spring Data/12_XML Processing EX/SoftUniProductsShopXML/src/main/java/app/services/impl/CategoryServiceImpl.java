package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Category;
import app.repositories.CategoryRepository;
import app.services.api.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository repository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Category entity) {
		repository.save(entity);

	}

	@Override
	public void save(List<Category> entities) {
		repository.save(entities);
	}

	@Override
	public Category findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Category> findAllByProductsCount() {
		return repository.findAllByProductsCount();
	}

}
