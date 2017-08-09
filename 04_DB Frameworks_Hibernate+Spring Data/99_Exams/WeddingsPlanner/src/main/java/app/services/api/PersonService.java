package app.services.api;

import java.util.List;

import app.domain.dtos.persons.GuestsListJsonDto;
import app.domain.dtos.persons.PeopleJsonDto;
import app.domain.entities.Person;

public interface PersonService {

	void save(Person entity);
	
	List<Person> findAll();
	
	Person findOneById(Long id);
	
	Long count();

	void createFromPeopleJsonDto(List<PeopleJsonDto> peopleJsonDtos);
	
	Person findByFullName(String fullName);
	
	
}
