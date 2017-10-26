import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static Person person = new Person();

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String msg;
		int id;
		int years;
		double interest;
		String action;

		String[] tokens = bfr.readLine().split("\\s+");
		while (!tokens[0].equals("End")) {

			action = tokens[0];

			switch (action) {
			case "Create":
				msg = createAccount();
				printMessage(msg);
				break;
			case "Deposit":
				id = Integer.parseInt(tokens[1]);
				msg = depositAmount(id, tokens[2]);
				printMessage(msg);
				break;
			case "SetInterest":
				interest = Double.parseDouble(tokens[1]);
				setInterest(interest);
				break;
			case "GetInterest":
				id = Integer.parseInt(tokens[1]);
				years = Integer.parseInt(tokens[2]);
				msg = getInterest(id, years);
				printMessage(msg);
				break;
			default:
				printMessage("Invalid command!");
				break;
			}

			tokens = bfr.readLine().split("\\s+");

		}

		bfr.close();

	}

	private static void printMessage(String msg) {
		System.out.println(msg);
	}

	private static String getInterest(int id, int years) {
		BankAccount acc = person.getBankAccount(id);
		if (acc == null) {
			return "Account does not exist";
		}
		return String.format("%.2f", acc.getBalance() * years * acc.getInterestRate());
	}

	private static void setInterest(double interest) {
		BankAccount.setInterestRate(interest);
	}

	private static String depositAmount(int id, String ammountStr) {
		BankAccount acc = person.getBankAccount(id);
		if (acc == null) {
			return "Account does not exist";
		}
		acc.deposit(Double.parseDouble(ammountStr));
		return String.format("Deposited %s to ID%d", ammountStr, id);
	}

	private static String createAccount() {
		BankAccount acc = new BankAccount();
		person.addBankAccount(acc);
		return String.format("Account ID%d created", acc.getId());
	}

}
