package app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -1804175173972807396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToOne(optional = true)
	private User seller;

	@ManyToOne(optional = true)
	private User buyer;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "products_categories", 
			joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private Set<Category>categories;

	public Product() {
		super();
		this.categories = new HashSet<>();
	}

	public Product(String name, BigDecimal price, User seller, User buyer, Set<Category> categories) {
		super();
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.buyer = buyer;
		this.categories = categories;
	}

	public Product(String name, BigDecimal price) {
		super();
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

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		if (this.categories == null || this.categories.size() < 1) {
			this.categories = new HashSet<>();
		}
		this.categories.add(category);
	}
	
}
