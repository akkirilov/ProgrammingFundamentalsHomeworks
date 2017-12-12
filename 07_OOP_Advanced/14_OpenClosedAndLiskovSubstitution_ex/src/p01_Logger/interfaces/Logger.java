package p01_Logger.interfaces;

import p01_Logger.enums.ReportLevel;

public interface Logger {
	
	Appender[] getAppenders();
	
	void log(String time, ReportLevel reportLevel, String message);
	
	void logInfo(String time, String message);
	
	void logWarning(String time, String message);
	
	void logError(String time, String message);
	
	void logCritical(String time, String message);
	
	void logFatal(String time, String message);
	
}
