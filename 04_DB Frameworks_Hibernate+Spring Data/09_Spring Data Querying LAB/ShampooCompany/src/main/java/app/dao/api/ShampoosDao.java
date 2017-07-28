package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoo;
import app.model.ClassicLabel;
import app.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ShampoosDao extends JpaRepository<BasicShampoo, Long> {
    
	@Query("Select s from BasicShampoos s join s.ingredients i where i.name = :ingredientName")
    List<BasicShampoo> shampoosWithIngredient(@Param("ingredientName") String ingredientName);

    List<BasicShampoo> findByBrandOrLabel(String brandName, ClassicLabel label);

	List<BasicShampoo> findByBrand(String brandName);

	List<BasicShampoo> findByBrandAndSize(String brandName, int size);

	List<BasicShampoo> findBySizeAndLabel(int size, ClassicLabel label);

	List<BasicShampoo> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price);

	List<BasicShampoo> findByPriceLessThan(BigDecimal price);

	@Query("SELECT bs FROM BasicShampoos bs WHERE bs.label = :classicLabel")
	List<BasicShampoo> findByLabelJPQL(@Param("classicLabel") ClassicLabel classicLabel);

	@Query("SELECT bs FROM BasicShampoos bs JOIN bs.ingredients bsi WHERE bsi IN :basicIngredients")
	List<BasicShampoo> findByIngredientInListJPQL(@Param("basicIngredients") List<BasicIngredient> basicIngredients);

	@Query("SELECT bs FROM BasicShampoos bs WHERE bs.ingredients.size < :number")
	List<BasicShampoo> findByIngredientCountLowerThanNumberJPQL(@Param("number") Integer number);

	@Query("SELECT bs FROM BasicShampoos bs WHERE bs.batch.date < :date")
	List<BasicShampoo> findByBatchDateBeforeGivenDateJPQL(@Param("date") Date date);

	@Query("SELECT bs FROM BasicShampoos bs JOIN bs.ingredients bsi GROUP BY bs.id HAVING SUM(bsi.price) < :price ")
	List<BasicShampoo> findByIngredientsSumLowerThanGivenPriceJPQL(@Param("price") BigDecimal price);

	@Query("SELECT bs FROM BasicShampoos bs WHERE bs.batch = :batch AND bs.label.subTitle != :subTitle")
	List<BasicShampoo> findByBatchIdAndSubTitleDifferentThanGivenJPQL(@Param("batch") ProductionBatch batch, @Param("subTitle") String subTitle);
	
}
