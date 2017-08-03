package app.models.viewModels;

public class OwnGamesView {
	
	private String title;
	
	public OwnGamesView() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}

}
