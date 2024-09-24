package model;

public abstract class Fruit {
	protected String id;
	protected int price;
	protected int weight;
	
	public Fruit(String id, int price, int weight) {
		this.id = id;
		this.price = price;
		this.weight = weight;
	}
	
	public abstract double countPrice();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
	
}
