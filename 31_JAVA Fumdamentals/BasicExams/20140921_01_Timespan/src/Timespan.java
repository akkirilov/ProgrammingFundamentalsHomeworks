import java.util.Scanner;

public class Timespan {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int startHours;
		int startMinutes;
		int startSeconds;
		
		int endHours;
		int endMinutes;
		int endSeconds;
		
		int resHours;
		int resMinutes;
		int resSeconds;
		
		String[] tokens = scanner.nextLine().split(":");
		startHours = Integer.parseInt(tokens[0]);
		startMinutes = Integer.parseInt(tokens[1]);
		startSeconds = Integer.parseInt(tokens[2]);
		
		tokens = scanner.nextLine().split(":");
		endHours = Integer.parseInt(tokens[0]);
		endMinutes = Integer.parseInt(tokens[1]);
		endSeconds = Integer.parseInt(tokens[2]);
		
		resSeconds = Math.abs(startSeconds - endSeconds);
		if (startSeconds < endSeconds) {
			resSeconds = 60 - resSeconds;
			startMinutes--;
			
			if (startMinutes < 0) {
				startHours--;
			}
		}
		
		resMinutes = Math.abs(startMinutes - endMinutes);
		if (startMinutes < endMinutes) {
			resMinutes = 60 - resMinutes;
			startHours--;
		}
		
		resHours = Math.abs(startHours - endHours);
		
		System.out.printf("%d:%02d:%02d", resHours, resMinutes, resSeconds);		
	}
}