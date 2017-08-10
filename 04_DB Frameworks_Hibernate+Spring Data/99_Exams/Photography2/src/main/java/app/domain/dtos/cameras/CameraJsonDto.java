package app.domain.dtos.cameras;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraJsonDto implements Serializable {
	
	@Expose
	private String type;
	
	@Expose
	private String make;

	@Expose
	private String model;

	@Expose
	private Boolean isFullFrame;

	@Expose
	@SerializedName(value = "minISO")
	private Integer minIso;

	@Expose
	@SerializedName(value = "maxISO")
	private Integer maxIso;

	@Expose
	private String maxVideoResolution;

	@Expose
	private Integer maxFrameRate;

	@Expose
	private Integer maxShutterSpeed;
	
	public CameraJsonDto() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsFullFrame() {
		return isFullFrame;
	}

	public void setIsFullFrame(Boolean isFullFrame) {
		this.isFullFrame = isFullFrame;
	}

	public Integer getMinIso() {
		return minIso;
	}

	public void setMinIso(Integer minIso) {
		this.minIso = minIso;
	}

	public Integer getMaxIso() {
		return maxIso;
	}

	public void setMaxIso(Integer maxIso) {
		this.maxIso = maxIso;
	}

	public String getMaxVideoResolution() {
		return maxVideoResolution;
	}

	public void setMaxVideoResolution(String maxVideoResolution) {
		this.maxVideoResolution = maxVideoResolution;
	}

	public Integer getMaxFrameRate() {
		return maxFrameRate;
	}

	public void setMaxFrameRate(Integer maxFrameRate) {
		this.maxFrameRate = maxFrameRate;
	}

	public Integer getMaxShutterSpeed() {
		return maxShutterSpeed;
	}

	public void setMaxShutterSpeed(Integer maxShutterSpeed) {
		this.maxShutterSpeed = maxShutterSpeed;
	}
	
}
