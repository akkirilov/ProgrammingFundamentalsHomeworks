import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CountWorkingDays {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Scanner scanner = new Scanner(System.in);
		LocalDate startDate = LocalDate.parse(scanner.nextLine(), dtf);
		LocalDate endDate = LocalDate.parse(scanner.nextLine(), dtf).plusDays(1);
		scanner.close();	
		
		int month;
		int day;
		String dayOfWeek;
		int counter = 0;
		for ( ; startDate.isBefore(endDate); startDate = startDate.plusDays(1)) {
			dayOfWeek = startDate.getDayOfWeek().toString().toUpperCase();
			month = startDate.getMonthValue();
			day = startDate.getDayOfMonth();
			
			if (dayOfWeek.equals("SATURDAY")) {
				continue;
			} else if (dayOfWeek.equals("SUNDAY")) {
				continue;
			} else if (month == 1) {
				if (day == 1) {
					continue;
				}
			} else if (month == 3) {
				if (day == 3) {
					continue;
				}
			} else if (month == 5) {
				if (day == 1) {
					continue;
				} else if (day == 6) {
					continue;
				} else if (day == 24) {
					continue;
				}
			} else if (month == 9) {
				if (day == 6) {
					continue;
				} else if (day == 22) {
					continue;
				}
			} else if (month == 11) {
				if (day == 1) {
					continue;
				}
			} else if (month == 12) {
				if (day == 24) {
					continue;
				} else if (day == 25) {
					continue;
				} else if (day == 26) {
					continue;
				}
			}
			
			counter++;
		}
		
		System.out.println(counter);
	}

}
