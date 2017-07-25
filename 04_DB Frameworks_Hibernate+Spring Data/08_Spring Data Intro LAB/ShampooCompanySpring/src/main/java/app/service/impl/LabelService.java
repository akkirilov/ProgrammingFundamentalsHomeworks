package app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.api.LabelDao;
import app.model.ClassicLabel;

@Service
@Transactional
public class LabelService {

	@Autowired
	private LabelDao dao;
	
	public List<ClassicLabel> findAllClassicLabels() {
		return dao.findAll();
	}
	
	public ClassicLabel findClassicLabelById(Long id) {
		return dao.findOne(id);
	}
	
	public ClassicLabel findClassicLabelByTitle(String title) {
		return dao.findOneByTitle(title);
	}
	
	public boolean isClassicLabelExist(ClassicLabel classicLabel) {
		return dao.exists(classicLabel.getId());
	}
	
	public void save (ClassicLabel classicLabel) {
		dao.saveAndFlush(classicLabel);
	}
}
