package p01_Logger;

import p01_Logger.interfaces.*;

import java.io.File;

import p01_Logger.enums.*;
import p01_Logger.models.appenders.*;
import p01_Logger.models.files.*;
import p01_Logger.models.layouts.*;
import p01_Logger.models.loggers.*;

public class Main {
	
	public static void main(String[] args) {
		
		Layout simpleLayout = new SimpleLayout();
		Appender consoleAppender = new ConsoleAppender(simpleLayout);

		CustomFile file = new LogFile();
		Appender fileAppender = new FileAppender(simpleLayout);
		((FileAppender) fileAppender).setFile(file);

		Logger logger = new MessageLogger(consoleAppender, fileAppender);

		logger.logError("33/31/2015 5:33:07 PM", "Error parsing request");

		System.out.println(((LogFile)file).getSize());
		
	}

}
