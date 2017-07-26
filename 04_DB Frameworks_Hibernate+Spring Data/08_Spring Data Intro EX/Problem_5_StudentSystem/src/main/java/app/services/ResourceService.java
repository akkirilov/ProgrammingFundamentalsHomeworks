package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Resource;
import app.repository.ResourceRepository;

@Service
@Transactional
public class ResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	public void saveAndFlush(Resource resource) {
		resourceRepository.saveAndFlush(resource);
	}
	
	public void save(Resource resource) {
		resourceRepository.save(resource);
	}
	
	public void save(List<Resource> resources) {
		resourceRepository.save(resources);
	}
	
	public Resource findOneById(Long id) {
		return resourceRepository.findOne(id);
	}
	
	public Resource findOneByName(String name) {
		return resourceRepository.findByName(name);
	}
	
	public List<Resource> findAll() {
		return resourceRepository.findAll();
	}
	
	public boolean isExist(Resource resource) {
		return resourceRepository.exists(resource.getId());
	}
	
	public List<Resource> findAllWithoutLicenses() {
		return resourceRepository.findByLicensesIsNull();
	}
	
}
