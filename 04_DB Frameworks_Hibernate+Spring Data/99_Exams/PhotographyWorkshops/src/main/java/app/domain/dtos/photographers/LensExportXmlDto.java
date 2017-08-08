package app.domain.dtos.photographers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "photographer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class LensExportXmlDto {
	
	private String make;
	
	private String focalLength;
	
	private Double maxAperture;

	private String lensInfo;

	public LensExportXmlDto() {
		super();
	}

	@XmlTransient
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@XmlTransient
	public String getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	@XmlTransient
	public Double getMaxAperture() {
		return maxAperture;
	}

	public void setMaxAperture(Double maxAperture) {
		this.maxAperture = maxAperture;
	}

	//@XmlElement(name = "lens")
	@XmlValue
	public String getLensInfo() {
		return make + " " + focalLength + "mm f" + maxAperture;
	}

	public void setLensInfo(String lensInfo) {
		this.lensInfo = lensInfo;
	}
	
}
