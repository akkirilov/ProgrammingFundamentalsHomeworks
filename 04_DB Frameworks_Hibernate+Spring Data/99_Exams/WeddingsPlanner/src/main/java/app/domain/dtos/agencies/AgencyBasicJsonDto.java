package app.domain.dtos.agencies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgencyBasicJsonDto {
	
	@Expose
	private String name;
	
	
	@Expose
	private String town;


	public AgencyBasicJsonDto() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTown() {
		return town;
	}


	public void setTown(String town) {
		this.town = town;
	}
	
}
