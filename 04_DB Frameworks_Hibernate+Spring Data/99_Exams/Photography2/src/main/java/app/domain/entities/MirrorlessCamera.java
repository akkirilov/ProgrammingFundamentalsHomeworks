package app.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Mirrorless")
public class MirrorlessCamera extends Camera implements Serializable {
	
	@Column(name = "max_video_resolution")
	private String maxVideoResolution;
	
	@Column(name = "max_frame_rate")
	private Integer maxFrameRate;

	public MirrorlessCamera() {
		super();
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
