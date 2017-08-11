package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Present;

@Repository
public interface PresentRepository extends JpaRepository<Present, Long>{
	
}
