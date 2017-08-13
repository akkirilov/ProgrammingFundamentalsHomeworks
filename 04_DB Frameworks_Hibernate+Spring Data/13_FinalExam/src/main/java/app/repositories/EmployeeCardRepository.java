package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.domain.entities.EmployeeCard;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long>{

	EmployeeCard findFirstByNumber(String number);

	List<EmployeeCard> findAllByEmployeeIsNullOrderByIdAsc();
	
}
