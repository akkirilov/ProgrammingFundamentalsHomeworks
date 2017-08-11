package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.entities.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long>{

	@Query("SELECT v FROM Venue AS v WHERE v.weddings.size > 2 AND v.town = 'Sofia'")
	List<Venue> findAllInSofia();
	
}
