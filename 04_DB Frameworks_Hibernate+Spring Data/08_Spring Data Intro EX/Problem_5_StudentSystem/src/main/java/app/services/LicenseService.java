package app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.License;
import app.repository.LicenseRepository;

@Service
@Transactional
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	public void saveAndFlush(License license) {
		licenseRepository.saveAndFlush(license);
	}
	
	public void save(License license) {
		licenseRepository.save(license);
	}
	
	public void save(List<License> licenses) {
		licenseRepository.save(licenses);
	}
	
	public License findOneById(Long id) {
		return licenseRepository.findOne(id);
	}
	
	public License findOneByName(String name) {
		return licenseRepository.findByName(name);
	}
	
	public List<License> findAll() {
		return licenseRepository.findAll();
	}
	
	public boolean isExist(License license) {
		return licenseRepository.exists(license.getId());
	}
	
}
