package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long>{

	Town findFirstByName(String name);

	@Query("SELECT t FROM Town AS t "
			+ "LEFT OUTER JOIN t.branches AS b "
			+ "LEFT OUTER JOIN b.products AS p "
			+ "GROUP BY t.name "
			+ "ORDER BY SUM(p.clients) DESC")
	List<Town> findAllOrderedByTownClients();
	
}
