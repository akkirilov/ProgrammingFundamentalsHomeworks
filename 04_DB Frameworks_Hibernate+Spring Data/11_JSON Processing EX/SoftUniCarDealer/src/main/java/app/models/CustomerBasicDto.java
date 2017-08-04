package app.models;

import com.google.gson.annotations.Expose;

public class CustomerBasicDto {

	@Expose
	private String name;
	
	@Expose
	private String birthDate;
	
	@Expose
	private Boolean isYoungDriver;

	public CustomerBasicDto() {
		super();
	}

	public CustomerBasicDto(String name, String birthDate, Boolean isYoungDriver) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.isYoungDriver = isYoungDriver;
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
	
}
