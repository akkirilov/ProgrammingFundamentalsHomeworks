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
@DiscriminatorValue("DSLR")
public class DSLRCamera extends Camera implements Serializable {

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
