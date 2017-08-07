package app.models.customers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersDto {
	
	@XmlElement(name = "customer")
	private List<CustomerBasicDto> basicDtos;
	
	@XmlElement(name = "customer")
	private List<CustumerWithoutSalesDto> custumerWithoutSalesDtos;
	
	@XmlElement(name = "customer")
	private List<CustomerStatisticDto> customerStatisticDtos;

	public CustomersDto() {
		super();
	}

	public List<CustomerBasicDto> getBasicDtos() {
		return basicDtos;
	}

	public void setBasicDtos(List<CustomerBasicDto> basicDtos) {
		this.basicDtos = basicDtos;
	}

	public List<CustumerWithoutSalesDto> getCustumerWithoutSalesDtos() {
		return custumerWithoutSalesDtos;
	}

	public void setCustumerWithoutSalesDtos(List<CustumerWithoutSalesDto> custumerWithoutSalesDtos) {
		this.custumerWithoutSalesDtos = custumerWithoutSalesDtos;
	}

	public List<CustomerStatisticDto> getCustomerStatisticDtos() {
		return customerStatisticDtos;
	}

	public void setCustomerStatisticDtos(List<CustomerStatisticDto> customerStatisticDtos) {
		this.customerStatisticDtos = customerStatisticDtos;
	}

}
