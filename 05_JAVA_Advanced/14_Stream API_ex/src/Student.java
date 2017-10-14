import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Student {
	
	public static final Predicate<Student> isFirstNameBeforeLastName = 
			x -> x.getFirstName().compareTo(x.getLastName()) < 0;
	
	public static final Predicate<Student> isAgeBetween18and24 = 
			x -> x.getAge() >= 18 && x.getAge() <= 24;
			
	public static final Predicate<Student> isGMailDomain = 
			x -> x.getEmail().endsWith("gmail.com");
			
	public static final Predicate<Student> isStudentPhoneInSofia = 
			x -> x.getPhone().startsWith("02") || x.getPhone().startsWith("+3592");
			
	public static final Predicate<Student> isLeastOneExcellentGrade = 
			x ->  x.getGrades().contains(6);
			
	public static final Predicate<Student> isLeastTwoWeakGrades = 
			x ->  x.getGrades()
					.stream()
					.filter(a -> a <= 3)
					.mapToInt(Integer::valueOf)
					.count() >= 2;
					
	public static final Predicate<Student> isEnrolledIn2014or2015 = 
			x -> x.getFacultyNumber().endsWith("14") || x.getFacultyNumber().endsWith("15") ;
					
	public static final Comparator<Student> sortFirstNameAsc = 
			(a, b) -> a.getFirstName().compareTo(b.getFirstName());
	
	public static final Comparator<Student> sortLastNameAscFirstNameDesc = 
			(a, b) -> {
				int res = a.getLastName().compareTo(b.getLastName());
				if (res == 0) {
					res = b.getFirstName().compareTo(a.getFirstName());
				}
				return res;
			};

	public static final Comparator<Student> sortFirstNameAscLastNameAsc = 
			(a, b) -> {
				int res = a.getFirstName().compareTo(b.getFirstName());
				if (res == 0) {
					res = a.getLastName().compareTo(b.getLastName());
				}
				return res;
			};
					
						
			
	private String firstName;
	
	private String lastName;
	
	private Integer group;
	
	private Integer age;
	
	private String email;
	
	private String phone;
	
	List<Integer> grades;
	
	List<StudentSpecialty> studentSpecialties;
	
	private String facultyNumber;

	public Student() {
		super();
		grades = new LinkedList<>();
		studentSpecialties =  new LinkedList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFullNameAndAge() {
		return firstName + " " + lastName + " " + age;
	}
	
	public String getFullNameAndEmail() {
		return firstName + " " + lastName + " " + email;
	}
	
	public String getFullNameAndPhone() {
		return firstName + " " + lastName + " " + phone;
	}

	public String getFullNameAndGrades() {
		return firstName + " " + lastName + " " + grades.toString().replaceAll("\\[|\\]|,", "");
	}
	
	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Integer> getGrades() {
		return grades;
	}
	
	public String getGradesAsLine() {
		return grades.toString().replaceAll("\\[|\\]|,", "");
	}

	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
	
	public void addGrade(Integer grade) {
		this.grades.add(grade);
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public List<StudentSpecialty> getStudentSpecialties() {
		return studentSpecialties;
	}

	public void setStudentSpecialties(List<StudentSpecialty> studentSpecialties) {
		this.studentSpecialties = studentSpecialties;
	}
	
	public void addStudentSpecialty(StudentSpecialty studentSpecialty) {
		this.studentSpecialties.add(studentSpecialty);
	}
	
}
