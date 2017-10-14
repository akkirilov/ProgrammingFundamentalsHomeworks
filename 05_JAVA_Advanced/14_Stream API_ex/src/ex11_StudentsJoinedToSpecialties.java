import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ex11_StudentsJoinedToSpecialties {

	public static void main(String[] args) throws IOException {
		
		List<StudentSpecialty> specialties = new LinkedList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("Students:")) {
			
			StudentSpecialty temp = new StudentSpecialty();
			temp.setName(tokens[0] + " " + tokens[1]);
			temp.setFacultyNumber(tokens[2]);
			
			specialties.add(temp);
			
			tokens = reader.readLine().split("\\s+");
		}
		
		List<Student> students = new LinkedList<>();
		
		tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFirstName(tokens[1]);
			temp.setLastName(tokens[2]);
			temp.setFacultyNumber(tokens[0]);
			
			for (StudentSpecialty ss : specialties) {
				if (ss.getFacultyNumber().equals(tokens[0])) {
					temp.addStudentSpecialty(ss);
				}
			}
			students.add(temp);
			
			tokens = reader.readLine().split("\\s+");
		}
		
		reader.close();
		
		students = students.stream()
				.sorted(Student.sortFirstNameAscLastNameAsc)
				.collect(Collectors.toList());
		
		TreeSet<String> toPrint = new TreeSet<>();
		for (Student s : students) {
			for (StudentSpecialty ss : s.getStudentSpecialties()) {
				toPrint.add(s.getFullName() + " " + s.getFacultyNumber() + " " + ss.getName());
			}
		}
				
		System.out.println(toPrint.toString().replaceAll("\\[|\\]", "").replaceAll(",\\s", "\r\n"));

	}

}
