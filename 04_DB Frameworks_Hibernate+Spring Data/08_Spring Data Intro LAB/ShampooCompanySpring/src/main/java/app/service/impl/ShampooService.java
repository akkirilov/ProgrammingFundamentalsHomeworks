package app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.ShampooDao;
import app.model.BasicIngredient;
import app.model.BasicShampoo;

@Service
@Transactional
public class ShampooService {

	@Autowired
	private ShampooDao dao;
	
	public List<BasicShampoo> findAllShampoos() {
		return dao.findAll();
	}
	
	public BasicShampoo findShampooById(Long id) {
		return dao.findOne(id);
	}
	
	public boolean isShampooExist(BasicShampoo basicShampoo) {
		return dao.exists(basicShampoo.getId());
	}
	
	public List<BasicShampoo> findAllShampoosContainsbasicIngredient(BasicIngredient basicIngredient) {
		return dao.findAllByIngredientsId(basicIngredient.getId());
	}
	
	public void save (BasicShampoo basicShampoo) {
		dao.saveAndFlush(basicShampoo);
	}
	
}
