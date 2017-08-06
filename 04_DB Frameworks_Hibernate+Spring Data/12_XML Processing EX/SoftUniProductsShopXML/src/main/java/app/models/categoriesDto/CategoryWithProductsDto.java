package app.models.categoriesDto;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;

import app.models.productsDto.ProductDto;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"name", "productsCount", "averagePrice", "totalRevenue"})
public class CategoryWithProductsDto {
	
	@Expose
	private String name;
	
	private Set<ProductDto>products;
	
	@Expose
	private Integer productsCount;
	
	@Expose
	private BigDecimal averagePrice;
	
	@Expose
	private BigDecimal totalRevenue;

	public CategoryWithProductsDto() {
		super();
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "products-count")
	public Integer getProductsCount() {
		return countProducts();
	}
	
	public void setProductsCount(Integer productsCount) {
		this.productsCount = productsCount;
	}

	@XmlTransient
	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}


	@XmlElement(name = "average-price")
	public BigDecimal getAveragePrice() {
		return countAvaragePrice();
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}
	
	@XmlElement(name = "total-revenue")
	public BigDecimal getTotalRevenue() {
		return countTotalSum();
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
	private Integer countProducts() {
		return this.products.size();
	}
	
	private BigDecimal countTotalSum() {
		BigDecimal temp = BigDecimal.ZERO;
		for (ProductDto product : products) {
			temp = temp.add(product.getPrice());
		}
		return temp;
	}
	
	private BigDecimal countAvaragePrice() {
		return countTotalSum().divide(BigDecimal.valueOf(countProducts()), 2);
	}

}
