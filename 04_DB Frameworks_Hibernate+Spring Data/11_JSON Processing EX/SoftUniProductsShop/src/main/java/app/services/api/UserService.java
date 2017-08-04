package app.services.api;

import java.util.List;

import app.entities.User;

public interface UserService {
	
	void save(User user);
	
	void save(List<User> users);
	
	User findById(Long id);
	
	List<User> findAll();
	
	Long count();
	
	List<User> findAllSuccessfullUser();
	
}
