package p04_Telephony.smartphones;

public class SmartPhone implements Callable, Browsable{

	@Override
	public void browseSite(String site) {
		for (int i = 0; i < site.length(); i++) {
			if (Character.isDigit(site.charAt(i))) {
				throw new IllegalArgumentException("Invalid URL!");
			}
		}
		
		System.out.println("Browsing: " + site + "!");
		
	}

	@Override
	public void callNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i))) {
				throw new IllegalArgumentException("Invalid number!");
			}
		}
		
		System.out.println("Calling... " + number);
	}
	
}
