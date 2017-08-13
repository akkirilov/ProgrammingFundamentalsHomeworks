package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.products.ProductWrapperXmlDto;
import app.domain.dtos.products.ProductXmlDto;
import app.domain.entities.Product;
import app.repositories.ProductRepository;
import app.services.api.BranchService;
import app.services.api.ProductService;
import app.utils.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository repository;
	private BranchService branchService;
	
	private Mapper mapper;
	
	@Autowired
	public ProductServiceImpl(ProductRepository repository,
							BranchService branchService,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.branchService = branchService;
		this.mapper = mapper;
	}

	@Override
	public void save(Product product) {
		try {
			repository.save(product);
			System.out.println("Successfully imported "
					+ product.getClass().getSimpleName() + " "
					+ product.getName() + ".");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data.");		
		}
	}
	
	@Override
	public void save(List<Product> products) {
		for (Product p : products) {
			this.save(p);			
		}
	}
	
	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(ProductWrapperXmlDto wrapperXmlDto) {
		for (ProductXmlDto dto : wrapperXmlDto.getProductXmlDtos()) {
			Product temp = mapper.mapOne(dto, Product.class);
			temp.setBranch(branchService.findOneByName(dto.getBranch()));
			this.save(temp);
		}
		
	}

}
