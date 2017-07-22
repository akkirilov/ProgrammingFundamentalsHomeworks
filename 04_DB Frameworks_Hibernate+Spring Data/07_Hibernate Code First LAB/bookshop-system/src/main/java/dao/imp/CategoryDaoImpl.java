package dao.imp;

import domain.Category;

public final class CategoryDaoImpl<E, K> extends AbstractJpaDao<E, K> {

	public Category getCategoryByName(String name) {
		Category category = (Category) em.createQuery("SELECT c From Category AS c WHERE c.name = '" + name + "'").getSingleResult();
		return category;
	}
	
}
