public class BankAccount {

	private static double INTERESR_RATE = 0.02;
	private static int NEXT_ID = 1;
	
	private int id;
	private double balance;
	
	public BankAccount() {
		this.id = NEXT_ID;
		NEXT_ID++;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public double getInterestRate() {
		return INTERESR_RATE;
	}
	public static void setInterestRate(double interestRate) {
		INTERESR_RATE = interestRate;
	}
	public void deposit(double amount) {
		this.balance += amount;
	}
	public String withdraw(double amount) {
		String msg = "ok";
		if (this.balance - amount < 0) {
			msg = "Insufficient balance";
		} else {
			this.balance -= amount;
		}
		return msg;
	}
	@Override
	public String toString() {
		return String.format("%s", this.id);
	}
	
}
