package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.employeeCards.EmployeeCardJsonDto;
import app.domain.entities.EmployeeCard;
import app.repositories.EmployeeCardRepository;
import app.services.api.EmployeeCardService;
import app.utils.*;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
	
	private EmployeeCardRepository repository;

	private Mapper mapper;
	
	@Autowired
	public EmployeeCardServiceImpl(EmployeeCardRepository repository, Mapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public void save(EmployeeCard employeeCard) {
		try {
			repository.save(employeeCard);
			System.out.println("Successfully imported "
					+ "Employee Card "
					+ employeeCard.getNumber() + ".");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data.");		
		}
	}
	
	@Override
	public void save(List<EmployeeCard> employeeCards) {
		for (EmployeeCard e : employeeCards) {
			this.save(e);			
		}
	}
	
	@Override
	public List<EmployeeCard> findAll() {
		return repository.findAll();
	}

	@Override
	public EmployeeCard findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(List<EmployeeCardJsonDto> dtos) {
		for (EmployeeCardJsonDto dto : dtos) {
			this.save(mapper.mapOne(dto, EmployeeCard.class));
		}
	}

	@Override
	public EmployeeCard findOneByNumber(String number) {
		return repository.findFirstByNumber(number);
	}

	@Override
	public List<EmployeeCard> findFreeCards() {
		return repository.findAllByEmployeeIsNullOrderByIdAsc();
	}

}
