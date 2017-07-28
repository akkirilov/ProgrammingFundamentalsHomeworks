package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
