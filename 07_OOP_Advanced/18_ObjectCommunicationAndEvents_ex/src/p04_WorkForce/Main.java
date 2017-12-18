package p04_WorkForce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import p04_WorkForce.contracts.Employee;
import p04_WorkForce.contracts.Handler;
import p04_WorkForce.events.EventHandler;
import p04_WorkForce.models.JobImpl;
import p04_WorkForce.models.JobList;
import p04_WorkForce.models.PartTimeEmployee;
import p04_WorkForce.models.StandartEmployee;

public class Main {

	public static void main(String[] args) {
		
		Map<String, Employee> employees = new HashMap<>();
		
		Handler handler = new EventHandler();
		JobList list = new JobList(handler);

		Scanner reader = new Scanner(System.in);

		while (true) {

			String[] tokens = reader.nextLine().split("\\s+");
			if (tokens[0].equalsIgnoreCase("end")) {
				break;
			}

			switch (tokens[0]) {
			case "PartTimeEmployee":
				employees.put(tokens[1], new PartTimeEmployee(tokens[1]));
				break;
			case "StandartEmployee":
				employees.put(tokens[1], new StandartEmployee(tokens[1]));
				break;
			case "Job":
				list.addJob(new JobImpl(tokens[1], Integer.parseInt(tokens[2]), employees.remove(tokens[3])));
				break;
			case "Pass":
				list.passWeek();
				break;
			case "Status":
				list.getJobStatus(); 
				break;
			default:
				break;
			}

		}

		reader.close();

	}

}
