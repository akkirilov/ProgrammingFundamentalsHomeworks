package app.models.bindingModels;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductSoldBasicJsonDto implements Serializable{

	private static final long serialVersionUID = 391072014694815301L;

	@Expose
	private String name;
	
	@Expose
	private BigDecimal price;

	public ProductSoldBasicJsonDto() {
		super();
	}

	public ProductSoldBasicJsonDto(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
