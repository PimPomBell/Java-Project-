package model;

public class Accoustic extends Type{
	private String hybrid;

	public Accoustic(String id, String model, String brand, int string, String hybrid) {
		super(id, model, brand, string);
		this.hybrid = hybrid;
	}

	
	
	public String getHybrid() {
		return hybrid;
	}



	public void setHybrid(String hybrid) {
		this.hybrid = hybrid;
	}



	@Override
	public int countPrice() {
		int bprice;
		int eprice;
		
		if(brand.equals("Yamaha")) {
			bprice = 1500000;
		}
		else if(brand.equals("Fender")) {
			bprice = 2000000;
		}
		else {
			bprice = 1000000;
		}
		
		if(hybrid.equals("Yes")) {
			eprice = 500000;
		}
		else {
			eprice = 0;
		}
		
		int totalPrice = bprice + (150000*string) + eprice;
		
		return totalPrice;
	}
	
	
	
}
