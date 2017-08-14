package akkProject.repository;

import akkProject.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    MainCategory findByCategoryName(String categoryName);
}
