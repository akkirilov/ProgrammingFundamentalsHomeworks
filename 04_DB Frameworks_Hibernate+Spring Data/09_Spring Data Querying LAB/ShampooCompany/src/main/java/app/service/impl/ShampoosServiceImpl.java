package app.service.impl;

import app.dao.api.ClassicLabelDao;
import app.dao.api.ShampoosDao;
import app.model.BasicIngredient;
import app.model.ClassicLabel;
import app.model.ProductionBatch;
import app.service.api.ShampoosService;
import app.model.BasicShampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShampoosServiceImpl implements ShampoosService<BasicShampoo, Long> {

    @Autowired
    private ShampoosDao dao;

    @Autowired
    private ClassicLabelDao classicLabelDao;

    @Override
    public BasicShampoo findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicShampoo object) {
        dao.delete(object);
    }

    @Override
    public List<BasicShampoo> findAll(Class<BasicShampoo> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicShampoo shampoo) {
        dao.saveAndFlush(shampoo);
    }

    @Override
    public List<BasicShampoo> shampoosWithIngredient(String ingredient) {
        return dao.shampoosWithIngredient(ingredient);
    }

	@Override
	public void save(List<BasicShampoo> shampoosToSave) {
		dao.save(shampoosToSave);
	}

	@Override
	public List<BasicShampoo> findByBrand(String brandName) {
		return dao.findByBrand(brandName);
	}

	@Override
	public List<BasicShampoo> findByBrandAndSize(String brandName, int size) {
		return dao.findByBrandAndSize(brandName, size);
	}

	@Override
	public List<BasicShampoo> findBySizeAndLabel(int size, ClassicLabel label) {
		return dao.findBySizeAndLabel(size, label);
	}

	@Override
	public List<BasicShampoo> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price) {
		return dao.findByPriceGreaterThanOrderByBrandDesc(price);
	}

	@Override
	public List<BasicShampoo> findByPriceLowerThan(BigDecimal price) {
		return dao.findByPriceLessThan(price);
	}

	@Override
	public List<BasicShampoo> findByLabelJPQL(ClassicLabel classicLabel) {
		return dao.findByLabelJPQL(classicLabel);
	}

	@Override
	public List<BasicShampoo> findByIngredientInListJPQL(List<BasicIngredient> basicIngredients) {
		return  dao.findByIngredientInListJPQL(basicIngredients);
	}

	@Override
	public List<BasicShampoo> findByIngredientCountLowerThanNumberJPQL(Integer number) {
		return  dao.findByIngredientCountLowerThanNumberJPQL(number);
	}

	@Override
	public List<BasicShampoo> findByBatchDateBeforeGivenDateJPQL(Date date) {
		return  dao.findByBatchDateBeforeGivenDateJPQL(date);
	}

	@Override
	public List<BasicShampoo> findByIngredientsSumLowerThanGivenPriceJPQL(BigDecimal price) {
		return dao.findByIngredientsSumLowerThanGivenPriceJPQL(price);
	}

	@Override
	public List<BasicShampoo> findByBatchIdAndSubTitleDifferentThanGivenJPQL(ProductionBatch productionBatch,
			String subTitle) {
		return dao.findByBatchIdAndSubTitleDifferentThanGivenJPQL(productionBatch, subTitle);
	}

}
