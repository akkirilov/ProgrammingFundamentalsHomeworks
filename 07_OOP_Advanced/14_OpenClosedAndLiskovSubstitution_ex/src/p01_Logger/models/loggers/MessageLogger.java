package p01_Logger.models.loggers;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Logger;

public class MessageLogger implements Logger {
	
	private Appender[] appenders;

	public MessageLogger(Appender... appenders) {
		this.appenders = appenders;
	}
	
	@Override
	public void logInfo(String time, String message) {
		ReportLevel level = ReportLevel.INFO;
		this.log(time, level, message);
	}

	@Override
	public void logWarning(String time, String message) {
		ReportLevel level = ReportLevel.WARNING;
		this.log(time, level, message);
	}

	@Override
	public void logError(String time, String message) {
		ReportLevel level = ReportLevel.ERROR;
		this.log(time, level, message);
	}

	@Override
	public void logCritical(String time, String message) {
		ReportLevel level = ReportLevel.CRITICAL;
		this.log(time, level, message);
	}

	@Override
	public void logFatal(String time, String message) {
		ReportLevel level = ReportLevel.FATAL;
		this.log(time, level, message);
	}

	@Override
	public void log(String time, ReportLevel reportLevel, String message) {
		for (Appender appender : appenders) {
			appender.append(time, reportLevel, message);
		}
	}

	@Override
	public Appender[] getAppenders() {
		return this.appenders;
	}

}
