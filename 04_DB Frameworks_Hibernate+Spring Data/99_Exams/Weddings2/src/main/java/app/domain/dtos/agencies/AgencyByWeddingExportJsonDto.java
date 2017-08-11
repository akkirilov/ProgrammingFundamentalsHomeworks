package app.domain.dtos.agencies;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgencyByWeddingExportJsonDto implements Serializable {
	
	@Expose
	private String name;

	@Expose
	private String town;

	public AgencyByWeddingExportJsonDto() {
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
