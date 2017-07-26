package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Student;
import app.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void saveAndFlush(Student student) {
		studentRepository.saveAndFlush(student);
	}
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public void save(List<Student> students) {
		studentRepository.save(students);
	}
	
	public Student findOneById(Long id) {
		return studentRepository.findOne(id);
	}
	
	public Student findOneByName(String name) {
		return studentRepository.findByName(name);
	}
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public boolean isExist(Student student) {
		return studentRepository.exists(student.getId());
	}
	
}
