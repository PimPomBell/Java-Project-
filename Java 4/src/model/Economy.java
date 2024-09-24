package model;

public class Economy extends Plane{
	private int baggageCost;
	
	public Economy(String id, String name, String destination, String departure, int cost, int total, int baggageCost) {
		super(id, name, destination, departure, cost, total);
		this.baggageCost = baggageCost;
	}



	@Override
	public void countPrice() {
		total = cost + baggageCost;
	}



	public int getBaggageCost() {
		return baggageCost;
	}



	public void setBaggageCost(int baggageCost) {
		this.baggageCost = baggageCost;
	}
}
