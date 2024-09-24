package model;

public class Vege extends Type {
	private int qty;
	
	public Vege(String id, String type, String name, int price, int fresh, double gtotal, int qty) {
		super(id, type, name, price, fresh, gtotal);
		this.qty = qty;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	@Override
	public void countPrice() {
		gtotal = (int)(price*qty);
	}
	
}
