import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex05_FilterStudentsByEmailDomain {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		Mildred Hansen mhansen4@gmail.com
//		Marie Simpson msimpson13@gmail.com
//		Frances Peters fpeters1p@gmail.com
//		Anne Powell apowell2a@gmail.com
//		Diana Flores dflores2k@gmail.com
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(input[0]);
			temp.setLastName(input[1]);
			temp.setEmail(input[2]);
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		students.stream()
			.filter(Student.isGMailDomain)
			.forEach(x -> System.out.println(x.getFullNameAndEmail()));

	}

}
