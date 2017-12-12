package p01_Logger.models.appenders;

import java.io.File;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.CustomFile;
import p01_Logger.interfaces.Layout;
import p01_Logger.io.Writer;

public abstract class AppenderBase implements Appender {
	
	private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;
	
	private Layout layout;
	private ReportLevel reportLevel;
	private int messageCount;
	
	protected AppenderBase(Layout layout) {
		this.layout = layout;
		this.reportLevel = DEFAULT_REPORT_LEVEL;
		this.messageCount = 0;
	}
	
	protected void incrementMessageCount () {
		this.messageCount++;
	}

	@Override
	public Layout getLayout() {
		return this.layout;
	}

	@Override
	public void setReportLevel(ReportLevel reportLevel) {
		this.reportLevel = reportLevel;
	}

	@Override
	public ReportLevel getReportLevel() {
		return this.reportLevel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Appender type: ").append(this.getClass().getSimpleName()).append(", ")
		.append("Layout type: ").append(this.layout.getClass().getSimpleName()).append(", ")
		.append("Report level: ").append(this.reportLevel).append(", ")
		.append("Messages appended: ").append(this.messageCount);
		return sb.toString();
	}
}
