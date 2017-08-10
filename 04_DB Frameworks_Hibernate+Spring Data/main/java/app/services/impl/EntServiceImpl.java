package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.domain.entities.Ent;
import app.repositories.EntRepository;
import app.services.api.EntService;
import app.utils.*;


public class EntServiceImpl implements EntService {
	
	private EntRepository entRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public EntServiceImpl(EntRepository entRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.entRepository = entRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public Ent save(Ent entity) {
		return entRepository.save(entity);
	}

	@Override
	public List<Ent> findAll() {
		return entRepository.findAll();
	}

	@Override
	public Ent findOneById(Long id) {
		return entRepository.findOne(id);
	}

	@Override
	public Long count() {
		return entRepository.count();
	}

}
