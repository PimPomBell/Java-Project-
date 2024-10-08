package model;

public abstract class Clothes {
	protected String id;
	protected String name;
	protected String size;
	protected String type;
	protected int price;
	protected int finalPrice;
	
	public Clothes(String id, String name, String size, String type, int price, int finalPrice) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.type = type;
		this.price = price;
		this.finalPrice = finalPrice;
	}

	public abstract void countPrice();
	
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
}
