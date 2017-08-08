package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long>{

}
