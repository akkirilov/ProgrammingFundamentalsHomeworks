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
	private Mapper mapper;
	
	@Autowired
	public EntServiceImpl(EntRepository entRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser,
						 Mapper mapper) {
		super();
		this.entRepository = entRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Ent entity) {
		try {
			entRepository.save(entity);
			System.out.println("Successfully imported ");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void save(List<Ent> entities) {
		for (Ent e : entities) {
			this.save(e);			
		}
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
