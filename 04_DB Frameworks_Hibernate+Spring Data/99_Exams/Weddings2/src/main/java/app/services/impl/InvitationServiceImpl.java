package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Invitation;
import app.repositories.InvitationRepository;
import app.services.api.InvitationService;
import app.utils.*;

@Service
public class InvitationServiceImpl implements InvitationService {
	
	private InvitationRepository repository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public InvitationServiceImpl(InvitationRepository repository, 
							JsonParser jsonParser,
							XmlParser xmlParser,
						 Mapper mapper) {
		super();
		this.repository = repository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
		this.mapper = mapper;
	}

	@Override
	public void save(Invitation entity) {
		repository.save(entity);		
	}
	
	@Override
	public void save(List<Invitation> entities) {
		for (Invitation e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Invitation> findAll() {
		return repository.findAll();
	}

	@Override
	public Invitation findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

}
