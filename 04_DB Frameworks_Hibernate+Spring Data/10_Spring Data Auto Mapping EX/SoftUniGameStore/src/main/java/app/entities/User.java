package app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import app.enums.Role;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_games",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
	private Set<Game> games;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_shopping_cart",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
	private Set<Game> shoppingCart;

	public User() {
		super();
	}

	public User(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	public void addGame(Game game) {
		this.games.add(game);
	}

	public Set<Game> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Set<Game> shopingCart) {
		this.shoppingCart = shopingCart;
	}
	
	public void addGameInShoppingCart(Game game) {
		if (this.shoppingCart == null || this.shoppingCart.size() < 1) {
			this.shoppingCart = new HashSet<>();
		}
		this.shoppingCart.add(game);
	}
	
	public void removeGameFromShoppingCart(Game game) {
		this.shoppingCart.remove(game);
	}
		
}
