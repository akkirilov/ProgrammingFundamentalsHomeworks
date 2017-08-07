package app.models.sales;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import app.entities.Part;
import app.models.cars.CarBasicAttributeDto;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SaleWithDiscountDto {
	
	@Expose
	private CarBasicAttributeDto car;

	@Expose
	private String customerName;

	@Expose
    private BigDecimal discount;

	@Expose
    private BigDecimal price;

	@Expose
    private BigDecimal priceWithDiscount;

	public SaleWithDiscountDto() {
		super();
	}

	@XmlElement(name = "car")
	public CarBasicAttributeDto getCar() {
		return car;
	}

	public void setCar(CarBasicAttributeDto car) {
		this.car = car;
	}

	@XmlElement(name = "customer-name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@XmlElement(name = "discount")
	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@XmlElement(name = "price")
	public BigDecimal getPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Part p : car.getParts()) {
			sum = sum.add(p.getPrice());
		}
		return sum;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@XmlElement(name = "price-with-discount")
	public BigDecimal getPriceWithDiscount() {
		BigDecimal sum = this.getPrice();
		return sum.subtract(sum.multiply(this.getDiscount().multiply(new BigDecimal("0.01"))));
	}

	public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
	}

}
