package model.motorVehicles.trains.carriages;

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

@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Carriage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "seats_capacity")
	private Integer seatsCapacity;

	public Carriage() {
		super();
	}

	public Carriage(Integer seatsCapacity) {
		super();
		this.seatsCapacity = seatsCapacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSeatsCapacity() {
		return seatsCapacity;
	}

	public void setSeatsCapacity(Integer seatsCapacity) {
		this.seatsCapacity = seatsCapacity;
	}
	
}
