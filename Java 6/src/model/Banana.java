package model;

public class Banana extends Fruit {
	private String ripeness;
	
	public Banana(String id, int price, int weight, String ripeness) {
		super(id, price, weight);
		this.ripeness = ripeness;
	}


	public String getRipeness() {
		return ripeness;
	}


	public void setRipeness(String ripeness) {
		this.ripeness = ripeness;
	}


	@Override
	public double countPrice() {
		double multiplier;
		
		if(ripeness.equals("Overripe")) {
			multiplier = 1.3;
		}
		else if(ripeness.equals("Semi-ripe")) {
			multiplier = 1;
		}
		else if(ripeness.equals("Ripe")) {
			multiplier = 0.8;
		}
		else {
			multiplier = 0.6;
		}
		
		double finalPrice = (price * multiplier) + (weight * 1.4);
		return finalPrice;
	}


}
