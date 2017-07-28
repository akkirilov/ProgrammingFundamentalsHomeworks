package app.dao.api;

import app.model.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.NamedQuery;

public interface IngredientsDao extends JpaRepository<BasicIngredient, Long>, IngedientsDaoCustom {
	
    List<BasicIngredient> findByNameEndingWith (String suffix);

	List<BasicIngredient> findByPriceIsNullOrderByNameDesc();

	List<BasicIngredient> findByNameStartingWith(String input);

	List<BasicIngredient> findByIdIn(List<Long> ids);

	@Query("SELECT bi FROM BasicIngredient bi WHERE bi.name IN :names ORDER BY bi.id DESC")
	List<BasicIngredient> findByNameInListJPQL(@Param("names") List<String> names);
	
	List<BasicIngredient> findByPriceSumsGreaterThanGivenPriceNJPQL(@Param("price") BigDecimal price);
	
	@Modifying
	void deleteByNameNJPQL(@Param("name") String name);
	
	@Modifying
	void increasePriceByGivenPercentNJPQL(@Param("percent") Integer percent);
	
	@Modifying
	void increasePriceByGivenPercentOfListedIngredientsNJPQL(@Param("percent") Integer percent, @Param("ingredients") List<BasicIngredient> ingredients);
	
}
