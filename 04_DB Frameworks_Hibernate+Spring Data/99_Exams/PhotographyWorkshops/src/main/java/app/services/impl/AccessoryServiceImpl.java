package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Accessory;
import app.repositories.AccessoryRepository;
import app.services.api.AccessoryService;

@Service
public class AccessoryServiceImpl implements AccessoryService {

	private AccessoryRepository accessoryRepository;

	@Autowired
	public AccessoryServiceImpl(AccessoryRepository accessoryRepository) {
		super();
		this.accessoryRepository = accessoryRepository;
	}

	@Override
	public void create(Accessory accessory) {
		try {
			accessoryRepository.save(accessory);
			System.out.println("Successfully imported " 
			+ accessory.getName());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public void create(List<Accessory> accessories) {
		for (Accessory accessory : accessories) {
			this.create(accessory);
		}
	}
}
