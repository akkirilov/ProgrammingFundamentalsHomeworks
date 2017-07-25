package app.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
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
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "age_restriction")
	private Integer ageRestriction;
	
	@Basic
	private Integer copies;
	
	@Basic
	private Integer edition;
	
	@Basic
	private String title;
	
	@Basic
	private String description;
		
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Basic
	private BigDecimal price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "books_categories",
			joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private Set<Category> categories;
	
	@ManyToMany()
	@JoinTable(name = "related_books",
			joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "related_book_id", referencedColumnName = "id"))
	private Set<Book> relatedBooks;

	public Book() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(Integer ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Book> getRelatedBooks() {
		return relatedBooks;
	}

	public void setRelatedBooks(Set<Book> relatedBooks) {
		this.relatedBooks = relatedBooks;
	}
	
}
