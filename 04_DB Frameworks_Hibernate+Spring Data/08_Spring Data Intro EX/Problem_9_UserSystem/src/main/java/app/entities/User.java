package app.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import app.utils.Validator;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username", length = 30)
	private String username;
	
	@Column(name = "first_name", length = 30)
	private String firstName;
	
	@Column(name = "last_name", length = 30)
	private String lastName;
	
	@Column(name = "password", length = 60)
	private String password;
	
	@Basic
	private Integer age;
	
	@Column(name = "email", length = 60)
	private String email;
	
	@Column(name = "picture_path")
	private String picturePath;
	
	@Column(name = "registration_date")
	private Date registrationDate;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Town.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "born_town_id", referencedColumnName = "id")
	Town bornTown;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Town.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "living_town_id", referencedColumnName = "id")
	Town livingTown;
	
	@ManyToMany()
	@JoinTable(name = "users_friends",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
	private Set<User> friends;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Album> albums;

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (Validator.username(username)) {
			this.username = username;
		} else {
			throw new IllegalArgumentException
			("Username length should be between 4 and 30 throw symbols!");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!Validator.passwordLength(password)) {
			throw new IllegalArgumentException
			("Password length should be between 6 and 50 symbols!");
		}
		if (!Validator.passwordSymbols(password)) {
			throw new IllegalArgumentException
			("Password should contains at least one special symbol "
					+ "(!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?)!");
		}
		if (!Validator.passwordDigit(password)) {
			throw new IllegalArgumentException
			("Password should contains at least one digit!");
		}
		if (!Validator.passwordLowercase(password)) {
			throw new IllegalArgumentException
			("Password should contains at least one lowercase letter!");
		}
		if (!Validator.passwordUppercase(password)) {
			throw new IllegalArgumentException
			("Password should contains at least one uppercase letter!");
		}
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		if (Validator.age(age)) {
			this.age = age;
		} else {
			throw new IllegalArgumentException
			("Age should be between 1 and 120!");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (Validator.email(email)) {
			this.email = email;
		} else {
			throw new IllegalArgumentException
			("Invalid email format!");
		}
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		if (Validator.picturePath(picturePath)) {
			this.picturePath = picturePath;
		} else {
			throw new IllegalArgumentException
			("Picture should be jpeg or png!");
		}
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Town getBornTown() {
		return bornTown;
	}

	public void setBornTown(Town bornTown) {
		this.bornTown = bornTown;
	}

	public Town getLivingTown() {
		return livingTown;
	}

	public void setLivingTown(Town livingTown) {
		this.livingTown = livingTown;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Transient
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	@Transient
	public void addFriend(User friend) {
		if (this.friends == null) {
			this.friends = new HashSet<>();
		}
		this.friends.add(friend);
	}
	
	@Transient
	public void addAlbum(Album album) {
		if (this.albums == null) {
			this.albums = new HashSet<>();
		}
		this.albums.add(album);
	}
	
}
