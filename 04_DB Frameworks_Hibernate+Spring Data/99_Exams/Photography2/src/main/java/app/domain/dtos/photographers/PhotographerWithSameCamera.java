package app.domain.dtos.photographers;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "photographer")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"fullName", "cameraToExport", "lenses"})
public class PhotographerWithSameCamera {
	
	private String firstName;

	private String lastName;

	private String primaryCameraMake;
	
	private String primaryCameraModel;
	
	private String cameraToExport;
	
	private String fullName;
	
	
	private Set<LensXmlDto> lenses;
	public PhotographerWithSameCamera() {
		super();
	}

	@XmlTransient
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlTransient
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlTransient
	public String getPrimaryCameraMake() {
		return primaryCameraMake;
	}

	public void setPrimaryCameraMake(String primaryCameraMake) {
		this.primaryCameraMake = primaryCameraMake;
	}

	@XmlTransient
	public String getPrimaryCameraModel() {
		return primaryCameraModel;
	}

	public void setPrimaryCameraModel(String primaryCameraModel) {
		this.primaryCameraModel = primaryCameraModel;
	}

	@XmlAttribute(name = "primary-camera")
	public String getCameraToExport() {
		return primaryCameraMake + " " + primaryCameraModel;
	}

	public void setCameraToExport(String cameraToExport) {
		this.cameraToExport = cameraToExport;
	}

	@XmlAttribute(name = "name")
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElementWrapper(name = "lenses")
	@XmlElement(name = "lens")
	public Set<LensXmlDto> getLenses() {
		return lenses;
	}

	public void setLenses(Set<LensXmlDto> lenses) {
		this.lenses = lenses;
	}
	
}
