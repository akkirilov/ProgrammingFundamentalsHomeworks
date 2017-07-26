package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Course;
import app.model.Homework;
import app.model.Student;
import app.repository.HomeworkRepository;

@Service
@Transactional
public class HomeworkService {
	
	@Autowired
	private HomeworkRepository homeworkRepository;
	
	public void saveAndFlush(Homework homework) {
		homeworkRepository.saveAndFlush(homework);
	}
	
	public void save(Homework homework) {
		homeworkRepository.save(homework);
	}
	
	public void save(List<Homework> homeworks) {
		homeworkRepository.save(homeworks);
	}
	
	public Homework findOneById(Long id) {
		return homeworkRepository.findOne(id);
	}
	
	//public List<Homework> findAllByStudent(Student student) {
	//	return homeworkRepository.findAllByStudent(student);
	//}
	
	//public List<Homework> findAllByCourse(Course course) {
	//	return homeworkRepository.findAllByCourse(course);
	//}
	
	public List<Homework> findAll() {
		return homeworkRepository.findAll();
	}
	
	public boolean isExist(Homework homework) {
		return homeworkRepository.exists(homework.getId());
	}
	
}
