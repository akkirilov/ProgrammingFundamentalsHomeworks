package app.services.api;

import java.util.List;

import app.domain.entities.Invitation;

public interface InvitationService {

	void save(Invitation entity);
	
	void save(List<Invitation> entity);
	
	List<Invitation> findAll();
	
	Invitation findOneById(Long id);
	
	Long count();
	
}
