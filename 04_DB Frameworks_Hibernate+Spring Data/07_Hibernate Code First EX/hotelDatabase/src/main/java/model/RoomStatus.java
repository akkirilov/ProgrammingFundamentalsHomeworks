package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms_status ")
public class RoomStatus {

	@Id
	@Column(name = "room_status")
	private String roomStatus;
	
	@Basic
	private String notes;

	public RoomStatus() {  }

	public RoomStatus(String roomStatus) {
		super();
		this.roomStatus = roomStatus;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
