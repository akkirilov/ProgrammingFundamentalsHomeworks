package app.models.bindingModels;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductJsonInDto implements Serializable {

	private static final long serialVersionUID = -8236654919154788024L;

	@Expose
	private String name;
	
	@Expose
	private BigDecimal price;

	public ProductJsonInDto() {
		super();
	}

	public ProductJsonInDto(String name, BigDecimal price) {
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
