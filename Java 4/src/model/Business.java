package model;

public class Business extends Plane {
	private String loungeType;
	
	
	public Business(String id, String name, String destination, String departure, int cost, int total, String loungeType) {
		super(id, name, destination, departure, cost, total);
		this.loungeType = loungeType;
	}


	public String getLoungeType() {
		return loungeType;
	}


	public void setLoungeType(String loungeType) {
		this.loungeType = loungeType;
	}


	@Override
	public void countPrice() {
		if(loungeType.equals("bar")) {
			total = (int)(cost*1.5);
		}
		if(loungeType.equals("restaurant")) {
			total = (int)(cost*2);
		}
		if(loungeType.equals("buffet")) {
			total = (int)(cost*2.5);
		}
	}
}
