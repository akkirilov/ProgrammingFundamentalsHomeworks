package mankind;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] studentInfo = scanner.nextLine().split("\\s+");
		String[] workerInfo = scanner.nextLine().split("\\s+");
		scanner.close();
		
		Student student;
		if (checkStudent(studentInfo)) {
			student = new Student(
					studentInfo[0], 
					studentInfo[1], 
					studentInfo[2]);
		} else {
			return;
		}
		
		Worker worker;
		if (checkWorker(workerInfo)) {
			worker = new Worker(
					workerInfo[0], 
					workerInfo[1], 
					Double.parseDouble(workerInfo[2]), 
					Double.parseDouble(workerInfo[3]));
		} else {
			return;
		}
		
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		System.out.println(student.getfacultyNumber());
		System.out.println();
		System.out.println(worker.getFirstName());
		System.out.println(worker.getLastName());
		System.out.println(String.format("Week Salary: %.2f", worker.getWeekSalary()));
		System.out.println(String.format("Hours per day: %.2f", worker.getWorkHoursPerDay()));
		System.out.println(String.format("Salary per hour: %.2f", worker.getSalaryPerHour()));
		
	}

	private static boolean checkStudent(String[] info) {
		if (!Character.isUpperCase(info[0].charAt(0))) {
			System.out.println("Expected upper case letter!Argument: firstName");
			return false;
		} else if (info[0].length() < 4) {
			System.out.println("Expected length at least 4 symbols!Argument: firstName");
			return false;
		} else if (!Character.isUpperCase(info[1].charAt(0))) {
			System.out.println("Expected upper case letter!Argument: lastName");
			return false;
		} else if (info[1].length() < 3) {
			System.out.println("Expected length at least 3 symbols!Argument: lastName");
			return false;
		} else if (info[2].length() < 5 || info[2].length() > 10) {
			System.out.println("Invalid faculty number!");
			return false;
		} else {
			return true;
		}
		
	}
	
	private static boolean checkWorker(String[] info) {
		if (!Character.isUpperCase(info[0].charAt(0))) {
			System.out.println("Expected upper case letter!Argument: firstName");
			return false;
		} else if (info[0].length() < 4) {
			System.out.println("Expected length at least 4 symbols!Argument: firstName");
			return false;
		} else if (!Character.isUpperCase(info[1].charAt(0))) {
			System.out.println("Expected upper case letter!Argument: lastName");
			return false;
		} else if (info[1].length() < 4) {
			System.out.println("Expected length more than 3 symbols!Argument: lastName");
			return false;
		} else if (Double.parseDouble(info[2]) < 10.00) {
			System.out.println("Expected value mismatch!Argument: weekSalary");
			return false;
		} else if (Integer.parseInt(info[3]) < 1 || Integer.parseInt(info[3]) > 12) {
			System.out.println("Expected value mismatch!Argument: workHoursPerDay");
			return false;
		} else {
			return true;
		}		
		
	}
	
}
