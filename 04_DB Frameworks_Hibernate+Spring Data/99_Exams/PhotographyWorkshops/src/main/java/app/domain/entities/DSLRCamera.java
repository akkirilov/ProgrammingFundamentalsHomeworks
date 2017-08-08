package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends Camera {
	
	@Column(name = "max_shutter_speed")
	private Integer maxShutterSpeed;

	public DSLRCamera() {
		super();
	}

	public Integer getMaxShutterSpeed() {
		return maxShutterSpeed;
	}

	public void setMaxShutterSpeed(Integer maxShutterSpeed) {
		this.maxShutterSpeed = maxShutterSpeed;
	}
	
}
