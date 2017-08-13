package app.domain.dtos.employeeCards;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class EmployeeCardJsonDto implements Serializable {

	@Expose
	private String number;

	public EmployeeCardJsonDto() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
