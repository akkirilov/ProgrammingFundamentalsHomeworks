package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.User;
import app.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void saveAndFlush(User user) {
		userRepository.saveAndFlush(user);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void save(List<User> users) {
		userRepository.saveAll(users);
	}
	
	public User findById(Long id) {
		return userRepository.getOne(id);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public boolean isExist(User user) {
		return userRepository.existsById(user.getId());
	}
	
	public void setLastNameManual(User user, String lastName) {
		userRepository.setLastName(lastName, user.getId());
	}
	
}
