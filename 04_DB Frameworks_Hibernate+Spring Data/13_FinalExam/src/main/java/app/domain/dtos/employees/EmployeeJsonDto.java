package app.domain.dtos.employees;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeJsonDto implements Serializable {
	
	@Expose
	@SerializedName(value = "full_name")
	private String fullName;

	@Expose
	private String position;

	@Expose
	@SerializedName(value = "number")
	private String employeeCardNumber;

	public EmployeeJsonDto() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmployeeCardNumber() {
		return employeeCardNumber;
	}

	public void setEmployeeCardNumber(String employeeCardNumber) {
		this.employeeCardNumber = employeeCardNumber;
	}
	
}
