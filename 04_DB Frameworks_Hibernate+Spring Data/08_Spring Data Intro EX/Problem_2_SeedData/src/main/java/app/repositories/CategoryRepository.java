package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
