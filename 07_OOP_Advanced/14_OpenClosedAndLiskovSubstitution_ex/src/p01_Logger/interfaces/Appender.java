package p01_Logger.interfaces;

import p01_Logger.enums.ReportLevel;

public interface Appender {

	Layout getLayout();
	
	void append(String time, ReportLevel reportLevel, String message);
	
	void setReportLevel(ReportLevel reportLevel);

	ReportLevel getReportLevel();
	
}
