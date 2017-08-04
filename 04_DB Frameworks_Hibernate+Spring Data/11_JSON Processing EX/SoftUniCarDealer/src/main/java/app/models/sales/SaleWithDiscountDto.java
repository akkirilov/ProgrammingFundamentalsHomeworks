package app.models.sales;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

import app.models.CarBasicDto;

public class SaleWithDiscountDto {
	
	@Expose
	private CarBasicDto car;

	@Expose
	private String customerName;

	@Expose
    private String discount;

	@Expose
    private BigDecimal price;

	@Expose
    private BigDecimal priceWithDiscount;

	public SaleWithDiscountDto() {
		super();
	}

	public CarBasicDto getCar() {
		return car;
	}

	public void setCar(CarBasicDto car) {
		this.car = car;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceWithDiscount() {
		return priceWithDiscount;
	}

	public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
	}

}
