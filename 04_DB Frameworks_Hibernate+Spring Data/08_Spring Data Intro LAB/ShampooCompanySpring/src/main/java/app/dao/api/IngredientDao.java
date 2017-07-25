package app.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.BasicIngredient;

@Repository
public interface IngredientDao extends JpaRepository<BasicIngredient, Long> {

	BasicIngredient findOneByName(String name);
	
}
