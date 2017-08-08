package app.services.api;

import java.util.List;

import app.domain.entities.Accessory;

public interface AccessoryService {
	
	void create(Accessory accessory);

	void create(List<Accessory> accessories);
	
}
