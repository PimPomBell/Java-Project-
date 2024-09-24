public class Movie {
	
	private String title;
	private String genre;
	private int rating;
	private String id;
	private int price;
	
	public Movie(String title, String genre, int rating, String id, int price) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.id = id;
		this.price = price;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
