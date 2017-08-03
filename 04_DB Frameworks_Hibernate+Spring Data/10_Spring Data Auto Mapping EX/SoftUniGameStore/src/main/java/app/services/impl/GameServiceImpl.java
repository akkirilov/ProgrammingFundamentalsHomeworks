package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Game;
import app.entities.User;
import app.repositories.GameRepository;
import app.services.api.GameService;

@Service
@Transactional
public class GameServiceImpl implements GameService {
	
	private GameRepository repository;
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository){
		this.repository = gameRepository;
	}
	
	@Override
	public void saveAll(List<Game> entities){
		repository.save(entities);
	}

	@Override
	public void save(Game entity) {
		repository.save(entity);
	}

	@Override
	public Game findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Game findByTitle(String title) {
		return repository.findOneByTitle(title);
	}

	@Override
	public List<Game> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Game game) {
		repository.delete(game);
	}

	@Override
	public List<Game> findAllByUserId(Long id) {
		return repository.findAllByUserId(id);
	}

}
