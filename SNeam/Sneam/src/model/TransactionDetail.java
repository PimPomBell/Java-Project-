package model;

public class TransactionDetail {
	private String transactionId;
	private String gameId;
	private int quantity;
	
	public TransactionDetail(String transactionId, String gameId, int quantity) {
		this.transactionId = transactionId;
		this.gameId = gameId;
		this.quantity = quantity;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
