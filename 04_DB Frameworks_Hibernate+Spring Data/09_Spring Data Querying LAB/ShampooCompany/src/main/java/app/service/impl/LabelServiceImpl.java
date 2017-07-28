package app.service.impl;

import app.dao.api.ClassicLabelDao;
import app.model.ClassicLabel;
import app.service.api.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LabelServiceImpl implements LabelService<ClassicLabel, Long> {

    @Autowired
    private ClassicLabelDao dao;

    @Override
    public ClassicLabel findById(Long id) {
        return dao.findOne(id);
    }    

	@Override
	public void remove(ClassicLabel object) {
		dao.delete(object);
	}

	@Override
	public void save(ClassicLabel object) {
		dao.save(object);
	}

	@Override
	public List<ClassicLabel> findAll(Class<ClassicLabel> objects) {
		return dao.findAll();
	}
	
}
