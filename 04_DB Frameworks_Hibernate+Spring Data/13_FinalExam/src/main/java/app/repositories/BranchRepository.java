package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{

	Branch findFirstByName(String name);

	@Query("SELECT b FROM Branch AS b "
			+ "LEFT OUTER JOIN b.products AS p "
			+ "GROUP BY b.name "
			+ "ORDER BY SUM(p.clients) DESC")
	List<Branch> findAllOrderedByTotalClients();
	
}
