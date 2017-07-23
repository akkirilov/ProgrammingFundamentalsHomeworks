package model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "occupancies")
public class Occupancy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_occupied")
	private Date dateOccupied;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_number", referencedColumnName = "account_number")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_number", referencedColumnName = "room_number")
	private Room room;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rate_applied", referencedColumnName = "id")
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;
	
	@Column(name = "phone_charge")
	private Double phoneCharge;
	
	@Basic
	private String notes;

	public Occupancy() {  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateOccupied() {
		return dateOccupied;
	}

	public void setDateOccupied(Date dateOccupied) {
		this.dateOccupied = dateOccupied;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getPhoneCharge() {
		return phoneCharge;
	}

	public void setPhoneCharge(Double phoneCharge) {
		this.phoneCharge = phoneCharge;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
