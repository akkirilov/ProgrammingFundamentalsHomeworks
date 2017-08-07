package app.models.suppliers;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;

import app.entities.Part;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SupplierWithPartsCountDto {

	@Expose
	private long id;
	
	@Expose
	private String name;
	
	@Expose
	private Integer partsCount;
	
	private Set<Part> parts;

	public SupplierWithPartsCountDto() {
		super();
	}

	@XmlAttribute(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "parts-count")
	public Integer getPartsCount() {
		if (this.parts == null) {
			return 0;
		}
		return this.parts.size();
	}

	public void setPartsCount(Integer partsCount) {
		this.partsCount = partsCount;
	}

	@XmlTransient
	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}
	
}
