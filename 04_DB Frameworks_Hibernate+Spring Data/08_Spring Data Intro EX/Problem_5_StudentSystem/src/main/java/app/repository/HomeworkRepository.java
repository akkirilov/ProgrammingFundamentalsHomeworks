package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Course;
import app.model.Homework;
import app.model.Student;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {

	//List<Homework> findAllByStudent(Student student);

	//List<Homework> findAllByCourse(Course course);

}
