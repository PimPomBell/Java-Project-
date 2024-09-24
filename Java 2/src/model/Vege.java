package model;

public class Vege extends Food{
	private String vegetable;
	
	
	public Vege(String id, String name, int price, String type, String mainDish, int basePrice, String vegetable) {
		super(id, name, price, type, mainDish, basePrice);
		this.vegetable = vegetable;
	}


	public String getVegetable() {
		return vegetable;
	}


	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}


	@Override
	public void countPrice() {
		if(mainDish.equalsIgnoreCase("Rice")) {
			price += 5000;
		}
		else if(mainDish.equalsIgnoreCase("Noodle")) {
			price += 3000;
		}
		
		if(vegetable.equals("Potato")) {
			price += name.length()*2000;
		}
		
		if(vegetable.equals("Tomato")) {
			price += name.length()*1000;
		}
		price += basePrice;
		
	}

}
