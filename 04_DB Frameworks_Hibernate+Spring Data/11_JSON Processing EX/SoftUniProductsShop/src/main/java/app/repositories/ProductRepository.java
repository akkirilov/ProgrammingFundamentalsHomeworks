package app.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
	
}
