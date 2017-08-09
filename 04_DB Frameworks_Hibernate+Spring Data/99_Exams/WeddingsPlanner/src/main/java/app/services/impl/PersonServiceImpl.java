package app.services.impl;

import static org.mockito.Matchers.contains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.persons.GuestsListJsonDto;
import app.domain.dtos.persons.PeopleJsonDto;
import app.domain.entities.Agency;
import app.domain.entities.Person;
import app.repositories.PersonRepository;
import app.services.api.PersonService;
import app.services.api.WeddingService;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		entities = Mapper.mapToList(entities, PeopleJsonDto.class);
		for (PeopleJsonDto peopleJsonDto : entities) {
			Person temp = Mapper.mapOne(peopleJsonDto, Person.class);
			temp.setMiddleName(peopleJsonDto.getMiddleInitial());
			if (peopleJsonDto.getBirthday() != null) {
				try {
					temp.setBirthDate(sdf.parse(peopleJsonDto.getBirthday()));					
				} catch (ParseException e) {
					System.out.println("ERROR: Can't parse date " + peopleJsonDto.getBirthday());
				}
			}
			this.save(temp);
		}
		
	}

	@Override
	public Person findByFullName(String fullName) {
		return personRepository.findByFullName(fullName);
	}

}
