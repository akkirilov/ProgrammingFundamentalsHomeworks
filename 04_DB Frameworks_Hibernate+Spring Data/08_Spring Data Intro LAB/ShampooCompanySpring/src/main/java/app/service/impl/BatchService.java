package app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.BatchDao;
import app.model.ProductionBatch;

@Service
@Transactional
public class BatchService {

	@Autowired
	private BatchDao dao;
	
	public List<ProductionBatch> findAllProductionBatches() {
		return dao.findAll();
	}
	
	public ProductionBatch findProductionBatchById(Long id) {
		return dao.findOne(id);
	}
	
	public boolean isProductionBatchExist(ProductionBatch productionBatch) {
		return dao.exists(productionBatch.getId());
	}
	
	public void save (ProductionBatch productionBatch) {
		dao.saveAndFlush(productionBatch);
	}
	
}
