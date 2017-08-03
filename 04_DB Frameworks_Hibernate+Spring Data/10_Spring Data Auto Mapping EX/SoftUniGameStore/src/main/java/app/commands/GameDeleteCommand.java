package app.commands;

import app.entities.Game;
import app.enums.Role;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;

public class GameDeleteCommand extends Command {

	public GameDeleteCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null
				|| CurrentSession.getLoggedUser().getRole() != Role.ADMIN) {
			return "You must be logged in as Administrator to delete games!";
		}
		
		if (params.length != 1) {
			return "Incorect input parameters count!";
		}
		
		Long id;
		try {
			id = Long.parseLong(params[0]);
		} catch (Exception e) {
			return "Incorect id format!";
		}
		
		Game game = super.getGameService().findById(id);
		if (game == null) {
			return String.format("There are no game with id %d in the database!", id);
		}
		
		try {
			super.getGameService().delete(game);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return String.format("Delete %s", game.getTitle());

	}

}
