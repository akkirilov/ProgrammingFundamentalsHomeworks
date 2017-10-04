import java.util.Scanner;

public class lab01_StudentsResults {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s-\\s|,\\s+");
	
		scanner.close();

		String sName = "Name";
		String sJAdv = "JAdv";
		String sJavaOOP = "JavaOOP";
		String sAdvOOP = "AdvOOP";
		String sAverage = "Average";

		Double sJAdvRes = Double.parseDouble(input[1]);
		Double sJavaOOPRes = Double.parseDouble(input[2]);
		Double sAdvOOPRes = Double.parseDouble(input[3]);
		
		Double sAverageRes = getAvarage(sJAdvRes, sJavaOOPRes, sAdvOOPRes);
		
		System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", sName, sJAdv, sJavaOOP, sAdvOOP, sAverage);
		System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n", input[0], sJAdvRes, sJavaOOPRes, sAdvOOPRes, sAverageRes);
		
	}

	private static Double getAvarage(Double jAdvRes, Double javaOOPRes, Double advOOPRes) {
		
		return ((jAdvRes + javaOOPRes + advOOPRes) / 3);
		
	}

}
