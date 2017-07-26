package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.model.Course;
import app.model.Homework;
import app.model.License;
import app.model.Resource;
import app.model.Student;
import app.services.CourseService;
import app.services.LicenseService;
import app.services.ResourceService;
import app.services.StudentService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	@Autowired
	StudentService studentService = new StudentService();
	
	@Autowired
	LicenseService licenseService = new LicenseService();
	
	@Autowired
	CourseService courseService = new CourseService();
	
	@Autowired
	ResourceService resourceService = new ResourceService();

	@Override
	public void run(String... args) throws Exception {
		
		Random random = new Random();
		
		Scanner scanner = new Scanner(System.in);
		String line = "";
		while (true) {
			System.out.println("6 = seed data");
			System.out.println("71 = list students and homeworks");
			System.out.println("72 = list courses and resources");
			System.out.println("73 = list all courses with resources more than...");
			System.out.println("74 = list all active courses by date");
			System.out.println("75 = list student's course info");
			System.out.println("8 = Add random licenses to resources");
			line = scanner.nextLine();
			if (line.equals("0")) {
				break;
			}
			switch (line) {
			case "71":
				List<Student> students1 = studentService.findAll();
				for (Student student : students1) {
					System.out.println(student.getName());
					for (Homework homework : student.getHomeworks()) {
						System.out.println(homework.getContent() + " - " + homework.getType());
					}
				}
				break;
		case "72":
			List<Course> courses = courseService.findCoursesAndOrderByStartDate();
			for (Course course : courses) {
				System.out.println(course.getName() + " - " + course.getResources().size());
				System.out.println("Resources:");
				for (Resource resource : course.getResources()) {
					System.out.println("---> " + resource.getName());
				}
			}
			break;
		case "73":
			System.out.println("Enter min count: ");
			Integer count = Integer.parseInt(scanner.nextLine());
			List<Course> coursesFind = courseService.findCoursesByResoursesCountMoreThan(count);
			for (Course course : coursesFind) {
				System.out.println(course.getName() + " - " + course.getResources().size());
			}
			break;
		case "74":
			System.out.println("Enter date in format 'yyyy-MM-dd': ");		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(scanner.nextLine());
			List<Course> coursesFind1 = courseService.findCoursesByActiveDate(date);
			for (Course course : coursesFind1) {
				
			}
			break;
		case "75":
			List<Student> students2 = studentService.findAll();
			students2 = students2
					.stream()
					.sorted((a, b) -> {
						int res = 0;
						BigDecimal pb = new BigDecimal("0");
						for (Course c : b.getCourses()) {
							pb = pb.add(c.getPrice());
						}
						BigDecimal pa = new BigDecimal("0");
						for (Course c : a.getCourses()) {
							pa = pa.add(c.getPrice());
						}
						
						return pb.compareTo(pa);
					})
					.collect(Collectors.toList());
			for (Student student : students2) {
				BigDecimal total = new BigDecimal("0");
				for (Course c : student.getCourses()) {
					total = total.add(c.getPrice());
				}
				BigDecimal avarage = new BigDecimal(total.toString());
				Long size = (long) student.getCourses().size();
				avarage = avarage.divide(BigDecimal.valueOf(size), RoundingMode.FLOOR);
				System.out.println(student.getName() + " - " + size + ", total = " + total.toString() + ", avarage = "  + avarage.toString());
			}
			break;
		case "8":
			License license1 = new License();
			license1.setName("license1");
			License license2 = new License();
			license2.setName("license2");
			License license3 = new License();
			license3.setName("license3");
			License license4 = new License();
			license4.setName("license4");
			License license5 = new License();
			license5.setName("license5");
			License license6 = new License();
			license6.setName("license6");
			License license7 = new License();
			license7.setName("license7");
			List<License> licenses = new ArrayList<>();
			licenses.add(license1);
			licenses.add(license2);
			licenses.add(license3);
			licenses.add(license4);
			licenses.add(license5);
			licenses.add(license6);
			licenses.add(license7);
			List<Resource> resources = resourceService.findAllWithoutLicenses();
			for (Resource resource : resources) {
				Set<License> licensesToAdd = new HashSet<>();
				int lenght = random.nextInt(licenses.size());
				if (lenght == 0) {
					lenght = 1;
				}
				for (int i = 0; i < lenght; i++) {
					int index = random.nextInt(licenses.size() - 1);
					if (index < 0) {
						index = 0;
					}
					licensesToAdd.add(licenses.get(index));
				}
				
				resource.setLicenses(licensesToAdd);
			}
			
			resourceService.save(resources);
			
			break;
		case "6":
			Resource resource1 = new Resource();
			resource1.setName("name1");
			resource1.setType("email");
			resource1.setUrl("www.www.www");
			Resource resource2 = new Resource();
			resource2.setName("name2");
			resource2.setType("email");
			resource2.setUrl("www.www.www");
			Resource resource3 = new Resource();
			resource3.setName("name3");
			resource3.setType("email");
			resource3.setUrl("www.www.www");
			Resource resource4 = new Resource();
			resource4.setName("name4");
			resource4.setType("email");
			resource4.setUrl("www.www.www");
			Resource resource5 = new Resource();
			resource5.setName("name5");
			resource5.setType("email");
			resource5.setUrl("www.www.www");
			Resource resource6 = new Resource();
			resource6.setName("name6");
			resource6.setType("email");
			resource6.setUrl("www.www.www");
			Set<Resource> resources1 = new HashSet<>();
			resources1.add(resource1);
			resources1.add(resource2);
			resources1.add(resource3);
			Set<Resource> resources2 = new HashSet<>();
			resources2.add(resource1);
			resources2.add(resource3);
			resources2.add(resource4);
			resources2.add(resource5);
			Set<Resource> resources3 = new HashSet<>();
			resources3.add(resource1);
			resources3.add(resource2);
			resources3.add(resource3);
			resources3.add(resource4);
			resources3.add(resource5);
			resources3.add(resource6);
			
			Course course1 = new Course();
			course1.setDescription("description1");
			course1.setName("name1");
			course1.setPrice(new BigDecimal("100.00"));
			course1.setStartDate(new Date());
			course1.setEndDate(new Date());
			course1.setResources(resources1);
			Course course2 = new Course();
			course2.setDescription("description2");
			course2.setResources(resources2);
			course2.setName("name2");
			course2.setPrice(new BigDecimal("200.00"));
			course2.setStartDate(new Date());
			course2.setEndDate(new Date());
			Course course3 = new Course();
			course3.setDescription("description3");
			course3.setName("name3");
			course3.setPrice(new BigDecimal("300.00"));
			course3.setStartDate(new Date());
			course3.setEndDate(new Date());
			course3.setResources(resources3);
			Course course4 = new Course();
			course4.setDescription("description3");
			course4.setName("name3");
			course4.setPrice(new BigDecimal("300.00"));
			course4.setStartDate(new Date());
			course4.setEndDate(new Date());
			course4.setResources(resources3);
			Course course5 = new Course();
			course5.setDescription("description3");
			course5.setName("name3");
			course5.setPrice(new BigDecimal("300.00"));
			course5.setStartDate(new Date());
			course5.setEndDate(new Date());
			course5.setResources(resources3);
			Set<Course> courses1 = new HashSet<>();
			courses1.add(course1);
			courses1.add(course2);
			courses1.add(course3);
			Set<Course> courses2 = new HashSet<>();
			courses2.add(course1);
			courses2.add(course3);
			courses2.add(course4);
			Set<Course> courses3 = new HashSet<>();
			courses1.add(course1);
			courses3.add(course2);
			courses3.add(course3);
			courses3.add(course4);
			courses3.add(course5);
			
			Homework homework1 = new Homework();
			homework1.setContent("content1");
			homework1.setType("zip");
			homework1.setSubmitionDate(new Date());
			homework1.setCourse(course1);
			Homework homework2 = new Homework();
			homework2.setContent("content2");
			homework2.setType("rar");
			homework2.setSubmitionDate(new Date());
			homework2.setCourse(course2);
			Homework homework3 = new Homework();
			homework3.setContent("content3");
			homework3.setType("7zip");
			homework3.setSubmitionDate(new Date());
			homework3.setCourse(course3);
			Set<Homework> homeworks1 = new HashSet<>();
			homeworks1.add(homework1);
			Set<Homework> homeworks2 = new HashSet<>();
			homeworks2.add(homework2);
			Set<Homework> homeworks3 = new HashSet<>();
			homeworks3.add(homework3);
			
			Student student1 = new Student();
			student1.setRegistrationDate(new Date());
			student1.setBirthDate(new Date());
			student1.setName("Gosho1");
			student1.setPhoneNumber("0888777666");
			student1.setCourses(courses1);
			student1.setHomeworks(homeworks1); 
			Student student2 = new Student();
			student2.setRegistrationDate(new Date());
			student2.setBirthDate(new Date());
			student2.setName("Gosho2");
			student2.setPhoneNumber("0888777666");
			student2.setCourses(courses2);
			student2.setHomeworks(homeworks2); 
			Student student3 = new Student();
			student3.setRegistrationDate(new Date());
			student3.setBirthDate(new Date());
			student3.setName("Gosho3");
			student3.setPhoneNumber("0888777666");
			student3.setCourses(courses3);
			student3.setHomeworks(homeworks3); 
			
			List<Student> students = new ArrayList<>();
			students.add(student1);
			students.add(student2);
			students.add(student3);
			
			studentService.save(students);
			break;

		default:
			break;
		}
			
			
		}
		scanner.close();
		
	}
    
}
