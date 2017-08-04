package app.models;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class SaleBasicDto {
	
	@Expose
	private String carMake;

	@Expose
	private String carModel;

	@Expose
	private BigDecimal discount;

	public SaleBasicDto() {
		super();
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
}
