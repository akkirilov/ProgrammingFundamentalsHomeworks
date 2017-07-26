package app.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Course;
import app.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void saveAndFlush(Course course) {
		courseRepository.saveAndFlush(course);
	}
	
	public void save(Course course) {
		courseRepository.save(course);
	}
	
	public void save(List<Course> courses) {
		courseRepository.save(courses);
	}
	
	public Course findOneById(Long id) {
		return courseRepository.findOne(id);
	}
	
	public Course findOneByName(String name) {
		return courseRepository.findByName(name);
	}
	
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public boolean isExist(Course course) {
		return courseRepository.exists(course.getId());
	}

	public List<Course> findCoursesAndOrderByStartDate() {
		return courseRepository.findAllByOrderByStartDateAscEndDateDesc();
	}

	public List<Course> findCoursesByResoursesCountMoreThan(Integer count) {
		return courseRepository.findAllByResourcesMoreThan(count);
	}

	public List<Course> findCoursesByActiveDate(Date date) {
		return courseRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(date, date);
	}
	
}
