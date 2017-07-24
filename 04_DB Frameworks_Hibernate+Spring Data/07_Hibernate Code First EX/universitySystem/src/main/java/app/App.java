package app;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Course;
import model.Student;
import model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();
    			
    	Student student1 = new Student("Gosho", "Goshevsky", "6526651235158", 2.32, true);
    	Student student2 = new Student("Pesho", "Goshevsky", "6526651235158", 2.32, true);
    	Student student3 = new Student("Marcho", "Goshevsky", "6526651235158", 2.32, true);
    	Student student4 = new Student("Tosho", "Goshevsky", "6526651235158", 2.32, true);
    	Student student5 = new Student("Pencho", "Goshevsky", "6526651235158", 2.32, true);
    	Student student6 = new Student("Racho", "Goshevsky", "6526651235158", 2.32, true);
    	Set<Student> students1 = new HashSet<Student>();
    	students1.add(student1);
    	students1.add(student2);
    	students1.add(student3);
    	Set<Student> students2 = new HashSet<Student>();
    	students2.add(student4);
    	students2.add(student5);
    	students2.add(student6);
    	Set<Student> students3 = new HashSet<Student>();
    	students3.add(student1);
    	students3.add(student2);
    	students3.add(student3);
    	students3.add(student4);
    	students3.add(student5);
    	students3.add(student6);

    	Teacher teacher1 = new Teacher("Tancho", "Ganchevsky", "5454154", "asasa@assa.sa", 0.54);
    	Teacher teacher2 = new Teacher("Petrancho", "Ganchevsky", "5454154", "asasa@assa.sa", 0.44);
    	
    	Course course1 =new Course("Matem", "Matem description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(24)), 5);
    	Course course2 =new Course("Liter", "Liter description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(24)), 5);
    	Course course3 =new Course("Geo", "Geo description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(24)), 5);

    	course1.setTeacher(teacher1);
    	course2.setTeacher(teacher2);
    	course1.setStudents(students1);
    	course2.setStudents(students2);
    	course3.setTeacher(teacher1);
    	course3.setStudents(students3);
    	
    	
    	em.getTransaction().begin();
    	
    	em.persist(course1);
    	em.persist(course2);
    	em.persist(course3);

    	em.getTransaction().commit();

    	em.close();
    	emf.close();
    }
}
