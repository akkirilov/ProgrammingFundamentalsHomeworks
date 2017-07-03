package numberInReversedOrder;

public class DecimalNumber {
	private double decimalNumber;

	public DecimalNumber(String num) {
		this.decimalNumber = Double.parseDouble(num);
	}
	
	public String reverseOrder() {
		StringBuffer sb = new StringBuffer(Double.valueOf(this.decimalNumber).toString());
		if (this.decimalNumber == Math.floor(this.decimalNumber)) {
			return sb.reverse().substring(2).toString();
		}
		
		return sb.reverse().toString();
	}
}
