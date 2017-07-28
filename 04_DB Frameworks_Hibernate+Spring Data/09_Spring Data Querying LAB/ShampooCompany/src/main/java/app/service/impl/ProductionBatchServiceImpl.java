package app.service.impl;

import app.dao.api.ProductionBatchDao;
import app.service.api.ProductionBatchService;
import app.model.ProductionBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductionBatchServiceImpl implements ProductionBatchService<ProductionBatch, Long> {

    @Autowired
    private ProductionBatchDao dao;
    
    @Override
    public List<ProductionBatch> findBatchByName(String name) {
        return ((ProductionBatchDao) dao).findByName(name);
    }
    
    @Override
    public ProductionBatch findById(Long id) {
        return dao.findOne(id);
    }
    
    @Override
    public void remove(ProductionBatch object) {
        dao.delete(object);
    }
    
    @Override
    public List<ProductionBatch> findAll(Class<ProductionBatch> serviceClass) {
        return dao.findAll();
    }
    
    @Override
    public void save(ProductionBatch object) {
        dao.save(object);
    }

	@Override
	public List<ProductionBatch> findByDate(Date date) {
		return dao.findByDate(date);
	}
	
	@Override
	public List<ProductionBatch> findByDateAfter(Date date) {
		return dao.findByDateAfter(date);
	}
	
	@Override
	public List<ProductionBatch> findByShampoosIsNull() {
		return dao.findByShampoosIsNull();
	}
	
}
