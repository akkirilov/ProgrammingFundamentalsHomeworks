package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.domain.entities.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long>{
	
	@Query("SELECT p FROM Photographer AS p WHERE CONCAT(p.firstName, ' ', p.lastName) = :fullName")
	Photographer findByFullName(@Param("fullName") String fullName);
	
	List<Photographer> findAllByOrderByFirstNameAscLastNameDesc();

	List<Photographer> findAllByOrderByFirstNameAsc();

	@Query("SELECT p FROM Photographer AS p WHERE p.primaryCamera.make = p.secondaryCamera.make AND p.lenses.size > 0")
	List<Photographer> findAllWithSameCameras();
	
}
