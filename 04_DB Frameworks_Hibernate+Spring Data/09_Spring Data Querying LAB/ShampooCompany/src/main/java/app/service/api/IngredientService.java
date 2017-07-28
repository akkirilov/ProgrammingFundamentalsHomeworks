package app.service.api;

import app.model.BasicChemicatIngredient;
import app.model.BasicIngredient;
import app.model.BasicShampoo;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService<BasicIngredient, Long> extends ServiceInterface<BasicIngredient, Long> {
    List<app.model.BasicIngredient> findByNameEndsWith (String suffix);
    List<BasicShampoo> shampoosWithIngredient(BasicIngredient ingredient);

    List<BasicChemicatIngredient> findChemicalIngWithFormula(String formula);
	List<BasicIngredient> findByPriceIsNullOrderByNameDesc();
	List<BasicIngredient> findByNameStartingWith(String input);
	List<BasicIngredient> findByIdIn(List<Long> ids);
	List<BasicIngredient> findByNameInListJPQL(List<String> names);
	List<BasicIngredient> findByPriceSumsGreaterThanGivenPriceNJPQL(BigDecimal price);
	void deleteByNameNJPQL(String name);
	void increasePriceByGivenPercentNJPQL(Integer percent);
	void increasePriceByGivenPercentOfListedIngredientsNJPQL(Integer percent, List<BasicIngredient> ingredients);
	
}
