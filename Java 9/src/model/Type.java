package model;

public abstract class Type {
	protected String id;
	protected String model;
	protected String brand;
	protected int string;
	
	public Type(String id, String model, String brand, int string) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.string = string;
	}

	public abstract int countPrice();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getString() {
		return string;
	}

	public void setString(int string) {
		this.string = string;
	}

	
	
	
}
