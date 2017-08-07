package app.models.customers;

import java.util.Set;

import com.google.gson.annotations.Expose;

import app.models.sales.SaleBasicDto;

public class CustumerWithBasicSaleDto {

	@Expose
	private long id;
	
	@Expose
	private String name;
	
	@Expose
	private String birthDate;
	
	@Expose
	private Boolean isYoungDriver;
	
	@Expose
	private Set<SaleBasicDto> sales;

	public CustumerWithBasicSaleDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsYoungDriver() {
		return isYoungDriver;
	}

	public void setIsYoungDriver(Boolean isYoungDriver) {
		this.isYoungDriver = isYoungDriver;
	}

	public Set<SaleBasicDto> getSales() {
		return sales;
	}

	public void setSales(Set<SaleBasicDto> sales) {
		this.sales = sales;
	}
	
}
