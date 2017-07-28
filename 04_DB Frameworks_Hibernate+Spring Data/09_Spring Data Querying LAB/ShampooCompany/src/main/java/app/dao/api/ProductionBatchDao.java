package app.dao.api;

import app.model.BasicShampoo;
import app.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductionBatchDao  extends JpaRepository<ProductionBatch, Long> {
    
	List<ProductionBatch> findByName (String name);

    List<ProductionBatch> findByDateAfter (Date date);

    List<ProductionBatch> findByShampoosIsNull();

	List<ProductionBatch> findByDate(Date date);
	
}
