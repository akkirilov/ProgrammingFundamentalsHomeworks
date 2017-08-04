package app.models;

import com.google.gson.annotations.Expose;

public class SupplierBasicDto {

	@Expose
	private String name;
	
	@Expose
	private Boolean isImporter;

	public SupplierBasicDto() {
		super();
	}

	public SupplierBasicDto(String name, Boolean isImporter) {
		super();
		this.name = name;
		this.isImporter = isImporter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsImporter() {
		return isImporter;
	}

	public void setIsImporter(Boolean isImporter) {
		this.isImporter = isImporter;
	}
	
}
