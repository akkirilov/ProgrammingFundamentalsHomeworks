package app.dao.api;

import app.model.ClassicLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassicLabelDao extends JpaRepository<ClassicLabel, Long> {
	
}
