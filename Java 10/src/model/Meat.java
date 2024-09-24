package model;

public class Meat extends Food {
	private double weight;
	private double thickness;
	
	public Meat(String id, String name, int price, int freshness, double weight, double thickness) {
		super(id, name, price, freshness);
		this.weight = weight;
		this.thickness = thickness;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	@Override
	public double countPrice() {
		double finalPrice = (int)price*(weight+(thickness*0.5));
		return finalPrice;
	}

}
