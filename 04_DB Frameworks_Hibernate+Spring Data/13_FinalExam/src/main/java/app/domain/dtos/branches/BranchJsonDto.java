package app.domain.dtos.branches;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class BranchJsonDto implements Serializable {

	@Expose
	private String name;

	@Expose
	private String town;

	public BranchJsonDto() {
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
