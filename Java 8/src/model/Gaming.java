package model;

public class Gaming extends Monitor{
	private int refresh;


	public Gaming(String id, String brand, String name, int size, double weight, int refresh) {
		super(id, brand, name, size, weight);
		this.refresh = refresh;
	}

	
	
	public int getRefresh() {
		return refresh;
	}



	public void setRefresh(int refresh) {
		this.refresh = refresh;
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
		
		int totPrice = bprice + refresh*10000;
		
		return totPrice;
	}
	
	
	
}
