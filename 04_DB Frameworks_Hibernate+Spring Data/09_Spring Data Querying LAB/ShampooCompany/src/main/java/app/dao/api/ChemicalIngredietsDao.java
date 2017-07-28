package app.dao.api;

import app.model.BasicChemicatIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemicalIngredietsDao extends JpaRepository<BasicChemicatIngredient, Long> {
    
	List<BasicChemicatIngredient> findByChemicalFormula(String chemicalFormula);
	
}
