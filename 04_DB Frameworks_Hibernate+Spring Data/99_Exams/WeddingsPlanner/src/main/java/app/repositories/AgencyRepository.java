package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long>{
	
	Agency findOneByName(String name);
	
}
