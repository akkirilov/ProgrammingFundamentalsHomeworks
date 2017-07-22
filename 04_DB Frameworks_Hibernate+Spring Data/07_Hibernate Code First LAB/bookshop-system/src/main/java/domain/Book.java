package domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
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
	@Column(name = "book_id")
	private Long id;
	
	@Column(name = "title", length = 50)
	private String title;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	private Author author;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
	private Set<Category> categories;
	
	@Basic
	private BigDecimal price;
	
	@Basic
	private Integer copies;
	
	@Column(name = "description", length = 255, nullable = true)
	private String description;
	
	@Column(name = "release_date", nullable = true)
	private Date releaseDate; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "related_books",
    		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
    		inverseJoinColumns = @JoinColumn(name = "related_book_id", referencedColumnName = "book_id"))
	private Set<Book> relatedBooks;
	
	@Column(name = "edition_type")
	private Integer editionType;

	public Book() {  }

	public Book(String title, Author author, BigDecimal price, Integer copies,
			String description, Date releaseDate) {
		super();
		this.title = title;
		this.author = author;
		this.categories = new HashSet<Category>();
		this.price = price;
		this.copies = copies;
		this.description = description;
		this.releaseDate = releaseDate;
		this.relatedBooks = new HashSet<Book>();
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public void addRelatedBook(Book book) {
		if (this.relatedBooks == null) {
			this.relatedBooks = new HashSet<>();
		}
		this.relatedBooks.add(book);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
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

	public Set<Book> getRelatedBooks() {
		return relatedBooks;
	}

	public void setRelatedBooks(Set<Book> relatedBooks) {
		this.relatedBooks = relatedBooks;
	}

	public Integer getEditionType() {
		return editionType;
	}

	public void setEditionType(Integer editionType) {
		this.editionType = editionType;
	}
	
	
}
