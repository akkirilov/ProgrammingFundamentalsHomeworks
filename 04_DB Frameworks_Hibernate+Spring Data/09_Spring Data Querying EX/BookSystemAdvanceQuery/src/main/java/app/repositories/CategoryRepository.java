package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findAllByNameIn(String[] inputStrArr);
	
}
