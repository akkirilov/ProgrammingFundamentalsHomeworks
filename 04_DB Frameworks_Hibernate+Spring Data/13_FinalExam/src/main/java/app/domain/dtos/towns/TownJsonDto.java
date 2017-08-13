package app.domain.dtos.towns;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class TownJsonDto implements Serializable {

	@Expose
	private String name;

	@Expose
	private Long population;

	public TownJsonDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}
	
}
