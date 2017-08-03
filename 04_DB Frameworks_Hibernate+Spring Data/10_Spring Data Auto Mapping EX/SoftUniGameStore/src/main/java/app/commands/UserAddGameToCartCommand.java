package app.commands;

import app.entities.Game;
import app.entities.User;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;

public class UserAddGameToCartCommand extends Command {

	public UserAddGameToCartCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null) {
			return "You must be logged in to buy new games!";
		}
		
		User user = super.getUserService().findById(CurrentSession.getLoggedUser().getId());
		
		Game game = super.getGameService().findByTitle(params[0]);
		if (game == null) {
			return "There are no such game in the database!";
		}

		for (Game g : user.getShoppingCart()) {
			if (g.getId() == game.getId()) {
				return "You already add this game in your shopping cart!";
			}
		}
		for (Game g : user.getGames()) {
			if (g.getId() == game.getId()) {
				return "You already have this game! Leave some copies for other people!";
			}
		}
		
		user.addGameInShoppingCart(game);
		
		super.getUserService().save(user);
		
		return String.format("Successfully add %s to your shopping cart!", game.getTitle());
	}

}
