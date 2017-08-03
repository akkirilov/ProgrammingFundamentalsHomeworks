package app.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title", unique = true)
	private String title;
	
	@Column(name = "trailer_url")
	private String trailerURL;
	
	@Column(name = "image_thumbnail")
	private String imageThumbnail;
	
	@Column(name = "size")
	private Double size;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@ManyToMany(mappedBy = "games")
	private Set<User> users;

	public Game() {
		super();
	}

	public Game(String title, String trailerURL, String imageThumbnail, Double size, BigDecimal price,
			String description, Date releaseDate) {
		super();
		this.title = title;
		this.trailerURL = trailerURL;
		this.imageThumbnail = imageThumbnail;
		this.size = size;
		this.price = price;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrailerURL() {
		return trailerURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}

	public String getImageThumbnail() {
		return imageThumbnail;
	}

	public void setImageThumbnail(String imageThumbnail) {
		this.imageThumbnail = imageThumbnail;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
