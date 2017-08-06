package app.models.productsDto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsDto {

	@XmlElement(name = "product")
	List<ProductDto> productDtos;
	
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
