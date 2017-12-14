package p01_system_resources.models;

import java.time.LocalTime;

import p01_system_resources.interfaces.TimeInterface;

public class CustomTime implements TimeInterface {

	@Override
	public int getHour() {
		return LocalTime.now().getHour();
	}

}
