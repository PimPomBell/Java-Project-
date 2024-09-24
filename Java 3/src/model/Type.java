package model;

public abstract class Type {
	protected String id;
	protected String type;
	protected String name;
	protected int price;
	protected int fresh;
	protected double gtotal;
	
	
	public Type(String id, String type, String name, int price, int fresh, double gtotal) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.fresh = fresh;
		this.gtotal = gtotal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getFresh() {
		return fresh;
	}

	public void setFresh(int fresh) {
		this.fresh = fresh;
	}

	public double getGtotal() {
		return gtotal;
	}

	public void setGtotal(double gtotal) {
		this.gtotal = gtotal;
	}

	public abstract void countPrice();
	
}
