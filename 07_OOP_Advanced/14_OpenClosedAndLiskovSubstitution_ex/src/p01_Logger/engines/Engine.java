package p01_Logger.engines;

import java.util.Arrays;

import p01_Logger.controllers.LoggerController;
import p01_Logger.enums.ReportLevel;
import p01_Logger.factories.AppenderFactory;
import p01_Logger.factories.LayoutFactory;
import p01_Logger.factories.LoggerFactory;
import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Layout;
import p01_Logger.interfaces.Logger;
import p01_Logger.io.Reader;

public class Engine {
	
	private Logger logger;
	private Reader reader;
	private LoggerController loggerController;
	
	public Engine(Reader reader, LoggerController loggerController) {
		super();
		this.reader = reader;
		this.loggerController = loggerController;
	}

	public void run() {
		
		int n = Integer.parseInt(reader.readLine());
		Appender[] appenders = new Appender[n];
		for (int i = 0; i < n; i++) {
			String[] commands = reader.readLine().split(" ");
			Layout layout = LayoutFactory.create(commands[1]);
			
			Appender appender = AppenderFactory.create(commands[0], layout);
			if (layout == null || appender == null) {
				continue;
			}
			if (commands.length == 3) {
				ReportLevel reportLevel = ReportLevel.valueOf(commands[2].toUpperCase());
				appender.setReportLevel(reportLevel);
			}
			appenders[i] = appender;
		}
		
		Logger logger = LoggerFactory.create(appenders);
		loggerController.setLogger(logger);
		
		while (true) {
			String[] commands = reader.readCommands();
			if (commands[0].equalsIgnoreCase("END")) {
				System.out.println(logger.getLoggerDetails());
				break;
			}
			
			loggerController.log(commands);
		}
		
	}
	
}
