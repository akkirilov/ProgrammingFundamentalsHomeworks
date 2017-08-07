package app.models.customers;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;

import app.entities.Part;
import app.entities.Sale;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"name", "boughtCars", "spentMoney"})
public class CustomerStatisticDto {
	
	@Expose
	private String name;
	
	@Expose
	private Integer boughtCars;
	
	@Expose
	private BigDecimal spentMoney;
	
	private Set<Sale> sales;

	public CustomerStatisticDto() {
		super();
	}

	@XmlAttribute(name = "full-name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "bought-cars")
	public Integer getBoughtCars() {
		if (this.sales == null) {
			return 0;
		}
		return this.sales.size();
	}

	public void setBoughtCars(Integer boughtCars) {
		this.boughtCars = boughtCars;
	}

	@XmlAttribute(name = "spent-money")
	public BigDecimal getSpentMoney() {
		BigDecimal total = BigDecimal.ZERO;
		for (Sale sale : sales) {
			for (Part part : sale.getCar().getParts()) {
				total = total.add(part.getPrice());
			}
		}
		return total;
	}

	public void setSpentMoney(BigDecimal spentMoney) {
		this.spentMoney = spentMoney;
	}

	@XmlTransient
	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

}
