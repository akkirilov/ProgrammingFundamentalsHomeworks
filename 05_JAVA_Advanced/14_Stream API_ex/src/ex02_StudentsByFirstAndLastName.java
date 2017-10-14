import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex02_StudentsByFirstAndLastName {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		Aaron Gibson
//		Antonio Gonzalez
//		Cheryl Gray
//		Craig King
//		Craig Ellis
//		Andrea Harper
//		Margaret Peterson
//		Edward Rose
//		Kelly Vasquez
//		Lois Patterson
//		Daniel Ferguson
//		Jane Lopez
//		Billy Romero
//		Craig Flores
//		Justin Watkins
//		Alice Baker
//		Lawrence Welch
//		Helen Hernandez
//		Heather Knight
//		Bonnie Shaw
//		Anne Freeman
//		Nancy Patterson
//		Ashley Lee
//		Marie Simpson
//		Melissa Robinson
//		Rebecca Torres
//		Marilyn Price
//		Gloria Harvey
//		Jacqueline Stewart
//		Gerald Watson
//		Gloria Schmidt
//		Kelly Woods
//		Fred Simmons
//		Joan Lee
//		Carolyn Grant
//		Albert Cruz
//		Kathryn Lee
//		Frances Peters
//		Eugene Lawson
//		Emily Howard
//		Nicholas Reyes
//		Beverly Clark
//		Amanda Hernandez
//		Catherine Porter
//		Billy Bowman
//		David Johnston
//		Arthur James
//		Julie Riley
//		Helen Williamson
//		Anne Powell
//		Elizabeth James
//		Cynthia Olson
//		Raymond Stewart
//		Catherine Diaz
//		Antonio Rodriguez
//		Maria Price
//		Diana Flores
//		James Nelson
//		Justin Reyes
//		Edward Nelson
//		Andrea Kelly
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();

		students.stream()
			.filter(Student.isFirstNameBeforeLastName)
			.forEach(x -> System.out.println(x.getFullName()));

	}

}
