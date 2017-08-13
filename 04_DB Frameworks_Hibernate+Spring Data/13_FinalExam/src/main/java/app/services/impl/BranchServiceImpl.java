package app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.branches.BranchJsonDto;
import app.domain.dtos.branches.BranchXmlDto;
import app.domain.entities.Branch;
import app.domain.entities.Product;
import app.repositories.BranchRepository;
import app.services.api.BranchService;
import app.services.api.TownService;
import app.utils.*;

@Service
public class BranchServiceImpl implements BranchService {
	
	private BranchRepository repository;
	private TownService townService;

	private Mapper mapper;
	
	@Autowired
	public BranchServiceImpl(BranchRepository repository,
							TownService townService,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.townService = townService;
		this.mapper = mapper;
	}

	@Override
	public void save(Branch branch) {
		try {
			repository.save(branch);
			System.out.println("Successfully imported "
					+ branch.getClass().getSimpleName() + " "
					+ branch.getName() + ".");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data.");		
		}
	}
	
	@Override
	public void save(List<Branch> branches) {
		for (Branch e : branches) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Branch> findAll() {
		return repository.findAll();
	}

	@Override
	public Branch findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(List<BranchJsonDto> dtos) {
		for (BranchJsonDto dto : dtos) {
			Branch temp = mapper.mapOne(dto, Branch.class);
			temp.setTown(townService.findOneByName(dto.getTown()));
			this.save(temp);
		}
	}

	@Override
	public Branch findOneByName(String name) {
		return repository.findFirstByName(name);
	}

	@Override
	public List<BranchXmlDto> findAllTownsWithClients() {
		List<BranchXmlDto> dtos = new ArrayList<>();
		List<Branch> branches = repository.findAllOrderedByTotalClients();
		for (Branch b : branches) {
			BranchXmlDto temp = mapper.mapOne(b, BranchXmlDto.class);
			
			Long totalClients = 0L;
			for (Product p : b.getProducts()) {
				totalClients += p.getClients();
			}
			
			temp.setTotalClients(totalClients);
			dtos.add(temp);
		}

		return dtos;
	}

}
