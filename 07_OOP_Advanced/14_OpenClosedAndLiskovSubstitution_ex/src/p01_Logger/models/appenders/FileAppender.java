package p01_Logger.models.appenders;

import java.io.File;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.CustomFile;
import p01_Logger.interfaces.Layout;
import p01_Logger.io.Writer;

public class FileAppender extends AppenderBase {
	
	private CustomFile file;
	
	public FileAppender(Layout layout) {
		super(layout);
	}

	public void setFile(CustomFile file) {
		this.file = file;
	}

	@Override
	public void append(String time, ReportLevel reportLevel, String message) {
		if (super.getReportLevel().ordinal() > reportLevel.ordinal()) {
			return;
		}
		file.writeLine(String.format(super.getLayout().getFormat(), time, reportLevel.name(), message));
		super.incrementMessageCount();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(", File size: ").append(this.file.getSize());
		return sb.toString();
	}
}
