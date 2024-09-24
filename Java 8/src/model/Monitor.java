package model;

public abstract class Monitor {
	protected String id;
	protected String brand;
	protected String name;
	protected int size;
	protected double weight;
	
	public Monitor(String id,String brand, String name, int size, double weight) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.size = size;
		this.weight = weight;
	}
	
	public abstract int countPrice();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
}	
