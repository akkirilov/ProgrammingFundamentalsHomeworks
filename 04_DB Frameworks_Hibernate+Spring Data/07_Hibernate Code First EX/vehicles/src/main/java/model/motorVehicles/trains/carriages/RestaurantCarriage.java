package model.motorVehicles.trains.carriages;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RestaurantCarriage")
public class RestaurantCarriage extends Carriage{
	
	@Column(name = "table_count")
	private Integer tablesCount;

	public RestaurantCarriage() {
		super();
	}

	public RestaurantCarriage(Integer seatsCapacity, Integer tablesCount) {
		super(seatsCapacity);
		this.tablesCount = tablesCount;
	}

	public Integer getTablesCount() {
		return tablesCount;
	}

	public void setTablesCount(Integer tablesCount) {
		this.tablesCount = tablesCount;
	}

}
