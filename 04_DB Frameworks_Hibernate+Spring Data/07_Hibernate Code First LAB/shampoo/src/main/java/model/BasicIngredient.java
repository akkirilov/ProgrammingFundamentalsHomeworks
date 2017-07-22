package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "basic_ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic
	private String name;
	
	@Basic
	private BigDecimal price;
	
	@ManyToMany(mappedBy = "ingredients", targetEntity = BasicShampoo.class)
	private List<BasicShampoo> shampoos;
	
	public BasicIngredient() {  }
	
	public BasicIngredient(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}	
	
}
