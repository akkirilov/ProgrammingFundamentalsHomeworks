package p01_Logger.models.layouts;

import p01_Logger.interfaces.Layout;

public class XmlLayout implements Layout {

	private final String TAB = "  ";
	private final String FORMAT = "<log>%n"
					+ TAB + "<date>%s</date>%n"
					+ TAB + "<level>%s</level>%n"
					+ TAB + "<message>%s</message>%n"
					+ "</log>";
	
	@Override
	public String getFormat() {
		return FORMAT;
	}

}
