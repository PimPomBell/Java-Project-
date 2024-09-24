package model;

public class Designer extends Monitor{
	private double accuracy;

	
	
	public Designer(String id, String brand, String name, int size, double weight, double accuracy) {
		super(id, brand, name, size, weight);
		this.accuracy = accuracy;
	}



	public double getAccuracy() {
		return accuracy;
	}



	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}



	@Override
	public int countPrice() {
		int bprice;
		if(brand.equals("AOC")) {
			bprice = 2500000;
		}
		else if (brand.equals("LG")) {
			bprice = 2700000;
		}
		else {
			bprice = 3000000;
		}
		
		int totPrice = (int)(bprice + (2 - accuracy)*1000000);
		
		return totPrice;  
	}
	
	
	
}
