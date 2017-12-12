package p01_Logger.models.appenders;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Layout;

public class ConsoleAppender implements Appender {
	
	private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;
	
	private Layout layout;
	private ReportLevel reportLevel;
	
	public ConsoleAppender(Layout layout) {
		this.layout = layout;
		this.reportLevel = DEFAULT_REPORT_LEVEL;
	}

	@Override
	public Layout getLayout() {
		return this.layout;
	}

	@Override
	public void append(String time, ReportLevel reportLevel, String message) {
		if (this.reportLevel.ordinal() > reportLevel.ordinal()) {
			return;
		}
		System.out.println(String.format(this.layout.getFormat(), time, reportLevel.name(), message));
	}

	@Override
	public void setReportLevel(ReportLevel reportLevel) {
		this.reportLevel = reportLevel;
	}

}
