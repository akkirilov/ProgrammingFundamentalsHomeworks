package app.service.api;

import app.model.BasicIngredient;
import app.model.ClassicLabel;
import app.model.ProductionBatch;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ShampoosService<BasicShampoos, Long> extends ServiceInterface<BasicShampoos, Long> {

    List<BasicShampoos> shampoosWithIngredient(String ingredientName);

    
    
	void save(List<BasicShampoos> shampoosToSave);

	List<BasicShampoos> findByBrand(String brandName);

	List<BasicShampoos> findByBrandAndSize(String brandName, int size);

	List<BasicShampoos> findBySizeAndLabel(int size, ClassicLabel label);

	List<BasicShampoos> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price);



	List<BasicShampoos> findByPriceLowerThan(BigDecimal price);



	List<BasicShampoos> findByLabelJPQL(ClassicLabel classicLabel);



	List<BasicShampoos> findByIngredientInListJPQL(List<BasicIngredient> basicIngredients);



	List<BasicShampoos> findByIngredientCountLowerThanNumberJPQL(Integer number);



	List<BasicShampoos> findByBatchDateBeforeGivenDateJPQL(Date date);



	List<BasicShampoos> findByIngredientsSumLowerThanGivenPriceJPQL(BigDecimal price);



	List<BasicShampoos> findByBatchIdAndSubTitleDifferentThanGivenJPQL(ProductionBatch productionBatch,
			String subTitle);

	
}

