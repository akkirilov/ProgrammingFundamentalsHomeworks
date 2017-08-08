package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Lens;
import app.repositories.LensRepository;
import app.services.api.LensService;

@Service
public class LensServiceImpl implements LensService {

	private LensRepository lensRepository;

	@Autowired
	public LensServiceImpl(LensRepository lensRepository) {
		super();
		this.lensRepository = lensRepository;
	}

	@Override
	public void create(Lens lens) {
		try {
			lensRepository.save(lens);
			System.out.println("Successfully imported " 
			+ lens.getMake() + " " + lens.getFocalLength() + "mm"
			+ " f" + lens.getMaxAperture());
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");
		}
	}

	@Override
	public void create(List<Lens> lenses) {
		for (Lens lens : lenses) {
			this.create(lens);
		}
	}
}
