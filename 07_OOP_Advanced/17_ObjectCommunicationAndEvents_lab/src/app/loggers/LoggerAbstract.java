package app.loggers;

import app.interfaces.Handler;

public abstract class LoggerAbstract implements Handler {

	private Handler handler;

	@Override
	public void setSuccessor(Handler handler) {
		this.handler = handler;
	}
	
	protected void passToSuccessor(LogType logType, String message) {
		if (this.handler != null) {
			this.handler.handle(logType, message);
		}
	}
	
}
