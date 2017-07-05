package telephony;

public class SmartPhone implements Callable, Browsable{

	private String action;
	
	
	
	public SmartPhone(String action) {
		this.action = action;
	}

	@Override
	public String browsing() {
		return String.format("Browsing: %s!", this.action);
	}

	@Override
	public String calling() {
		return String.format("Calling... %s", this.action);
	}

}
