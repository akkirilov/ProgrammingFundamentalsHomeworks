package app.models.bindingModels;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class CategoryInfo {

	@Expose
	private String category;
	
	@Expose
	private Integer productsCount;
	
	@Expose
	private BigDecimal averagePrice;
    
	@Expose
	private BigDecimal totalRevenue;

	public CategoryInfo() {
		super();
	}

	public CategoryInfo(String category, Integer productsCount, BigDecimal averagePrice, BigDecimal totalRevenue) {
		super();
		this.category = category;
		this.productsCount = productsCount;
		this.averagePrice = averagePrice;
		this.totalRevenue = totalRevenue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(Integer productsCount) {
		this.productsCount = productsCount;
	}

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
}
