package model;

public abstract class Food {
	protected String id;
	protected String name;
	protected int price;
	protected int freshness;
	
	public Food(String id, String name, int price, int freshness) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.freshness = freshness;
	}

	public abstract double countPrice();
	
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

	public int getFreshness() {
		return freshness;
	}

	public void setFreshness(int freshness) {
		this.freshness = freshness;
	}
	
	
	
}
