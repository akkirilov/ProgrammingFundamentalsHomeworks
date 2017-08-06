package app.entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -3512555014851401219L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private Integer age;
	
	@OneToMany(mappedBy = "seller")
	private Set<Product> soldProducts;
	
	@OneToMany(mappedBy = "buyer")
	private Set<Product> boughtProducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_friends", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
	private Set<User>friends;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User friend) {
		if (this.friends == null) {
			this.friends = new HashSet<>();
		}
		this.friends.add(friend);
	}
	
	public String getFullName(){
		if (this.firstName == null) {
			if (this.lastName == null) {
				return "";
			} else {
				return this.lastName;
			}
		} else {
			if (this.lastName == null) {
				return this.firstName;
			} else {
				return this.firstName + " " + this.lastName;
			}
		}
	}

	public Set<Product> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(Set<Product> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public void removeProductFromSoldProducts(Product product) {
		this.soldProducts.remove(product);
	}
	
	public Set<Product> getBoughtProducts() {
		return boughtProducts;
	}

	public void setBoughtProducts(Set<Product> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
}
