import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e04_RoyalAccounting {

	public static void main(String[] args) throws IOException {

		List<Team> teams = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Boolean existTeam = false;
		Boolean existEmployee = false;
		String name;
		Integer workHoursHerDay;
		Double dailyPayment;
		// String team;
		Pattern pattern = Pattern.compile(
				"\\A(?<name>[a-zA-Z]+);(?<workPerDay>[\\d|\\-\\d]+);(?<dailyPayment>[\\-\\d|\\-\\d\\.\\d|\\d|\\d\\.\\d]+);(?<team>[a-zA-Z]+)\\Z");
		Matcher matcher;
		Team tempTeam = null;
		Employee tempEmployee;
		String input = reader.readLine();
		while (!input.equals("Pishi kuf i da si hodim")) {

			existTeam = false;
			existEmployee = false;
			
			matcher = pattern.matcher(input);
			if (!matcher.find()) {
				input = reader.readLine();
				continue;
			}

			name = matcher.group("name");
			workHoursHerDay = Integer.parseInt(matcher.group("workPerDay"));
			dailyPayment = Double.parseDouble(matcher.group("dailyPayment"));
			String team = matcher.group("team");

			for (Team t : teams) {
				if (team.equals(t.name)) {
					tempTeam = t;
					existTeam = true;
				}
				for (Employee e : t.employees) {
					if (e.name.equals(name)) {
						existEmployee = true;
						break;
					}
				}
				if (existEmployee) {
					break;
				}
			}
			
			if (existEmployee) {
				input = reader.readLine();
				continue;
			}

			tempEmployee = new Employee(name, workHoursHerDay, dailyPayment);
			if (!existTeam) {
				tempTeam = new Team(team);
				tempTeam.addEmployee(tempEmployee);
				teams.add(tempTeam);
			} else {
				for (Team t : teams) {
					if (team.equals(t.name)) {
						t.employees.add(tempEmployee);
						break;
					}
				}
			}
			
			input = reader.readLine();
			
		}

		reader.close();

		teams.stream().sorted((a, b) -> b.getMountPaymentForTeam().compareTo(a.getMountPaymentForTeam())).forEach(t -> {
			System.out.println("Team - " + t.name);
			t.employees.stream().sorted((a, b) -> {
				int res = b.workHoursHerDay.compareTo(a.workHoursHerDay);
				if (res == 0) {
					res = b.getDailyIncome().compareTo(a.getDailyIncome());
				}
				if (res == 0) {
					res = a.name.compareTo(b.name);
				}
				return res;
			}).forEach(e -> {
				System.out.printf("$$$%s - %d - %.6f%n", e.name, e.workHoursHerDay, e.getDailyIncome());
			});
		});

	}

}

class Employee {

	public final static Double hoursPerDay = 24.00;
	public final static Double daysPerMonth = 30.00;
	
	public String name;
	public Integer workHoursHerDay;
	public Double dailyPayment;

	public Employee(String name, Integer workHoursHerDay, Double dailyPayment) {
		super();
		this.name = name;
		this.workHoursHerDay = workHoursHerDay;
		this.dailyPayment = dailyPayment;
	}

	public Double getDailyIncome() {
		return ((dailyPayment * workHoursHerDay) / hoursPerDay);
	}

}

class Team {

	public String name;
	public List<Employee> employees;

	public Team(String name) {
		super();
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public Double getMountPaymentForTeam() {
		Double sum = 0.0;
		for (Employee e : employees) {
			sum += (e.getDailyIncome() * 30);
		}
		return sum;
	}

}
