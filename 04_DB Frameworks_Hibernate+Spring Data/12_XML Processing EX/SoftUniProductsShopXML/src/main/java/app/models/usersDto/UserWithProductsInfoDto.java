package app.models.usersDto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.models.productsDto.ProductAttributeDto;
import app.models.productsDto.SoldProductDto;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProductsInfoDto implements Serializable{

	private static final long serialVersionUID = -6816244753026670213L;

	@Expose
	@XmlAttribute(name = "first-name")
	private String firstName;
	
	@Expose
	@XmlAttribute(name = "last-name")
	private String lastName;
	
	@Expose
	@XmlAttribute(name = "age")
	private Integer age;
	
	@XmlTransient
	private List<ProductAttributeDto> soldProducts;
	
	@Expose
	@SerializedName(value = "soldProducts")
	@XmlElement(name = "sold-products")
	private SoldProductDto productAttributeDto;
	
	public UserWithProductsInfoDto() {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<ProductAttributeDto> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(List<ProductAttributeDto> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public SoldProductDto getProductAttributeDto() {
		return productAttributeDto;
	}

	public void setProductAttributeDto(SoldProductDto productAttributeDto) {
		this.productAttributeDto = productAttributeDto;
	}
	
}
