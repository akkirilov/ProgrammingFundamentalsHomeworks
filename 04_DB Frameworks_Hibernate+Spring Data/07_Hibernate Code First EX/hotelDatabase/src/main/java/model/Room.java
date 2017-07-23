package model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@Column(name = "room_number")
	private Integer roomNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_type", referencedColumnName = "room_type")
	private RoomType roomType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bed_type", referencedColumnName = "bed_type")
	private BedType bedType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_status", referencedColumnName = "room_status")
	private RoomStatus roomStatus;
	
	@Basic
	private Double price;
	
	@Basic
	private String notes;

	public Room() {  }
	
	public Room(Integer roomNumber, RoomType roomType, BedType bedType, RoomStatus roomStatus, Double price) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.bedType = bedType;
		this.roomStatus = roomStatus;
		this.price = price;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
