package app.commands;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import app.entities.Game;
import app.enums.Role;
import app.models.bindingModels.AddGame;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;
import app.utils.CustomValidator;
import app.utils.EntityMapper;
import app.utils.FieldValidator;

public class GameAddCommand extends Command {

	public GameAddCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null
				|| CurrentSession.getLoggedUser().getRole() != Role.ADMIN) {
			return "You must be logged in as Administrator to add new games!";
		}
		
		if (params.length < 7) {
			return "Incorect input parameters count!";
		}
		
		if (super.getGameService().findByTitle(params[0]) != null) {
			return String.format("%s already exist in the database!", params[0]);
		}
		
		if (CustomValidator.validateSize(params[2]) != null) {
			return CustomValidator.validateSize(params[2]);	
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		AddGame addGame;
		try {
			addGame = new AddGame(params[0], new BigDecimal(params[1]), 
					Double.parseDouble(params[2]), params[3], 
					params[4], params[5], sdf.parse(params[6]));
		} catch (NumberFormatException e) {
			return "Incorect number!";
		} catch (ParseException e) {
			return "Incorect date format!";
		}
		
		if (FieldValidator.getInvalidMessage(addGame) != null) {
			return FieldValidator.getInvalidMessage(addGame);
		}
		
		try {
			Game game = EntityMapper.map(addGame, Game.class);
			super.getGameService().save(game);
		} catch (Exception e) {
			return e.getMessage();
		}

		return String.format("Added %s!", params[0]);
	}

}
