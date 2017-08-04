package app.models.bindingModels;

import java.io.Serializable;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class SuccessfullUserJsonDto implements Serializable{

	private static final long serialVersionUID = 1218967462682082087L;

	@Expose
	private String firstName;
	
	@Expose
	private String lastName;
	
	@Expose
	private Set<ProductSoldJsonDto> soldProducts;

	public SuccessfullUserJsonDto() {
		super();
	}

	public SuccessfullUserJsonDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<ProductSoldJsonDto> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(Set<ProductSoldJsonDto> soldProducts) {
		this.soldProducts = soldProducts;
	}
	
}
