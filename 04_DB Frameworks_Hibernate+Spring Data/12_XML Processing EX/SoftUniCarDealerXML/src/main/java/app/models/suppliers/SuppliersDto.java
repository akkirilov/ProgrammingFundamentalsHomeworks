package app.models.suppliers;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersDto implements Serializable{

	private static final long serialVersionUID = -5279764989115729498L;
	
	@Expose
	@XmlElement(name = "supplier")
	private List<SupplierBasicDto> supplierBasicDtos;
	
	@XmlElement(name = "supplier")
	private List<SupplierWithPartsCountDto> supplierWithPartsCountDtos;

	public SuppliersDto() {
		super();
	}

	public List<SupplierBasicDto> getSupplierBasicDtos() {
		return supplierBasicDtos;
	}

	public void setSupplierBasicDtos(List<SupplierBasicDto> supplierBasicDtos) {
		this.supplierBasicDtos = supplierBasicDtos;
	}

	public List<SupplierWithPartsCountDto> getSupplierWithPartsCountDtos() {
		return supplierWithPartsCountDtos;
	}

	public void setSupplierWithPartsCountDtos(List<SupplierWithPartsCountDto> supplierWithPartsCountDtos) {
		this.supplierWithPartsCountDtos = supplierWithPartsCountDtos;
	}

}
