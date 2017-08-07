package app.models.productsDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "product")
public class SoldProductDto implements Serializable {

	private static final long serialVersionUID = 3067905211526181304L;

	@Expose
	private Integer count;
	
	@Expose
	@SerializedName(value = "products")
	private List<ProductAttributeDto> soldProducts;

	public SoldProductDto() {
		super();
		soldProducts = new ArrayList<>();
	}

	@XmlAttribute(name = "count")
	public Integer getCount() {
		return soldProducts.size();
	}

	public void setCount(Integer count) {
		this.count = count;
	}


	@XmlElement(name = "soldProducts")
	public List<ProductAttributeDto> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(List<ProductAttributeDto> soldProducts) {
		this.soldProducts = soldProducts;
	}

}
