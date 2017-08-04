package app.models.bindingModels;

import java.io.Serializable;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class SoldProductsInfoDto implements Serializable {

	private static final long serialVersionUID = 4001258959809642391L;

	@Expose
	private Integer count;
	
	@Expose
	private Set<ProductSoldBasicJsonDto> products;

	public SoldProductsInfoDto() {
		super();
	}

	public SoldProductsInfoDto(Integer count, Set<ProductSoldBasicJsonDto> soldProducts) {
		super();
		this.count = count;
		this.products = soldProducts;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set<ProductSoldBasicJsonDto> getSoldProducts() {
		return products;
	}

	public void setSoldProducts(Set<ProductSoldBasicJsonDto> soldProducts) {
		this.products = soldProducts;
	}
	
}
