package service;

import java.sql.Date;

import javax.persistence.Query;

import model.ProductionBatch;

public class ProductionBatchDao<E, K> extends DaoImpl<E, K>{

	public ProductionBatchDao() {
		super();
	}

	public ProductionBatch getLabelBySubTitle(Date date) {
		
		Query query = em.createQuery("SELECT p FROM ProductionBatch AS p WHERE p.date = '" + date + "'");
		ProductionBatch classicLabel = (ProductionBatch) query.getSingleResult();
		return classicLabel;
		
	}
	
}
