package app.domain.dtos.cameras;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraImportJsonDto implements Serializable{

	private static final long serialVersionUID = 8327713710551465601L;

	@Expose
	private String type;

	@Expose
	private String make;

	@Expose
	private String model;

	@Expose
	private Boolean isFullFrame;

	@Expose
	private Integer minISO;

	@Expose
	private Integer maxISO;

	@Expose
	@SerializedName(value = "MaxShutterSpeed")
	private Integer maxShutterSpeed;

	@Expose
	private String maxVideoResolution;

	@Expose
	private Integer maxFrameRate;

	public CameraImportJsonDto() {
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
		return minISO;
	}

	public void setMinIso(Integer minIso) {
		this.minISO = minIso;
	}

	public Integer getMaxIso() {
		return maxISO;
	}

	public void setMaxIso(Integer maxIso) {
		this.maxISO = maxIso;
	}

	public Integer getMaxShutterSpeed() {
		return maxShutterSpeed;
	}

	public void setMaxShutterSpeed(Integer maxShutterSpeed) {
		this.maxShutterSpeed = maxShutterSpeed;
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

}
