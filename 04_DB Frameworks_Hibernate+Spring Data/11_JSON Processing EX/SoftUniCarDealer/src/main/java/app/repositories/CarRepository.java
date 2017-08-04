package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
	@Query("SELECT c FROM Car AS c WHERE c.make = 'Toyota' ORDER BY c.model ASC, c.travelledDistance DESC")
	List<Car> findAllToyota();

}
