import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex06_FilterStudentsByPhone {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		Ashley Lee +35920412542
//		Michelle Daniels +35922450998
//		Charles Alvarez 02913942
//		Kathryn Lee 02496788
//		Nicholas Reyes 02758283
//		Amanda Hernandez 02667077
//		Catherine Porter 02533314
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			temp.setPhone(input[2]);
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		students.stream()
			.filter(Student.isStudentPhoneInSofia)
			.forEach(x -> System.out.println(x.getFullNameAndPhone()));

	}

}
