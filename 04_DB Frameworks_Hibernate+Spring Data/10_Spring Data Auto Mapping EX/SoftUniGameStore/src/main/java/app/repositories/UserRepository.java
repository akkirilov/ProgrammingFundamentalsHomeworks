package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Game;
import app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneByEmail(String email);
	
	User findOneByEmailAndPassword(String email, String password);
	
	@Query("SELECT g FROM Game AS g JOIN g.users AS u ON :userId IN (u.id) WHERE g.id = :gameId")
	Game findGameInUserGamesByGameId(@Param("userId") Long userId, @Param("gameId") Long gameId);

}
