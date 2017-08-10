package app.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.entities.Lens;
import app.repositories.LensRepository;
import app.services.api.LensService;
import app.utils.*;

@Service
public class LensServiceImpl implements LensService {
	
	private LensRepository lensRepository;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public LensServiceImpl(LensRepository lensRepository, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		super();
		this.lensRepository = lensRepository;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void save(Lens entity) {
		try {
			lensRepository.save(entity);
			System.out.println("Successfully imported "
					+ entity.getMake() + " "
					+ entity.getFocalLength() + "mm f"
					+ entity.getMaxAperture());			
		} catch (Exception e) {
			System.out.println("Error. Invalid data provided");		
		}
	}
	
	@Override
	public void save(List<Lens> entities) {
		for (Lens lens : entities) {
			this.save(lens);			
		}
	}

	@Override
	public List<Lens> findAll() {
		return lensRepository.findAll();
	}

	@Override
	public Lens findOneById(Long id) {
		return lensRepository.findOne(id);
	}

	@Override
	public Long count() {
		return lensRepository.count();
	}

	@Override
	public Set<Lens> findAllByIdInList(Set<Long> ids) {
		return lensRepository.findAllByIdIn(ids);
	}

}
