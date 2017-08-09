package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.persons.PeopleJsonDto;
import app.domain.entities.Agency;
import app.domain.entities.Person;
import app.repositories.PersonRepository;
import app.services.api.PersonService;
import app.utils.*;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.personRepository = personRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Person entity) {
		try {
			personRepository.save(entity);
			System.out.println("Successfully imported " 
					+ entity.getFirstName() + " "
					+ entity.getMiddleName() + " "
					+ entity.getLastName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findOneById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Long count() {
		return personRepository.count();
	}

	@Override
	public void createFromPeopleJsonDto(List<PeopleJsonDto> entities) {
		List<Person> persons = Mapper.mapToList(entities, Person.class);
		for (Person person : persons) {
			this.save(person);
		}
	}

	@Override
	public Person findByFullName(String fullName) {
		return personRepository.findByFullName(fullName);
	}

}
