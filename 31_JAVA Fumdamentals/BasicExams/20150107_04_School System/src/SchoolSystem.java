import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SchoolSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		String name;
		String subject;
		
		String[] tokens = new String[4];
		List<Double> grades = new ArrayList<>();
		Map<String, TreeMap<String, List<Double>>> students = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			tokens = scanner.nextLine().split("\\s+");
			name = tokens[0] + " " + tokens[1];
			subject = tokens[2];
			grades.add(Double.parseDouble(tokens[3]));
			
			if (students.containsKey(name)) {
				if (students.get(name).containsKey(subject)) {
					grades.addAll(students.get(name).get(subject));
				}
			}
			else {
				students.put(name, new TreeMap<>());
			}
			
			students.get(name).put(subject, grades);
			grades = new ArrayList<>();
		}
		
		List<String> subjects = new ArrayList<>();
		for (Map.Entry<String, TreeMap<String, List<Double>>> studentsEntry : students.entrySet()) {
			System.out.printf("%s: [", studentsEntry.getKey());
			
			for (Map.Entry<String, List<Double>> subjectsEntry : studentsEntry.getValue().entrySet()) {
				subjects.add(String.format("%s - %.2f", subjectsEntry.getKey(), getAvarageGrade(subjectsEntry.getValue())));
			}
			System.out.printf("%s]%n", String.join(", ", subjects));
			subjects.clear();
		}
	}

	private static double getAvarageGrade(List<Double> grades) {
		double gradesSum = 0.0;
		for (int i = 0; i <grades.size(); i++) {
			gradesSum += grades.get(i);
		}
		
		return gradesSum / grades.size();
	}
}