package app.sessions;

import app.models.bindingModels.LoggedUser;

public class CurrentSession {

	private static LoggedUser loggedUser;

	public static LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(LoggedUser loggedUser) {
		CurrentSession.loggedUser = loggedUser;
	}
	
}
