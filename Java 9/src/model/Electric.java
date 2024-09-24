package model;

public class Electric extends Type{
	private String amp;

	public Electric(String id, String model, String brand, int string, String amp) {
		super(id, model, brand, string);
		this.amp = amp;
	}
	
	public String getAmp() {
		return amp;
	}

	public void setAmp(String amp) {
		this.amp = amp;
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
		
		if(amp.equals("Yes")) {
			eprice = 1000000;
		}
		else {
			eprice = 0;
		}
		
		int totalPrice = bprice + (150000*string) + eprice;
		
		return totalPrice;
	}
	
	
	
}
