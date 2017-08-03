package app.commands;

import java.util.List;

import app.entities.Game;
import app.models.viewModels.OwnGamesView;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;
import app.utils.EntityMapper;

public class GameOwnedCommand extends Command {

	public GameOwnedCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		if (CurrentSession.getLoggedUser() == null) {
			return "You must be logged in to view your games!";
		}
		 
		List<Game> games = super.getGameService().findAllByUserId(CurrentSession.getLoggedUser().getId());
		if (games == null) {
			return "You don't have games!";
		}
		
		List<OwnGamesView> gamesToView = EntityMapper.map(games, OwnGamesView.class);
		
		StringBuffer returnString = new StringBuffer();
		for (OwnGamesView game : gamesToView) {
			returnString.append(game.toString() + "\n");
		}
		
		return returnString.toString();

	}

}
