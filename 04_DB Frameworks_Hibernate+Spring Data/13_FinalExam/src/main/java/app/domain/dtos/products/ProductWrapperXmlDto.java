package app.domain.dtos.products;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWrapperXmlDto implements Serializable {

	@XmlElement(name = "product")
	private List<ProductXmlDto> productXmlDtos;

	public ProductWrapperXmlDto() {
		super();
	}

	public List<ProductXmlDto> getProductXmlDtos() {
		return productXmlDtos;
	}

	public void setProductXmlDtos(List<ProductXmlDto> productXmlDtos) {
		this.productXmlDtos = productXmlDtos;
	}
	
}
