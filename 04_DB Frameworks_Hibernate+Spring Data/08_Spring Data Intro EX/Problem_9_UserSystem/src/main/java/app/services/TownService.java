package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Town;
import app.repositories.TownRepository;

@Service
@Transactional
public class TownService {
	
	@Autowired
	private TownRepository townRepository;

	public void saveAndFlush(Town user) {
		townRepository.saveAndFlush(user);
	}
	
	public void save(Town user) {
		townRepository.save(user);
	}
	
	public void save(List<Town> users) {
		townRepository.saveAll(users);
	}
	
	public Town findById(Long id) {
		return townRepository.getOne(id);
	}
	
	public Town findByName(String name) {
		return townRepository.findByName(name);
	}
	
	public List<Town> findAll() {
		return townRepository.findAll();
	}
	
	public boolean isExist(Town user) {
		return townRepository.existsById(user.getId());
	}
	
}
