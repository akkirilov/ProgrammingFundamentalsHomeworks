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
	
	private InvitationRepository invitationRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public InvitationServiceImpl(InvitationRepository invitationRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.invitationRepository = invitationRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Invitation entity) {
		try {
			invitationRepository.save(entity);
		} catch (Exception e) {
		}
	}

	@Override
	public List<Invitation> findAll() {
		return invitationRepository.findAll();
	}

	@Override
	public Invitation findOneById(Long id) {
		return invitationRepository.findOne(id);
	}

	@Override
	public Long count() {
		return invitationRepository.count();
	}

	@Override
	public Invitation saveAndGet(Invitation entity) {
		Invitation toReturn = null;
		try {
			toReturn = invitationRepository.save(entity);
		} catch (Exception e) {
		}
		return toReturn;
	}


}
