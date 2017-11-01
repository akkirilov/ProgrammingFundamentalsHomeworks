package p02_BookShop;

public class Book {
	
	private String author;
    private String title;
    private Double price;

    public Book(String author, String title, Double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }
	
	private String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		if (title == null || title.trim().length() < 3) {
			throw new IllegalArgumentException("Title not valid!");
		}
		this.title = title;
	}

	private String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		
		if (author == null) {
            throw new IllegalArgumentException("Author not valid!");
        }

        String[] authorNames = author.split("\\s+");

        if (authorNames.length == 1 || author.isEmpty()) {
            this.author = author;
            return;
        }

        if (authorNames.length == 2) {
            if (Character.isDigit(authorNames[1].charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }

            this.author = author;
        }
	}

	protected double getPrice() {
		return price;
	}
	
	private void setPrice(double price) {
		if (price <= 0.0) {
			throw new IllegalArgumentException("Price not valid!");
		}
		this.price = price;
	}

	@Override
	public String toString() {
	    final StringBuilder sb = new StringBuilder();
	    sb.append("Type: ").append(this.getClass().getSimpleName())
	            .append(System.lineSeparator())
	            .append("Title: ").append(this.getTitle())
	            .append(System.lineSeparator())
	            .append("Author: ").append(this.getAuthor())
	            .append(System.lineSeparator())
	            .append("Price: ").append(this.getPrice())
	            .append(System.lineSeparator());
	    return sb.toString();
	}
	
}
