package app.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.BasicChemicalIngredient;

@Repository
public interface ChemicalIngredientDao extends JpaRepository<BasicChemicalIngredient, Long> {

	BasicChemicalIngredient findOneByName(String name);

}
