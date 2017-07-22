package service.impl;

import java.util.List;

import domain.Category;
import service.api.CategoryService;
import transaction.Command;

public class CategoryServiceImpl extends AbstractService implements CategoryService{


	@Override
	public Category findCategoryByName(String name) {
		return (Category) runInTransaction(new Command<Category>() {
			public Category execute(){
				List<Category> categories = dao.findAll(Category.class);
				Category category = categories
						.stream()
						.filter(a -> a.getName().equals(name))
						.findFirst()
						.orElse(null);
				return category;
			}
		});
	}

}
