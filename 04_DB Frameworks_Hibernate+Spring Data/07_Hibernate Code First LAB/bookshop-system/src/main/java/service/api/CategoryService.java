package service.api;

import domain.Category;

public interface CategoryService<E, K> extends Service<E, K>{

	Category findCategoryByName(String name);
	
}
