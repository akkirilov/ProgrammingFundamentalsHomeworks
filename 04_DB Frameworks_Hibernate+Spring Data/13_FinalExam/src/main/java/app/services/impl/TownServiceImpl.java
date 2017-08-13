package app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.towns.TownJsonDto;
import app.domain.dtos.towns.TownXmlDto;
import app.domain.entities.Branch;
import app.domain.entities.Product;
import app.domain.entities.Town;
import app.repositories.TownRepository;
import app.services.api.TownService;
import app.utils.*;

@Service
public class TownServiceImpl implements TownService {
	
	private TownRepository repository;
	
	private Mapper mapper;
	
	@Autowired
	public TownServiceImpl(TownRepository repository, 
						 Mapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public void save(Town town) {
		try {
			repository.save(town);
			System.out.println("Successfully imported "
					+ town.getClass().getSimpleName() + " "
					+ town.getName() + ".");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data.");		
		}
	}
	
	@Override
	public void save(List<Town> towns) {
		for (Town t : towns) {
			this.save(t);			
		}
	}
	
	@Override
	public List<Town> findAll() {
		return repository.findAll();
	}

	@Override
	public Town findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(List<TownJsonDto> dtos) {
		for (TownJsonDto dto : dtos) {
			this.save(mapper.mapOne(dto, Town.class));
		}
	}

	@Override
	public Town findOneByName(String name) {
		return repository.findFirstByName(name);
	}

	@Override
	public List<TownXmlDto> findAllTownsWithClients() {
		List<TownXmlDto> dtos = new ArrayList<>();
		List<Town> towns = repository.findAllOrderedByTownClients();
		for (Town t : towns) {
			TownXmlDto temp = mapper.mapOne(t, TownXmlDto.class);
			
			Long totalClients = 0L;
			for (Branch b : t.getBranches()) {
				for (Product p : b.getProducts()) {
					totalClients += p.getClients();
				}
			}
			
			temp.setTownClients(totalClients);
			dtos.add(temp);
		}
		
		return dtos;
	}

}
