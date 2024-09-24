package model;

public abstract class Mamalia {
	protected double berat;
	protected int umur;
	
	public Mamalia(double berat, int umur) {
		this.berat = berat;
		this.umur = umur;
	}
	
	public abstract void makan();
	
	public abstract void melahirkan();

	public double getBerat() {
		return berat;
	}

	public void setBerat(double berat) {
		this.berat = berat;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}
	
	
	
	
	
}
