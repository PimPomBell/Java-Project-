package model;

public class Special extends Menu{
	private int discount;

	public Special(String menuCode, String menuName, int price, int discount) {
		super(menuCode, menuName, price);
		this.discount =  discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
}	
