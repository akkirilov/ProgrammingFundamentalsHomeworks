package p01_Logger.models.layouts;

import p01_Logger.interfaces.Layout;

public class SimpleLayout implements Layout {
	
	private final String FORMAT = "%s - %s - %s";

	@Override
	public String getFormat() {
		return FORMAT;
	}

}
