import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<Integer, BankAccount> accounts = new HashMap<>();

	public static void main(String[] args) throws IOException {


		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String msg;
		int id;
		double amount;
		String action;
		
		String[] tokens = bfr.readLine().split("\\s+");
		while (!tokens[0].equals("End")) {
			
			action = tokens[0];
			id = Integer.parseInt(tokens[1]);
			
			switch (action) {
			case "Create":
				msg = createAccount(id);
				printIfError(msg);
				break;
			case "Deposit":
				amount = Double.parseDouble(tokens[2]);
				msg = depositAmount(id, amount);
				printIfError(msg);
				break;
			case "Withdraw":
				amount = Double.parseDouble(tokens[2]);
				msg = withdrawAmount(id, amount);
				printIfError(msg);
				break;
			case "Print":
				printAccount(id);
				break;
			default:
				printIfError("Invalid command!");
				break;
			}
			
			tokens = bfr.readLine().split("\\s+");
			
		}
		
		bfr.close();

	}

	private static void printAccount(int id) {
		String msg = "ok";
		if (!accounts.containsKey(id)) {
			msg = "Account does not exist";
		} else {
			BankAccount acc = accounts.get(id);
			msg = String.format("Account ID%d, balance %.2f", id, acc.getBalance());
		}
		System.out.println(msg); 
	}

	private static String withdrawAmount(int id, double amount) {
		String msg = "ok";
		if (!accounts.containsKey(id)) {
			msg = "Account does not exist";
		} else {
			BankAccount acc = accounts.get(id);
			msg = acc.withdraw(amount);
			accounts.put(id, acc);
		}
		return msg;
	}

	private static String depositAmount(int id, double amount) {
		String msg = "ok";
		if (!accounts.containsKey(id)) {
			msg = "Account does not exist";
		} else {
			BankAccount acc = accounts.get(id);
			acc.deposit(amount);
			accounts.put(id, acc);
		}
		return msg;
	}

	private static void printIfError(String msg) {
		if (!msg.equals("ok")) {
			System.out.println(msg);
		}
	}

	private static String createAccount(int id) {
		String msg = "ok";
		if (accounts.containsKey(id)) {
			msg = "Account already exists";
		} else {
			BankAccount acc = new BankAccount();
			acc.setId(id);
			accounts.put(id, acc);
		}
		return msg;
	}

}
