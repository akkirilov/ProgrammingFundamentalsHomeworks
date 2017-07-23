package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms_type")
public class RoomType {
	
	@Id
	@Column(name = "room_type")
	private String roomType;
	
	@Basic
	private String notes;

	public RoomType() {  }

	public RoomType(String roomType) {
		super();
		this.roomType = roomType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
