package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Lens;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long>{

}
