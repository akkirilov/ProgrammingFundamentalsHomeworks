package app.loggers;

import app.interfaces.Handler;

public class CombatLogger extends LoggerAbstract implements Handler {

	@Override
	public void handle(LogType logType, String message) {
		if (logType == LogType.ATTACK || logType == LogType.MAGIC) {
			System.out.println(logType + ": " + message);
		} else {
			super.passToSuccessor(logType, message);
		}
	}

}
