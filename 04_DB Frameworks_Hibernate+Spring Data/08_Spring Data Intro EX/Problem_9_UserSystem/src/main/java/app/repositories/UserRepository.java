package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	User findByUsername(String username);
	
	@Modifying
	@Query("UPDATE User SET lastName = :lastName WHERE id = :id")
	void setLastName(@Param("lastName") String lastName, @Param("id") Long id);

}
