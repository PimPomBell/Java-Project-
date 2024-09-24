package model;

public class Cart {
	private String gameId;
	private String gameName;
	private int gamePrice;
	private int quantity;
	private int total;
	
	public Cart(String gameId, String gameName, int gamePrice, int quantity, int total) {
		this.gameId = gameId;
		this.gameName = gameName;
		this.gamePrice = gamePrice;
		this.quantity = quantity;
		this.total = total;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(int gamePrice) {
		this.gamePrice = gamePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
