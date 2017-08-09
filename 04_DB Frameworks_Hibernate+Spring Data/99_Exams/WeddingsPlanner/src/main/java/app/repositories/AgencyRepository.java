package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long>{
	
	Agency findFirstByName(String name);
	
	List<Agency> findAllByOrderByEmployeesCountDescNameAsc();
	
}
