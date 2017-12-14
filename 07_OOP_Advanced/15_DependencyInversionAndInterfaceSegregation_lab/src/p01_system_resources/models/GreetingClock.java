package p01_system_resources.models;

import p01_system_resources.interfaces.TimeInterface;
import p01_system_resources.interfaces.WriterInterface;

public class GreetingClock {

    private TimeInterface time;
    private WriterInterface writer;

    public GreetingClock(WriterInterface writer, TimeInterface time) {
        this.time = time;this.writer = writer;
    }

    public void greeting() {
        if (time.getHour() < 12) {
        	this.writer.printLine("Good morning...");
        } else if (time.getHour() < 18) {
        	this.writer.printLine("Good afternoon...");
        } else {
        	this.writer.printLine("Good evening...");
        }
    }
    
}
