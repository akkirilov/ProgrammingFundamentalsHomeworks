package model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements Shampoo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic
	private String brand;
	
	@Basic
	private BigDecimal price;
	
	@OneToOne
	@JoinColumn(name = "label_id", referencedColumnName = "id")
	private ClassicLabel label;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "batch_id", referencedColumnName = "id")
	private ProductionBatch batch;
	
	@ManyToMany
	@JoinTable(name = "shampoos_ingredients",
			joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
	private Set<BasicIngredient> ingredients;
	
	public BasicShampoo() {   }
	
	public BasicShampoo(String brand, BigDecimal price, ClassicLabel label, ProductionBatch batch, Set<BasicIngredient> ingredients) {
		super();
		this.brand = brand;
		this.price = price;
		this.label = label;
		this.batch = batch;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ClassicLabel getLabel() {
		return label;
	}

	public void setLabel(ClassicLabel label) {
		this.label = label;
	}

	public ProductionBatch getBatch() {
		return batch;
	}

	public void setBatch(ProductionBatch batch) {
		this.batch = batch;
	}

	public Set<BasicIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<BasicIngredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
