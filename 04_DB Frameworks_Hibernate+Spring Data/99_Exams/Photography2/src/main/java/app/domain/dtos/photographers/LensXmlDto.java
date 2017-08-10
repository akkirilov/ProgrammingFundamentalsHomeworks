package app.domain.dtos.photographers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;

@XmlRootElement(name = "lens")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class LensXmlDto {
	
	private Integer focalLength;

	private String make;
	
	private Double maxAperture;
	
	private String lensToExport;

	public LensXmlDto() {
		super();
	}

	@XmlTransient
	public Integer getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(Integer focalLength) {
		this.focalLength = focalLength;
	}

	@XmlTransient
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@XmlTransient
	public Double getMaxAperture() {
		return maxAperture;
	}

	public void setMaxAperture(Double maxAperture) {
		this.maxAperture = maxAperture;
	}

	@XmlAttribute(name = "lens")
	public String getLensToExport() {
		return make + " " + focalLength + "mm f" + maxAperture;
	}

	public void setLensToExport(String lensToExport) {
		this.lensToExport = lensToExport;
	}
	
}
