package app.services.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.domain.dtos.presents.*;
import app.domain.entities.Present;

public interface PresentService {
	
	void save(Present entity);
	
	Present saveAndGet(Present entity);
	
	List<Present> findAll();
	
	Present findOneById(Long id);
	
	void createFromPresentXmlDto(List<PresentXmlDto> entities);
	
	Long count();
}
