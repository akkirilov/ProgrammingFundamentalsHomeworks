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
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_number", referencedColumnName = "account_number")
	private Customer customer;
	
	@Column(name = "first_date_occupied")
	private Date firstDateOccupied;
	
	@Column(name = "last_date_occupied")
	private Date lastDateOccupied;
	
	@Column(name = "total_days")
	private Integer totalDays;

	@Column(name = "amount_charged")
	private Double amountCharged;
	
	@Column(name = "tax_rate")
	private Double taxRate;
	
	@Column(name = "tax_amount")
	private Double taxAmount;
	
	@Column(name = "payment_total")
	private Double paymentTotal;
	
	@Basic
	private String notes;

	public Payment() {  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getFirstDateOccupied() {
		return firstDateOccupied;
	}

	public void setFirstDateOccupied(Date firstDateOccupied) {
		this.firstDateOccupied = firstDateOccupied;
	}

	public Date getLastDateOccupied() {
		return lastDateOccupied;
	}

	public void setLastDateOccupied(Date lastDateOccupied) {
		this.lastDateOccupied = lastDateOccupied;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	public Double getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(Double amountCharged) {
		this.amountCharged = amountCharged;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(Double paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
