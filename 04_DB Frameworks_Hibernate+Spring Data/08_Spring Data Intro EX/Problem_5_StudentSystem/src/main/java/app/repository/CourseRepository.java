package app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findByName(String name);

	List<Course> findAllByOrderByStartDateAscEndDateDesc();

	@Query("SELECT c FROM Course AS c WHERE c.resources.size > :min ORDER BY c.resources.size DESC")
	List<Course> findAllByResourcesMoreThan(@Param("min") Integer min);

	List<Course> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date date1, Date date2);

}
