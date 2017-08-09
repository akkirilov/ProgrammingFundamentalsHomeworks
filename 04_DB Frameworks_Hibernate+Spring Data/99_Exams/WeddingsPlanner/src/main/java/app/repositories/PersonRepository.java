package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.domain.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query("SELECT p FROM Person AS p WHERE CONCAT(p.firstName, ' ', p.middleName, ' ', p.lastName) = :fullName")
	Person findByFullName(@Param("fullName") String fullName);
	
}
