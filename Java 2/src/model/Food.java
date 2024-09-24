package model;

public abstract class Food {
	protected String id;
	protected String name; 
	protected int price;
	protected String type;
	protected String mainDish;
	protected int basePrice;
	
	
	public Food(String id, String name, int price, String type, String mainDish, int basePrice) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.mainDish = mainDish;
		this.basePrice = basePrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMainDish() {
		return mainDish;
	}

	public void setMainDish(String mainDish) {
		this.mainDish = mainDish;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public abstract void countPrice();
	

	
}
