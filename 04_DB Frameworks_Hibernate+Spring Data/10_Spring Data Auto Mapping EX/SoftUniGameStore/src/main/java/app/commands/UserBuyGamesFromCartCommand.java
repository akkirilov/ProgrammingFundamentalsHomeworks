package app.commands;

import app.entities.Game;
import app.entities.User;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;

public class UserBuyGamesFromCartCommand extends Command {

	public UserBuyGamesFromCartCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		if (CurrentSession.getLoggedUser() == null) {
			return "You must be logged in to buy new games!";
		}
		
		User user = super.getUserService().findById(CurrentSession.getLoggedUser().getId());
		if (user.getShoppingCart() == null || user.getShoppingCart().size() < 1) {
			return "Your shopping cart is empty!";
		}
		
		for (Game g : user.getShoppingCart()) {
			user.addGame(g);
		}
		
		user.setShoppingCart(null);
		super.getUserService().save(user);
		return "Successfully buy new games!";
	}

}
