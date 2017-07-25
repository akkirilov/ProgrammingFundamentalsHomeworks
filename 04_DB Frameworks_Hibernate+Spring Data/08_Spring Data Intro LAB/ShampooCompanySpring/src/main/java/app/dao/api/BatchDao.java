package app.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.ProductionBatch;

@Repository
public interface BatchDao extends JpaRepository<ProductionBatch, Long>{

}
