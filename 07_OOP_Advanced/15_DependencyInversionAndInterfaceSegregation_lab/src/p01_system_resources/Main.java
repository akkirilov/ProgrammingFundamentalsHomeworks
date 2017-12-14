package p01_system_resources;

import p01_system_resources.interfaces.TimeInterface;
import p01_system_resources.interfaces.WriterInterface;
import p01_system_resources.models.ConsoleWriter;
import p01_system_resources.models.CustomTime;
import p01_system_resources.models.GreetingClock;

public class Main {
	
	public static void main(String[] args) {
		
		WriterInterface writer = new ConsoleWriter();
		TimeInterface time = new CustomTime();

		GreetingClock greetingClock = new GreetingClock(writer, time);
		greetingClock.greeting();
		
	}
	
}
