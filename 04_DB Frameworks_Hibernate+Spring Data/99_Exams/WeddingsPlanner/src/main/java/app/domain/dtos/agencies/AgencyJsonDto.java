package app.domain.dtos.agencies;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class AgencyJsonDto implements Serializable {

	@Expose
	private String name;
	
	@Expose
	@SerializedName(value="count")
	private Integer employeesCount;
	
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
		return employeesCount;
	}

	public void setCapacity(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Integer getEmployeesCount() {
		return employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}
	
}
