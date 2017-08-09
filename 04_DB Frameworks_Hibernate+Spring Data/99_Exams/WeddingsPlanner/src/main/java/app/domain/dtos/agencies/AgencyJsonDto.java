package app.domain.dtos.agencies;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class AgencyJsonDto implements Serializable {

	@Expose
	private String name;
	
	@Expose
	private Integer employeeCount;
	
	@Expose
	private String town;

	public AgencyJsonDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return employeeCount;
	}

	public void setCapacity(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
}
