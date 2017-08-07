package app.models.sales;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDto {

	@XmlElement(name = "sale")
	private List<SaleWithDiscountDto> saleWithDiscountDtos;

	public SalesDto() {
		super();
	}

	public List<SaleWithDiscountDto> getSaleWithDiscountDtos() {
		return saleWithDiscountDtos;
	}

	public void setSaleWithDiscountDtos(List<SaleWithDiscountDto> saleWithDiscountDtos) {
		this.saleWithDiscountDtos = saleWithDiscountDtos;
	}
		
}
