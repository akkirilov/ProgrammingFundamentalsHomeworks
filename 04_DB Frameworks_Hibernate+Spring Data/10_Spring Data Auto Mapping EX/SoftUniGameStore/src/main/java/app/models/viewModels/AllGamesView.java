package app.models.viewModels;

import java.math.BigDecimal;

public class AllGamesView {
	
	private String title;
	
	private BigDecimal price;
		
	public AllGamesView() {
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

	@Override
	public String toString() {
		return title + " " + price;
	}

}
