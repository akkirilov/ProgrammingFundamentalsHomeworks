package app.domain.dtos.venues;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import app.domain.entities.Wedding;

@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenueinSofiaXmlDto  implements Serializable {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "capacity")
	private Integer capacity;
	
	@XmlElement(name = "weddings-count")
	private Integer weddingCount;
	
	@XmlTransient
	private Set<Wedding> weddings;

	public VenueinSofiaXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getWeddingCount() {
		return weddingCount;
	}

	public void setWeddingCount(Integer weddingCount) {
		this.weddingCount = weddingCount;
	}

	public Set<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(Set<Wedding> weddings) {
		this.weddings = weddings;
	}
	
}
