package app.commands;

import app.entities.Game;
import app.entities.User;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;

public class UserRemoveGameCommand extends Command {

	public UserRemoveGameCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null) {
			return "You must be logged in to remove games!";
		}
		
		User user = super.getUserService().findById(CurrentSession.getLoggedUser().getId());
		
		Game game = super.getGameService().findByTitle(params[0]);
		if (game == null) {
			return "There are no such game in the database!";
		}
		
		for (Game g : user.getShoppingCart()) {
			if (g.getId() == game.getId()) {
				
				user.removeGameFromShoppingCart(g);
				super.getUserService().save(user);
				return String.format("Successfully remove %s from your shopping cart!", game.getTitle());
			}
		}
		return "This game is not in your shoping cart!";

	}

}
