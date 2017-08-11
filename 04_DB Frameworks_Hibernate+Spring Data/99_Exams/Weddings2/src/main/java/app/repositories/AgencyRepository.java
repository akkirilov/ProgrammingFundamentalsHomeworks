package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.dtos.agencies.AgencyExportJsonDto;
import app.domain.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long>{

	Agency findFirstByName(String name);

	List<Agency> findAllByOrderByEmployeesCountDescNameAsc();

	@Query("SELECT a FROM Agency AS a WHERE LENGTH(a.name) > 5 AND a.weddings.size > 1 ORDER BY a.town")
	List<Agency> findAllByTownAndWeddingsCount();
	
}
