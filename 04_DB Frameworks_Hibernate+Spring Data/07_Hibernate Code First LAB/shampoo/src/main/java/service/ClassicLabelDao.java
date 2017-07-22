package service;

import javax.persistence.Query;

import model.ClassicLabel;

public class ClassicLabelDao<E, K> extends DaoImpl<E, K>{

	public ClassicLabelDao() {
		super();
	}

	public ClassicLabel getLabelByTitle(String title) {
		
		Query query = em.createQuery("SELECT c FROM ClassicLabel AS c WHERE c.title = '" + title + "'");
		ClassicLabel classicLabel = (ClassicLabel) query.getSingleResult();
		return classicLabel;
		
	}
	
	public ClassicLabel getLabelBySubTitle(String subTitle) {
		
		Query query = em.createQuery("SELECT c FROM ClassicLabel AS c WHERE c.subTitle = '" + subTitle + "'");
		ClassicLabel classicLabel = (ClassicLabel) query.getSingleResult();
		return classicLabel;
		
	}
	
}
