package app.models.usersDto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import app.models.productsDto.ProductWithBayerDto;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsDto implements Serializable{

	private static final long serialVersionUID = -6816244753026670213L;

	@Expose
	@XmlAttribute(name = "first-name")
	private String firstName;
	
	@Expose
	@XmlAttribute(name = "last-name")
	private String lastName;
	
	@XmlElementWrapper(name = "sold-products")
	@XmlElement(name = "product")
	private List<ProductWithBayerDto> soldProducts;
	
	public UserWithSoldProductsDto() {
		super();
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

	public List<ProductWithBayerDto> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(List<ProductWithBayerDto> soldProducts) {
		this.soldProducts = soldProducts;
	}
	
}
