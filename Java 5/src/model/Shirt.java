package model;

public class Shirt extends Clothes {
	
	public Shirt(String id, String name, String size, String type, int price, int finalPrice) {
		super(id, name, size, type, price, finalPrice);
	}

	@Override
	public void countPrice() {
		if(size.equals("S")) {
			finalPrice = price;
		}
		else if(size.equals("M")){
			finalPrice = price;
		}
		else if(size.equals("L")) {
			finalPrice = price;
		}
		else if(size.equals("XL")) {
			finalPrice = price + (price*5/100);
		}
		
	}
}
