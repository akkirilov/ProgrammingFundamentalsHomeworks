package app.services.api;

import java.util.List;

import app.domain.dtos.persons.PersonDto;
import app.domain.entities.Person;

public interface PersonService {

	void save(Person entity);
	
	void save(List<Person> entity);
	
	List<Person> findAll();
	
	Person findOneById(Long id);
	
	Long count();

	void saveFromDto(List<PersonDto> dtos);

	Person findByFullName(String fullName);
	
}
