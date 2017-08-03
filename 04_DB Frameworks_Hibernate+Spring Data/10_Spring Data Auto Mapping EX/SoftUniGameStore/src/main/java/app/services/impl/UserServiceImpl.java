package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Game;
import app.entities.User;
import app.repositories.UserRepository;
import app.services.api.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	public void saveAll(List<User> entities){
		repository.save(entities);
	}

	@Override
	public void save(User entity) {
		repository.save(entity);
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return repository.findOneByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public User findOneByEmailAndPassword(String email, String password) {
		return repository.findOneByEmailAndPassword(email, password);
	}

	@Override
	public Boolean isUserHaveGame(Long userId, Long gameId) {
		if (repository.findGameInUserGamesByGameId(userId, gameId) == null) {
			return false;
		}
		return true;
	}
}
