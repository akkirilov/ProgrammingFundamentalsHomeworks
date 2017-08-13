package app.services.api;

import java.util.List;

import app.domain.dtos.branches.BranchJsonDto;
import app.domain.dtos.branches.BranchXmlDto;
import app.domain.entities.Branch;

public interface BranchService {

	void save(Branch branch);
	
	void save(List<Branch> branches);
	
	List<Branch> findAll();
	
	Branch findOneById(Long id);
	
	Long count();

	void saveFromDto(List<BranchJsonDto> dtos);

	Branch findOneByName(String name);

	List<BranchXmlDto> findAllTownsWithClients();
	
}
