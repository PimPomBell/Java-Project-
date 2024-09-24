package model;

public class Meat extends Type {
	private double weight;
	private double thickness;
	
	public Meat(String id, String type, String name, int price, int fresh, double gtotal, double weight, double thickness) {
		super(id, type, name, price, fresh, gtotal);
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
	public void countPrice() {
		gtotal = (int)(price*(weight+(thickness*0.5)));
	}
}
