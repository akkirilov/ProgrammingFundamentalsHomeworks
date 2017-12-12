package p01_Logger.controllers;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Logger;

public class LoggerController {
	
	private Logger logger;
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void log(String[] commands) {
		logger.log(commands[1], ReportLevel.valueOf(commands[0]), commands[2]);
	}

}
