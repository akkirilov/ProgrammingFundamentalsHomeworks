package app.commands;

import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;

public class UserLogoutCommand extends Command {

	public UserLogoutCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null) {
			return "Cannot log out! No user was logged in!";
		} else {
			String name = CurrentSession.getLoggedUser().getFullName();
			CurrentSession.setLoggedUser(null);
			return String.format("User %s successfully logged out!", name);
		}
		
	}

}
