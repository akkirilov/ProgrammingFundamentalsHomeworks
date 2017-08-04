package app.models.bindingModels;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class CategoryJsonInDto implements Serializable{

	private static final long serialVersionUID = -8613308236795671214L;
	
	@Expose
	private String name;

	public CategoryJsonInDto() {
		super();
	}

	public CategoryJsonInDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
