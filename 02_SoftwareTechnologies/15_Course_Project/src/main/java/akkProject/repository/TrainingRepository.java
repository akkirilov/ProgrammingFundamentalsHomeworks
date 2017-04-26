package akkProject.repository;

import akkProject.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Basel on 26.4.2017 г..
 */
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    Training findByTrainingUserId(Integer id);
}
