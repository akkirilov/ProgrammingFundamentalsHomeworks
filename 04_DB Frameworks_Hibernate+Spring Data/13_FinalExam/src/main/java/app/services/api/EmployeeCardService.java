package app.services.api;

import java.util.List;

import app.domain.dtos.employeeCards.EmployeeCardJsonDto;
import app.domain.entities.EmployeeCard;

public interface EmployeeCardService {

	void save(EmployeeCard employeeCard);
	
	void save(List<EmployeeCard> employeeCards);
	
	List<EmployeeCard> findAll();
	
	EmployeeCard findOneById(Long id);
	
	Long count();

	void saveFromDto(List<EmployeeCardJsonDto> dtos);

	EmployeeCard findOneByNumber(String number);

	List<EmployeeCard> findFreeCards();
	
}
