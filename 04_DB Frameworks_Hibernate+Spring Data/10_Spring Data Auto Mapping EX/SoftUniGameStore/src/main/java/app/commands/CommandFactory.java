package app.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.services.api.GameService;
import app.services.api.UserService;

@Component
public class CommandFactory {
	
	private static UserService userService;
	private static GameService gameService;
	
	@Autowired
	public CommandFactory(UserService userServiceIn, GameService gameServiceIn){
		userService = userServiceIn;
		gameService = gameServiceIn;
	}
	
	public static Command getCommand(String command) {

		switch (command) {
		case "Register":
			return new UserRegisterCommand(userService, gameService);
		case "Login":
			return new UserLoginCommand(userService, gameService);
		case "Logout":
			return new UserLogoutCommand(userService, gameService);
		case "AddGame":
			return new GameAddCommand(userService, gameService);
		case "DeleteGame":
			return new GameDeleteCommand(userService, gameService);
		case "EditGame":
			return new GameEditCommand(userService, gameService);
		case "AllGames":
			return new GamesViewAllCommand(userService, gameService);
		case "GameDetails":
			return new GameDetailsCommand(userService, gameService);
		case "OwnedGames":
			return new GameOwnedCommand(userService, gameService);
		case "AddToShoppingCart":
			return new UserAddGameToCartCommand(userService, gameService);
		case "RemoveFromShoppingCart":
			return new UserRemoveGameCommand(userService, gameService);
		case "BuyGames":
			return new UserBuyGamesFromCartCommand(userService, gameService);
		default:
			break;
		}
		
		return null;
		
	}
	
}
