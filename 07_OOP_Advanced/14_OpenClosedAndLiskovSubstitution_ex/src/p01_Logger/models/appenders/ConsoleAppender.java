package p01_Logger.models.appenders;

import p01_Logger.enums.ReportLevel;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Layout;

public class ConsoleAppender extends AppenderBase {
	
	private int messageCount;
	
	public ConsoleAppender(Layout layout) {
		super(layout);
		this.messageCount = 0;
	}

	@Override
	public void append(String time, ReportLevel reportLevel, String message) {
		if (super.getReportLevel().ordinal() > reportLevel.ordinal()) {
			return;
		}
		String line = String.format(super.getLayout().getFormat(), time, reportLevel.name(), message);
		System.out.println(line);
		super.incrementMessageCount();
	}

}
