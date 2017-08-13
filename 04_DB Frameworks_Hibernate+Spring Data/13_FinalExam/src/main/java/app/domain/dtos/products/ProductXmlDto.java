package app.domain.dtos.products;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductXmlDto implements Serializable {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "clients")
	private Long clients;
	
	@XmlElement(name = "branch")
	private String branch;

	public ProductXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getClients() {
		return clients;
	}

	public void setClients(Long clients) {
		this.clients = clients;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
