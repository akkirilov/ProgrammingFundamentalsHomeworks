package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Workshop;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long>{

}
