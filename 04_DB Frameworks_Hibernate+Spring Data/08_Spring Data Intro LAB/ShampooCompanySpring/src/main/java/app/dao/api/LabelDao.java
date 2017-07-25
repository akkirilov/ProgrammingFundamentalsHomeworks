package app.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.ClassicLabel;

@Repository
public interface LabelDao extends JpaRepository<ClassicLabel, Long> {

	ClassicLabel findOneByTitle(String title);

}
