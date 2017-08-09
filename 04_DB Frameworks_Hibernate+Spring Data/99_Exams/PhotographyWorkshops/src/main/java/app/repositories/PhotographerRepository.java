package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.domain.entities.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long>{

	@Query("SELECT p FROM Photographer AS p WHERE CONCAT(p.firstName, ' ', p.lastName) = :trainerName")
	Photographer findFirstByFullName(@Param("trainerName") String trainerName);

	Photographer findByFirstNameAndLastName(String firstName, String lastName);

	List<Photographer> findAllByOrderByFirstNameAscLastNameDesc();
	
	List<Photographer> findAllByOrderByFirstNameAsc();

}
