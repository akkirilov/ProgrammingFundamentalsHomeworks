package app.models.suppliers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierBasicDto implements Serializable{

	private static final long serialVersionUID = 4828898816383567801L;

	@Expose
	@XmlAttribute(name = "name")
	private String name;
	
	@Expose
	@XmlAttribute(name = "is-importer")
	private Boolean isImporter;

	public SupplierBasicDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsImporter() {
		return isImporter;
	}

	public void setIsImporter(Boolean isImporter) {
		this.isImporter = isImporter;
	}
	
}
