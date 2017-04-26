package akkProject.repository;

import akkProject.entity.AddCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddCategoryRepository extends JpaRepository<AddCategory, Integer> {
    AddCategory findByName(String name);
}
