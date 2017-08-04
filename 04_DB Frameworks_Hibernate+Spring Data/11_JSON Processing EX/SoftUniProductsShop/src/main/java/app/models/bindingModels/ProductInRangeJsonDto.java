package app.models.bindingModels;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductInRangeJsonDto implements Serializable {

	private static final long serialVersionUID = 7035595989827521449L;

	@Expose
	private String name;
	
	@Expose
	private BigDecimal price;
	
	@Expose
	private String seller;

	public ProductInRangeJsonDto() {
		super();
	}

	public ProductInRangeJsonDto(String name, BigDecimal price) {
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String sellerName) {
		this.seller = sellerName;
	}
	
}
