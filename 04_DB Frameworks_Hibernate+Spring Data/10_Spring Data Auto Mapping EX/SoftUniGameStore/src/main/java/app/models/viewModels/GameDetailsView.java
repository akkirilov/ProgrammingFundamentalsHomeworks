package app.models.viewModels;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameDetailsView {
	
	private String title;
	private BigDecimal price;
	private Double size;
	private String trailerURL;
	private String imageThumbnail;
	private String description;
	private Date releaseDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public GameDetailsView() {
		super();
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

	@Override
	public String toString() {
		return "Title: " + title
				+ "\nPrice: " + price 
				+ "\nSize: " + size
				+ "\nTrailer URL: " + trailerURL
				+ "\nThumbnail URL: " + imageThumbnail 
				+ "\nDescription: " + description 
				+ "\nRelease date: " + sdf.format(releaseDate);
	}
	
}
