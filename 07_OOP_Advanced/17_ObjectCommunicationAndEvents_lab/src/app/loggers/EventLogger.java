package app.loggers;

import app.interfaces.Handler;

public class EventLogger extends LoggerAbstract implements Handler {

	@Override
	public void handle(LogType logType, String message) {
		if (logType == LogType.TARGET || logType == LogType.EVENT) {
			System.out.println(logType + ": " + message);
		} else {
			super.passToSuccessor(logType, message);
		}
	}

}
