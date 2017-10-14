import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex03_StudentsByAge {

	public static void main(String[] args) throws IOException {

//		As Plain text = 100/100
//		Mildred Hansen 22
//		Craig Ellis 21
//		Andrea Harper 23
//		Richard Edwards 20
//		Margaret Peterson 19
//		Jonathan Gibson 21
//		Daniel Ferguson 21
//		Craig Flores 22
//		Jesse Howard 18
//		Heather Knight 20
//		Bonnie Shaw 23
//		Marie Simpson 24
//		Michelle Daniels 19
//		Terry Pierce 18
//		Theresa Simpson 21
//		Amanda Hernandez 24
//		Stephen Roberts 24
//		William Garcia 18
//		Billy Bowman 24
//		David Johnston 23
//		Cynthia Olson 23
//		Fred Andrews 20
//		Diana Flores 23
//		Justin Reyes 23
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {

			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			temp.setAge(Integer.parseInt(input[2]));
			students.add(temp);

			input = reader.readLine().split("\\s+");

		}

		reader.close();

		students.stream()
				.filter(Student.isAgeBetween18and24)
				.forEach(x -> System.out.println(x.getFullNameAndAge()));

	}

}
