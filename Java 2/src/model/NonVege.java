package model;

public class NonVege extends Food {
	private String meat;
	private String addOn;
	
	public NonVege(String id, String name, int price, String type, String mainDish, int basePrice, String meat, String addOn) {
		super(id, name, price, type, mainDish, basePrice);
		this.meat = meat;
		this.addOn = addOn;
	}


	

	public String getMeat() {
		return meat;
	}




	public void setMeat(String meat) {
		this.meat = meat;
	}




	public String getAddOn() {
		return addOn;
	}




	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}




	@Override
	public void countPrice() {
		if(mainDish.equalsIgnoreCase("Rice")) {
			price += 5000;
		}
		else if(mainDish.equalsIgnoreCase("Noodle")) {
			price += 3000;
		}
		
		if(meat.equals("Beef")) {
			price += name.length()*2500;
		}
		
		if(meat.equals("Chicken")) {
			price += name.length()*1000;
		}
		
		if(meat.equals("Pork")) {
			price += name.length()*2000;
		}
	
		if(addOn.equalsIgnoreCase("Meatballs")) {
			price += 4000;
		}
		if(addOn.equalsIgnoreCase("Fishballs")) {
			price += 3000;
		}
		if(addOn.equalsIgnoreCase("Fried Potato")) {
			price += 5000;
		}
		price += basePrice;
		}

}
