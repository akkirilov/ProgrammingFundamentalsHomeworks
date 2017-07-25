package app.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "production_batches")
public class ProductionBatch implements Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic
	private Date date;
	
	@OneToMany(mappedBy = "batch", targetEntity = BasicShampoo.class)
	private Set<BasicShampoo> shampoos;

	public ProductionBatch() {
		this.date = Date.valueOf(LocalDate.now());
		this.shampoos = new HashSet<BasicShampoo>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBatchDate() {
		return date;
	}

	public void setBatchDate(Date batchDate) {
		this.date = batchDate;
		
	}

	public Set<BasicShampoo> getShampoos() {
		return shampoos;
	}

	public void setShampoos(Set<BasicShampoo> shampoos) {
		this.shampoos = shampoos;
		
	}
	
}
