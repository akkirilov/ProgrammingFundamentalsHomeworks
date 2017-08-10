package app.services.api;

import java.util.List;

import app.domain.dtos.invitations.InvitationJsonDto;
import app.domain.dtos.persons.GuestsListJsonDto;
import app.domain.entities.Invitation;

public interface InvitationService {

	void save(Invitation entity);
	
	Invitation saveAndGet(Invitation entity);
	
	List<Invitation> findAll();
	
	Invitation findOneById(Long id);
	
	Long count();

	List<GuestsListJsonDto> findAllGuestsListJsonDto();
		
}
