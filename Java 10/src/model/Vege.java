package model;

public class Vege extends Food {
	private int quantity;

	public Vege(String id, String name, int price, int freshness, int quantity) {
		super(id, name, price, freshness);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public double countPrice() {
		double finalPrice = (int)price*quantity;
		return finalPrice;
	}
	
}
