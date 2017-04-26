package akkProject.repository;

import akkProject.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer>{
    News findByUserId(Integer id);
}
