package app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.IngredientDao;
import app.model.BasicIngredient;

@Service
@Transactional
public class BasicIngredientService {

	@Autowired
	private IngredientDao dao;
	
	public List<BasicIngredient> findAllBasicIngredients() {
		return dao.findAll();
	}
	
	public BasicIngredient findBasicIngredientById(Long id) {
		return dao.findOne(id);
	}
	
	public BasicIngredient findBasicIngredientByName(String name) {
		return dao.findOneByName(name);
	}
	
	public boolean isBasicIngredientExist(BasicIngredient basicIngredient) {
		return dao.exists(basicIngredient.getId());
	}
	
	public void save (BasicIngredient basicIngredient) {
		dao.saveAndFlush(basicIngredient);
	}
	
}
