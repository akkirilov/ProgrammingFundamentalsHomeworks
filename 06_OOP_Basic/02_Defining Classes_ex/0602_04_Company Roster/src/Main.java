import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Map<String, List<Employee>> employees = new HashMap<>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(isr);

	    int n = Integer.parseInt(reader.readLine());
	    for (int i = 0; i < n; i++) {
			
	    	String[] tokens = reader.readLine().split("\\s+");
			Employee temp = getEmployee(tokens);
			
			List<Employee> tempEmployees = new ArrayList<>();
			if (employees.containsKey(tokens[3])) {
				tempEmployees = employees.get(tokens[3]);
			}
			
			tempEmployees.add(temp);
			employees.put(tokens[3],tempEmployees);
			
		}
	    
	    reader.close();
	    
	    employees.entrySet().stream()
	    		.sorted((a, b) -> {
	    			Double bavg = b.getValue().stream().mapToDouble(x -> Double.valueOf(x.getSalary())).average().getAsDouble();
	    			Double aavg = a.getValue().stream().mapToDouble(x -> Double.valueOf(x.getSalary())).average().getAsDouble();
	    			return bavg.compareTo(aavg);
	    		})
	    		.limit(1)
	    		.forEach(x -> {
	    			System.out.printf("Highest Average Salary: %s%n", x.getKey());
	    			x.getValue().stream().sorted((a, b) -> {
	    				return Double.compare(b.getSalary(), a.getSalary());
	    			}).forEach(e -> {
	    				System.out.printf("%s %.2f %s %s%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge());
	    			});
	    		});

	}

	private static Employee getEmployee(String[] tokens) {
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		String position = tokens[2];
		Employee temp;
		if (tokens.length == 6) {
			String email = tokens[4];
			int age = Integer.parseInt(tokens[5]);
			temp = new Employee(name, age, salary, position, email);
		} else if (tokens.length == 4) {
			temp = new Employee(name, salary, position);
		} else if (Character.isDigit(tokens[4].charAt(tokens[4].length() - 1))) {
			int age = Integer.parseInt(tokens[4]);
			temp = new Employee(name, age, salary, position);
		} else {
			String email = tokens[4];
			temp = new Employee(name, salary, position, email);
		}
		return temp;
	}

}
