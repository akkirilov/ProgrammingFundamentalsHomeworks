import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private int age;
	private List<BankAccount> accounts;
	
	public Person() {
		this.accounts = new ArrayList<>();
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.accounts = new ArrayList<>();
	}
	
	public double getBalance() {
		return accounts.stream().mapToDouble(x -> Double.valueOf(x.getBalance())).sum();
	}
	
	public void addBankAccount (BankAccount acc) {
		this.accounts.add(acc);
	}
	
	public BankAccount getBankAccount (int accId) {
		if (accounts.size() < accId || accId < 1) {
			return null;
		}
		return this.accounts.get(accId - 1);
	}

}
