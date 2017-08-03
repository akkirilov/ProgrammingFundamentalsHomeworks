package app.services.api;

import java.util.List;

import app.entities.User;

public interface UserService {
	
	void saveAll(List<User> entities);
	
	void save(User entity);
	
	User findById(Long id);
	
	User findByEmail(String email);
	
	List<User> findAll();	
	
	User findOneByEmailAndPassword(String email, String password);
	
	Boolean isUserHaveGame(Long userId, Long gameId);

}
