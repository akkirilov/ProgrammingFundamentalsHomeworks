package app.commands;

import java.math.BigDecimal;
import java.util.Scanner;

import app.entities.Game;
import app.enums.Role;
import app.models.bindingModels.EditGame;
import app.services.api.GameService;
import app.services.api.UserService;
import app.sessions.CurrentSession;
import app.utils.EntityMapper;
import app.utils.FieldValidator;

public class GameEditCommand extends Command {

	public GameEditCommand(UserService userServiceIn, GameService gameServiceIn) {
		super(userServiceIn, gameServiceIn);
	}

	@Override
	public String execute(String... params) {
		
		if (CurrentSession.getLoggedUser() == null
				|| CurrentSession.getLoggedUser().getRole() != Role.ADMIN) {
			return "You must be logged in as Administrator to edit games!";
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
		
		EditGame gameToEdit = EntityMapper.map(game, EditGame.class);
		Scanner scanner = new Scanner(System.in);
		Boolean edited = false;
		
		System.out.println("Enter parameter name to edit it:");
		System.out.println("url/price/title/image/description");
		
		String subCommand = scanner.nextLine();
		switch (subCommand.toLowerCase()) {
		case "price":
			System.out.println("Enter new price: ");
			gameToEdit.setPrice(new BigDecimal(scanner.nextLine()));
			edited = true;
			break;
		case "title":
			System.out.println("Enter new title: ");
			gameToEdit.setTitle(scanner.nextLine());
			edited = true;
			break;
		case "url":
			System.out.println("Enter new trailer URL: ");
			gameToEdit.setTrailerURL(scanner.nextLine());
			edited = true;
			break;
		case "image":
			System.out.println("Enter new image thumbnail: ");
			gameToEdit.setImageThumbnail(scanner.nextLine());
			edited = true;
			break;
		case "description":
			System.out.println("Enter new description: ");
			gameToEdit.setDescription(scanner.nextLine());
			edited = true;
			break;
		default:
			break;
		}
		
		if (!edited) {
			return "Nothing was edited!";
		}
		
		if (FieldValidator.getInvalidMessage(gameToEdit) != null) {
			return FieldValidator.getInvalidMessage(gameToEdit);
		}
		
		try {
			game = EntityMapper.map(gameToEdit, Game.class);
			super.getGameService().save(game);
		} catch (Exception e) {
			return e.getMessage();
		}

		return String.format("Edited %s!", gameToEdit.getTitle());

	}

}
