package app.test;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestDto implements Serializable {

	@Expose
	@SerializedName(value="name")
	private String meins;
	
	@Expose
	@SerializedName(value="employeesCount")
	private Integer emc;
	
	@Expose
	@SerializedName(value="town")
	private String tangrs;

	public TestDto() {
		super();
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public Integer getEmc() {
		return emc;
	}

	public void setEmc(Integer emc) {
		this.emc = emc;
	}

	public String getTangrs() {
		return tangrs;
	}

	public void setTangrs(String tangrs) {
		this.tangrs = tangrs;
	}

	
}
