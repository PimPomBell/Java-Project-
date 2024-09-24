package model;

public abstract class Shape {

	protected int panjang;
	
	public int getPanjang() {
		return panjang;
	}



	public void setPanjang(int panjang) {
		this.panjang = panjang;
	}



	public Shape(int panjang) {
		this.panjang = panjang;
	}


	public abstract void printPersegi();
	
}
