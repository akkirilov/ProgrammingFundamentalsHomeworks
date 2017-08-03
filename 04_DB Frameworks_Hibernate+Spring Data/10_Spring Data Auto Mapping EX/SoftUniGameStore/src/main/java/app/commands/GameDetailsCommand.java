package app.commands;

import app.entities.Game;
import app.models.viewModels.GameDetailsView;
import app.services.api.GameService;
import app.services.api.UserService;
import app.utils.EntityMapper;

public class GameDetailsCommand extends Command {

	public GameDetailsCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		if (params.length < 1) {
			return "Incorect params count!";
		}
		
		Game game = super.getGameService().findByTitle(params[0]);
		
		if (game == null) {
			return "There are no games in the database!";
		}
		
		GameDetailsView gamesToView = EntityMapper.map(game, GameDetailsView.class);
		
		return gamesToView.toString();
	}

}
