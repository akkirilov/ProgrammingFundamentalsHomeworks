package service;

import javax.persistence.Query;

import model.BasicIngredient;

public class BasicIngredientDao<E, K> extends DaoImpl<E, K>{

	public BasicIngredientDao() {
		super();
	}
	
	public BasicIngredient getBasicIngredientByName(String name) {
		
		Query query = em.createQuery("SELECT b FROM BasicIngredient AS b WHERE b.name = '" + name + "'");
		BasicIngredient basicIngredient = (BasicIngredient) query.getSingleResult();
		return basicIngredient;
		
	}

}
