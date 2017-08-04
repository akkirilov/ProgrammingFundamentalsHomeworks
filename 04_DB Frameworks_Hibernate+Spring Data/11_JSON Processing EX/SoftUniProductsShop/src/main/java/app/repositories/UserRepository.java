package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User AS u WHERE u.soldProducts.size > 0 ORDER BY u.lastName ASC, u.firstName ASC")
	List<User> findAllSuccessfullUser();
	
}
