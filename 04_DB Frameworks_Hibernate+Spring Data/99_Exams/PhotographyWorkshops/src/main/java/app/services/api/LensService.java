package app.services.api;

import java.util.List;

import app.domain.entities.Lens;

public interface LensService {
	
	void create(Lens lens);

	void create(List<Lens> lenses);
	
}
