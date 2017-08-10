package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Ent;

@Repository
public interface EntRepository extends JpaRepository<Ent, Long>{
	
}
