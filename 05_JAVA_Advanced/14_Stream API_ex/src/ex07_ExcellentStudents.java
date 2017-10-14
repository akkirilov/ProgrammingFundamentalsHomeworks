import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex07_ExcellentStudents {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		Sara Mills 6 5 4 3 
//		Daniel Carter 6 4 3 2 
//		Aaron Gibson 6 5 3 3 
//		Mildred Hansen 6 5 5 2 
//		Cheryl Gray 6 5 2 2 
//		Craig King 6 4 4 3 
//		Craig Ellis 6 5 5 3 
//		Steven Cole 6 4 4 2 
//		Margaret Peterson 6 6 4 2 
//		Jonathan Gibson 6 6 6 6 
//		Susan Boyd 6 6 4 2 
//		Lois Patterson 6 6 5 3 
//		Craig Flores 6 5 4 4 
//		Justin Watkins 6 5 4 2 
//		Jesse Howard 6 6 3 2 
//		Helen Hernandez 6 6 5 3 
//		Lillian Hart 6 4 4 4 
//		Heather Knight 6 4 3 2 
//		Bonnie Shaw 6 5 5 4 
//		Nancy Patterson 6 2 2 2 
//		Gerald Diaz 6 5 5 3 
//		Ashley Lee 6 5 4 3 
//		Marie Simpson 6 5 5 2 
//		Melissa Robinson 6 3 3 2 
//		Rebecca Torres 6 5 4 2 
//		Gloria Harvey 6 5 5 2 
//		Gerald Watson 6 6 5 2 
//		Gloria Schmidt 6 6 4 2 
//		Fred Simmons 6 4 4 4 
//		Charles Alvarez 6 5 2 2 
//		Rose Hernandez 6 6 5 2 
//		Terry Pierce 6 6 3 3 
//		Robin Long 6 4 4 4 
//		Tina Olson 6 6 5 2 
//		Terry Frazier 6 6 5 2 
//		Emily Howard 6 3 3 2 
//		Marilyn Clark 6 6 4 4 
//		Beverly Clark 6 5 3 2 
//		Theresa Simpson 6 6 3 2 
//		Amanda Hernandez 6 4 2 2 
//		William Garcia 6 5 5 5 
//		Billy Bowman 6 4 3 2 
//		David Johnston 6 4 4 3 
//		Arthur James 6 5 5 3 
//		Helen Williamson 6 4 2 2 
//		Anne Powell 6 5 4 3 
//		Elizabeth James 6 6 2 2 
//		Mildred Hart 6 6 5 5 
//		Cynthia Olson 6 6 5 2 
//		Catherine Diaz 6 5 4 2 
//		Antonio Rodriguez 6 6 3 3 
//		Maria Price 6 4 4 2 
//		Ann Anderson 6 5 5 4 
//		Diana Flores 6 5 5 2 
//		Shirley Hall 6 6 6 4 
//		Justin Reyes 6 4 3 2 
//		Edward Nelson 6 5 3 3 
//		Ruby Lewis 6 4 3 3
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			
			for (int i = 2; i < input.length; i++) {
				temp.addGrade(Integer.parseInt(input[i]));
			}
			
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		students.stream()
			.filter(Student.isLeastOneExcellentGrade)
			.forEach(x -> System.out.println(x.getFullNameAndGrades()));

	}

}
