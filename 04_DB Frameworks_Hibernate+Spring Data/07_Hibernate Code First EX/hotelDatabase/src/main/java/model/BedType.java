package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beds_type")
public class BedType {
	
	@Id
	@Column(name = "bed_type")
	private String bedType;
	
	@Basic
	private String notes;

	public BedType() {  }

	public BedType(String bedType) {
		super();
		this.bedType = bedType;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
