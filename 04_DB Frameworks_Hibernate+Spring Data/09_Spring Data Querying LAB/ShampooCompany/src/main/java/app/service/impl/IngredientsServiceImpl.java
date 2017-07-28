package app.service.impl;

import app.dao.api.ChemicalIngredietsDao;
import app.dao.api.IngredientsDao;
import app.model.BasicChemicatIngredient;
import app.model.BasicShampoo;
import app.service.api.IngredientService;
import app.model.BasicIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientService<BasicIngredient, Long> {

    @Autowired
    private IngredientsDao ingredientsDao;

    @Autowired
    private ChemicalIngredietsDao chemicalIngredietsDao;

    @Override
    public BasicIngredient findById(Long id) {
        return ingredientsDao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient object) {
        ingredientsDao.delete(object);
    }

    @Override
    public List<BasicIngredient> findAll(Class<BasicIngredient> serviceClass) {
        return ingredientsDao.findAll();
    }

    @Override
    public void save(BasicIngredient object) {
        ingredientsDao.save(object);
    }

    @Override
    public List<BasicIngredient> findByNameEndsWith(String suffix) {
        return ingredientsDao.findByNameEndingWith(suffix);
    }

    @Override
    public List<BasicShampoo> shampoosWithIngredient(BasicIngredient ingredient) {
        return ingredientsDao.shampoosWithIngredient(ingredient);
    }

    @Override
    public List<BasicChemicatIngredient> findChemicalIngWithFormula (String formula) {
        return chemicalIngredietsDao.findByChemicalFormula(formula);
    }

	@Override
	public List<BasicIngredient> findByPriceIsNullOrderByNameDesc() {
		return ingredientsDao.findByPriceIsNullOrderByNameDesc();
	}

	@Override
	public List<BasicIngredient> findByNameStartingWith(String input) {
		return ingredientsDao.findByNameStartingWith(input);
	}

	@Override
	public List<BasicIngredient> findByIdIn(List<Long> ids) {
		return ingredientsDao.findByIdIn(ids);
	}

	@Override
	public List<BasicIngredient> findByNameInListJPQL(List<String> names) {
		return ingredientsDao.findByNameInListJPQL(names);
	}

	@Override
	public List<BasicIngredient> findByPriceSumsGreaterThanGivenPriceNJPQL(BigDecimal price) {
		return ingredientsDao.findByPriceSumsGreaterThanGivenPriceNJPQL(price);
	}

	@Override
	public void deleteByNameNJPQL(String name) {
		ingredientsDao.deleteByNameNJPQL(name);
	}

	@Override
	public void increasePriceByGivenPercentNJPQL(Integer percent) {
		ingredientsDao.increasePriceByGivenPercentNJPQL(percent);
	}

	@Override
	public void increasePriceByGivenPercentOfListedIngredientsNJPQL(Integer percent,
			List<BasicIngredient> ingredients) {
		ingredientsDao.increasePriceByGivenPercentOfListedIngredientsNJPQL(percent, ingredients);
	}

}
