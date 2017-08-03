package app.services.api;

import java.util.List;

import app.entities.Game;

public interface GameService {
	
	void saveAll(List<Game> entities);
	
	void save(Game entity);
	
	Game findById(Long id);
	
	Game findByTitle(String title);
	
	List<Game> findAll();

	void delete(Game game);

	List<Game> findAllByUserId(Long id);
	
}
