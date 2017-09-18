package akkProject.repository;

import akkProject.entity.TrainingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, Integer>{
    TrainingCategory findByTrainingCategoryName(String trainingCategoryName);
}
