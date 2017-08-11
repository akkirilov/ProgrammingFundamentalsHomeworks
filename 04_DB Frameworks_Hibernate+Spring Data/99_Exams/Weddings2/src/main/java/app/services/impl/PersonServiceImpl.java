package app.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.persons.PersonDto;
import app.domain.entities.Person;
import app.repositories.PersonRepository;
import app.services.api.PersonService;
import app.utils.*;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository repository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	private Mapper mapper;
	
	@Autowired
	public PersonServiceImpl(PersonRepository repository, 
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
	public void save(Person entity) {
		try {
			repository.save(entity);
			System.out.println("Successfully imported "
						+ entity.getFullName());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void save(List<Person> entities) {
		for (Person e : entities) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(List<PersonDto> dtos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		for (PersonDto dto : dtos) {
			Person temp = mapper.mapOne(dto, Person.class);
			if (dto.getDateString() == null) {
				this.save(temp);
				continue;
			}
			try {
				temp.setBirthDate(sdf.parse(dto.getDateString()));
			} catch (ParseException e) {
				System.out.println("Cant parse " + dto.getDateString() + " to java.util.Date");
			}
			this.save(temp);			
		}
	}

	@Override
	public Person findByFullName(String fullName) {
		return repository.findByFullName(fullName);
	}

}
