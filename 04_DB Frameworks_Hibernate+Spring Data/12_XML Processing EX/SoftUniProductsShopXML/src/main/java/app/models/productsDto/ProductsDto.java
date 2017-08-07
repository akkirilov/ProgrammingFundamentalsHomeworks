package app.models.productsDto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsDto {

	@Expose
	@XmlElement(name = "product")
	List<ProductDto> productDtos;
	
	@Expose
	@SerializedName(value = "products")
	@XmlElement(name = "product")
	List<ProductWithSellerDto> productWithSellerDtos;

	public ProductsDto() {
		super();
	}

	public List<ProductDto> getProductDtos() {
		return productDtos;
	}

	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}

	public List<ProductWithSellerDto> getProductWithSellerDtos() {
		return productWithSellerDtos;
	}

	public void setProductWithSellerDtos(List<ProductWithSellerDto> productWithSellerDtos) {
		this.productWithSellerDtos = productWithSellerDtos;
	}
	
}
