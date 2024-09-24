package model;

public class Jacket extends Clothes {
	
	public Jacket(String id, String name, String size, String type, int price, int finalPrice) {
		super(id, name, size, type, price, finalPrice);
	}

	@Override
	public void countPrice() {
		if(type.equals("Jacket")) {
			finalPrice = price;
		}
		else if(type.equals("Hoodie")) {
			finalPrice = price + (price*10/100);
		}
	}
}
