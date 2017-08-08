package app.domain.entities;

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

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Camera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "make")
	private String make;
	
	@NotNull
	@Column(name = "model")
	private String model;
	
	@Column(name = "is_full_frame")
	private Boolean isFullFrame;
	
	@NotNull
	@Min(100)
	@Column(name = "min_iso")
	private Integer minISO;
	
	@Column(name = "max_iso")
	private Integer maxISO;

	public Camera() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
