package app.service.api;

import java.util.Date;
import java.util.List;

import app.model.ProductionBatch;

public interface ProductionBatchService<ProductionBatch, Long> extends ServiceInterface<ProductionBatch, Long> {
    List<ProductionBatch> findBatchByName(String name);

    List<ProductionBatch> findByDateAfter(Date date);
    
	List<ProductionBatch> findByDate(Date date);

	List<ProductionBatch> findByShampoosIsNull();
}
