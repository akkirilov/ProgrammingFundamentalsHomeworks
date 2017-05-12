import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExamScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		line = scanner.nextLine();
		line = scanner.nextLine();
		
		Map<Integer, HashMap<String, Double>> studentScores = new TreeMap<>();
		int score;
		double grade;
		String name;
	
		String[] tokens = scanner.nextLine().split("\\s*\\|\\s*");
		while (!tokens[0].contains(line)) {
			name = tokens[1];
			score = Integer.parseInt(tokens[2]);
			grade = Double.parseDouble(tokens[3]);
			
			if (!studentScores.containsKey(score)) {
				studentScores.put(score, new HashMap<String, Double>());
			}
			studentScores.get(score).put(name, grade);
			
			tokens = scanner.nextLine().split("\\s*\\|\\s*");
		}
		
		for (Map.Entry<Integer, HashMap<String, Double>> scores : studentScores.entrySet()) {
			System.out.printf("%d -> ", scores.getKey());
			
			int i = 0;
			double avarage = 0;
			Set<String> names = new TreeSet<>();
			
			for (Map.Entry<String, Double> students : scores.getValue().entrySet()) {
				i++;
				avarage += students.getValue();
				names.add(students.getKey());
			}			
			
			System.out.print(names);
			System.out.printf("; avg=%.2f%n", avarage /= i);
		}	
	}
}