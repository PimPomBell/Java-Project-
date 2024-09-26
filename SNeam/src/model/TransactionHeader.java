package model;

public class TransactionHeader {
	private String transactionId;
	private String userId;
	
	public TransactionHeader(String transactionId, String userId) {
		this.transactionId = transactionId;
		this.userId = userId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
