package model;

public class PersegiPanjang extends Bidang{
	private double panjang;
	private double lebar;
	
	public PersegiPanjang(double panjang, double lebar) {
		this.panjang = panjang;
		this.lebar = lebar;
	}
	
	@Override
	public double luas() {
		double luas = panjang*lebar;
		return luas;
	}
	@Override
	public double keliling() {
		double keliling = 2*(panjang+lebar);
		return keliling;
	}
	@Override
	public void masukkanInputSisi() {
		
	}

	public double getPanjang() {
		return panjang;
	}

	public void setPanjang(double panjang) {
		this.panjang = panjang;
	}

	public double getLebar() {
		return lebar;
	}

	public void setLebar(double lebar) {
		this.lebar = lebar;
	}
	
}
