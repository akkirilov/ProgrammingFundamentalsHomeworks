package app.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	List<Sale> findAllByDiscountGreaterThan(BigDecimal bigDecimal);

}
