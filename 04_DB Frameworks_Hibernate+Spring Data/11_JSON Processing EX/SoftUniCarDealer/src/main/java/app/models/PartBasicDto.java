package app.models;

import java.math.BigDecimal;


import com.google.gson.annotations.Expose;

public class PartBasicDto {

	@Expose
	private String name;
	
	@Expose
	private BigDecimal price;
	
	@Expose
	private Integer quantity;

	public PartBasicDto() {
		super();
	}

	public PartBasicDto(String name, BigDecimal price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
