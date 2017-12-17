package app.interfaces;

import app.loggers.LogType;

public interface Handler {

	void handle(LogType logType, String message);
	
	void setSuccessor(Handler handler);
	
}
