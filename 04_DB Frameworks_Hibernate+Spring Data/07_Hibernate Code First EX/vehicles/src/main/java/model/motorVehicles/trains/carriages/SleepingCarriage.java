package model.motorVehicles.trains.carriages;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SleepingCarriage")
public class SleepingCarriage extends Carriage{
	
	@Column(name = "beds_count")
	private Integer bedsCount;

	public SleepingCarriage() {
		super();
	}

	public SleepingCarriage(Integer seatsCapacity, Integer bedsCount) {
		super(seatsCapacity);
		this.bedsCount = bedsCount;
	}

	public Integer getTablesCount() {
		return bedsCount;
	}

	public void setTablesCount(Integer bedsCount) {
		this.bedsCount = bedsCount;
	}

}
