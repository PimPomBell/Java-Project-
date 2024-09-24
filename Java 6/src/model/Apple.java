package model;

public class Apple extends Fruit {
	private String variety;
	
	
	public Apple(String id, int price, int weight, String variety) {
		super(id, price, weight);
		this.variety = variety;
	}


	public String getVariety() {
		return variety;
	}


	public void setVariety(String variety) {
		this.variety = variety;
	}


	@Override
	public double countPrice() {
		double multiplier;
		
		if(variety.equals("Fuji")) {
			multiplier = 1.6;
		}
		else if(variety.equals("Gala")) {
			multiplier = 1.3;
		}
		else if(variety.equals("Honeycrisp")) {
			multiplier = 2;
		}
		else {
			multiplier = 1;
		}
		
		double finalPrice = (price * multiplier) + (weight*1.4);
		return finalPrice;
	}
}



