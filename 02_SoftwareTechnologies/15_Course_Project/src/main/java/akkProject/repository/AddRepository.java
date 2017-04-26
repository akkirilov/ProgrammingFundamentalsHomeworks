package akkProject.repository;

import akkProject.entity.Add;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddRepository extends JpaRepository<Add, Integer>{
    Add findByUserId(Integer id);
}
