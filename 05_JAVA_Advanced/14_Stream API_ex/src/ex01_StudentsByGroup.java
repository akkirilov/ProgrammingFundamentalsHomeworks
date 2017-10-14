import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex01_StudentsByGroup {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		Albert Cruz
//		Amanda Hernandez
//		Arthur James
//		Fred Andrews
//		Helen Hernandez
//		Justin Reyes
//		Lawrence Hernandez
//		Mildred Hart
//		Nancy Patterson
//		Nicholas Reyes
//		Rebecca Torres
//		Richard Edwards
//		Susan Boyd
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			temp.setGroup(Integer.parseInt(input[2]));
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		students.stream()
			.filter(x -> x.getGroup() == 2)
			.sorted(Student.sortFirstNameAsc)
			.forEach(x -> System.out.println(x.getFullName()));

	}

}
