package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	Game findOneByTitle(String title);
	
	@Query("SELECT g FROM Game AS g JOIN g.users AS u ON :id IN (u.id)")
	List<Game> findAllByUserId(@Param("id") Long id);

}
