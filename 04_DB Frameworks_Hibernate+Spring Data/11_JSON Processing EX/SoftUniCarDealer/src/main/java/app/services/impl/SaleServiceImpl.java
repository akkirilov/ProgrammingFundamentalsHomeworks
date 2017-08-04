package app.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Sale;
import app.repositories.SaleRepository;
import app.services.api.SaleService;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

	private SaleRepository repository;
	
	@Autowired
	public SaleServiceImpl(SaleRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public void save(Sale entity) {
		repository.save(entity);
	}

	@Override
	public void save(List<Sale> entities) {
		repository.save(entities);
	}

	@Override
	public List<Sale> findAll() {
		return repository.findAll();
	}

	@Override
	public Sale findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Sale> findAllWithAppliedDiscount() {
		return repository.findAllByDiscountGreaterThan(new BigDecimal("0"));
	}

}
