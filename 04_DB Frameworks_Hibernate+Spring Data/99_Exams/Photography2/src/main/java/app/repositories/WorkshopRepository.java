package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Workshop;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long>{

	List<Workshop> findAllByOrderByLocationAsc();
	
}
