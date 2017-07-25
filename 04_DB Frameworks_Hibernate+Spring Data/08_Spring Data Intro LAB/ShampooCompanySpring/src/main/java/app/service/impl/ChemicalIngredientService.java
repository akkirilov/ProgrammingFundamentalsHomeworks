package app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.ChemicalIngredientDao;
import app.model.BasicChemicalIngredient;

@Service
@Transactional
public class ChemicalIngredientService {

	@Autowired
	private ChemicalIngredientDao dao;
	
	public List<BasicChemicalIngredient> findAllChemicalIngredients() {
		return dao.findAll();
	}
	
	public BasicChemicalIngredient findChemicalIngredientById(Long id) {
		return dao.findOne(id);
	}
	
	public BasicChemicalIngredient findChemicalIngredientByName(String name) {
		return dao.findOneByName(name);
	}
	
	public boolean isChemicalIngredientExist(BasicChemicalIngredient chemicalIngredient) {
		return dao.exists(chemicalIngredient.getId());
	}
	
	public void save (BasicChemicalIngredient chemicalIngredient) {
		dao.saveAndFlush(chemicalIngredient);
	}
	
}
