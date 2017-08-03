package app.models.bindingModels;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddGame {
	
	@Pattern(regexp = "[A-Z]+.+", message = "Title has to begin with uppercase letter!")
	@Size(min = 3, max = 100, message = "Title length must be between 3 and 100 symbols!")
	private String title;
	
	@DecimalMin(value = "0.00", inclusive = false, message = "Price must be positive number!")
	@Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "Invalid price format!")
	private BigDecimal price;
	
	private Double size;
	
	@Size(min = 11, max = 11, message = "Trailer URL length must be 11 symbols!")
	private String trailerURL;
	
	@Pattern(regexp = "((http:\\/\\/+)|(https:\\/\\/+)).+", message = "Thumbnail URL should be starting with 'http://' or 'https://' !")
	private String imageThumbnail;
	
	@Size(min = 20)
	private String description;

	private Date releaseDate;
	
	public AddGame() {
		super();
	}

	public AddGame(String title, BigDecimal price, Double size, String trailerURL, String imageThumbnail,
			String description, Date releaseDate) {
		super();
		this.title = title;
		this.price = price;
		this.size = size;
		this.trailerURL = trailerURL;
		this.imageThumbnail = imageThumbnail;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
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
	
}
