package app.domain.dtos.branches;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "branch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchXmlDto implements Serializable {

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "town")
	private String townName;

	@XmlAttribute(name = "total_clients")
	private Long totalClients;

	public BranchXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Long getTotalClients() {
		return totalClients;
	}

	public void setTotalClients(Long totalClients) {
		this.totalClients = totalClients;
	}
	
}
