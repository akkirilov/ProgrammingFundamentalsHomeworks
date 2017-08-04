package app.models.suppliers;

import com.google.gson.annotations.Expose;

public class SupplierWithPartsCountDto {

	@Expose
	private long id;
	
	@Expose
	private String name;
	
	@Expose
	private Integer partsCount;

	public SupplierWithPartsCountDto() {
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

	public Integer getPartsCount() {
		return partsCount;
	}

	public void setPartsCount(Integer partsCount) {
		this.partsCount = partsCount;
	}
	
}
