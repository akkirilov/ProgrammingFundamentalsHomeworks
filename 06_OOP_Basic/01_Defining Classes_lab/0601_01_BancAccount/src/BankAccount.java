public class BankAccount {

	public int id;
	public double balance;
	
	public double getBalance() {
		return balance;
	}
	public void setId(int id) {
		this.id = id;
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
