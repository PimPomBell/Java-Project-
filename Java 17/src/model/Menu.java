package model;

public class Menu {
	protected String menuCode;
	protected String menuName;
	protected int price;
	
	public Menu(String menuCode, String menuName, int price) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.price = price;
	}
	
	
	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
