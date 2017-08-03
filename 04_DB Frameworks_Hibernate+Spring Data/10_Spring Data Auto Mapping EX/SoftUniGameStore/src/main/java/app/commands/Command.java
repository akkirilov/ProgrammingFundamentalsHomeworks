package app.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.services.api.GameService;
import app.services.api.UserService;

@Component
public abstract class Command implements Executable {
	
	private UserService userService;
	private GameService gameService;
	
	@Autowired
	public Command(UserService userServiceIn, GameService gameServiceIn){
		this.userService = userServiceIn;
		this.gameService = gameServiceIn;
	}

	protected UserService getUserService() {
		return userService;
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}

	protected GameService getGameService() {
		return gameService;
	}

	protected void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
}
