package app.commands;

import app.entities.User;
import app.enums.Role;
import app.models.bindingModels.RegisterUser;
import app.services.api.GameService;
import app.services.api.UserService;
import app.utils.CustomValidator;
import app.utils.FieldValidator;
import app.utils.EntityMapper;

public class UserRegisterCommand extends Command {
		
	public UserRegisterCommand(UserService userService, GameService gameService){
		super(userService, gameService);
	}
	
	@Override
	public String execute(String... params) {
		if (!params[1].equals(params[2])) {
			return "Password mismatch!";
		}
		
		if (!CustomValidator.vaidatePassword(params[1])) {
			return "Password must contains at least 1 lower letter, 1 upper letter and 1 digit!";
		}
		
		if (super.getUserService().findByEmail(params[0]) != null) {
			return String.format("Email %s is used by another user!", params[0]);
		}

		RegisterUser registerUser = new RegisterUser(params[3], params[0], params[1]);
		
		if (FieldValidator.getInvalidMessage(registerUser) != null) {
			return FieldValidator.getInvalidMessage(registerUser);
		}

		User user = EntityMapper.map(registerUser, User.class);
				
		if (super.getUserService().findAll().size() < 1) {
			user.setRole(Role.ADMIN);
		} else {
			user.setRole(Role.USER);
		}
		
		try {
			super.getUserService().save(user);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return String.format("%s was registered", params[3]);
	}

}
