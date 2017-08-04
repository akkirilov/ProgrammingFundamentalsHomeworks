package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.User;
import app.repositories.UserRepository;
import app.services.api.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(User entity) {
		repository.save(entity);

	}

	@Override
	public void save(List<User> entities) {
		repository.save(entities);
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public List<User> findAllSuccessfullUser() {
		return repository.findAllSuccessfullUser();
	}

}
