package app.commands;

import app.entities.User;
import app.models.bindingModels.LoggedUser;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;
import app.utils.EntityMapper;

public class UserLoginCommand extends Command {

	public UserLoginCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {

		User user = super.getUserService().findOneByEmailAndPassword(params[0], params[1]);
		
		if (user == null) {
			return "Incorect parameters!";
		}
		
		if (CurrentSession.getLoggedUser() != null) {
			return "There are logged in user!";
		}
		
		LoggedUser loggedUser = EntityMapper.map(user, LoggedUser.class);
		CurrentSession.setLoggedUser(loggedUser);
		
		return String.format("Successfully logged in %s!", user.getFullName());
	}

}
