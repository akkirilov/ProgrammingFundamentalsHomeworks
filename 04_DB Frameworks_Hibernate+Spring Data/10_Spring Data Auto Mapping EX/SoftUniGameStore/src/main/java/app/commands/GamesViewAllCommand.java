package app.commands;

import java.util.List;

import app.entities.Game;
import app.models.viewModels.AllGamesView;
import app.services.api.GameService;
import app.services.api.UserService;
import app.utils.EntityMapper;

public class GamesViewAllCommand extends Command {

	public GamesViewAllCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		List<Game> games = super.getGameService().findAll();
		
		if (games == null) {
			return "There are no games in the database!";
		}
		
		List<AllGamesView> gamesToView = EntityMapper.map(games, AllGamesView.class);
		
		StringBuffer returnString = new StringBuffer();
		for (AllGamesView game : gamesToView) {
			returnString.append(game.toString() + "\n");
		}
		
		return returnString.toString();

	}

}
