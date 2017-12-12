package p01_Logger.models.appenders;

import java.io.File;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.CustomFile;
import p01_Logger.interfaces.Layout;
import p01_Logger.io.Writer;

public class FileAppender implements Appender {
	
	private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;
	
	private Layout layout;
	private ReportLevel reportLevel;
	private CustomFile file;
	
	public FileAppender(Layout layout) {
		this.layout = layout;
		this.reportLevel = DEFAULT_REPORT_LEVEL;
	}

	@Override
	public Layout getLayout() {
		return this.layout;
	}
	
	public void setFile(CustomFile file) {
		this.file = file;
	}

	@Override
	public void append(String time, ReportLevel reportLevel, String message) {
		if (this.reportLevel.ordinal() > reportLevel.ordinal()) {
			return;
		}
		file.writeLine(String.format(this.layout.getFormat(), time, reportLevel.name(), message));
	}

	@Override
	public void setReportLevel(ReportLevel reportLevel) {
		this.reportLevel = reportLevel;
	}

}
