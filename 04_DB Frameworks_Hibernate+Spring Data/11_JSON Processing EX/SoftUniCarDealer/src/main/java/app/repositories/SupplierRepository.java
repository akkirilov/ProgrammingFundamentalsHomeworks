package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
	List<Supplier> findAllByIsImporterFalse();

}
