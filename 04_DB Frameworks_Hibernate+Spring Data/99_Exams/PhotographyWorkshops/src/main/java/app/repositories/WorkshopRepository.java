package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.entities.Workshop;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long>{

	@Query("SELECT w FROM Workshop AS w WHERE w.participants.size >= 5 ORDER BY w.location ASC")
	List<Workshop> findAllByOrderByLocation();
	
}
