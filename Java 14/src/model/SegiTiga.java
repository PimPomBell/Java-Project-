package model;

public class SegiTiga extends Bidang{
	private double sisi1;
	private double sisi2;
	private double sisi3;
	
	public SegiTiga(double sisi1, double sisi2, double sisi3) {
		this.sisi1 = sisi1;
		this.sisi2 = sisi2;
		this.sisi3 = sisi3;
	}

	@Override
	public double luas() {
		double s = 0.5*(sisi1 + sisi2 + sisi3);
		
		double luas = Math.sqrt(s*(s-sisi1)*(s-sisi2)*(s-sisi3));
		
		return luas;
	}

	@Override
	public double keliling() {
		double keliling = sisi1 + sisi2 + sisi3;
		return keliling;
	}

	@Override
	public void masukkanInputSisi() {
		// TODO Auto-generated method stub
		
	}

	public double getSisi1() {
		return sisi1;
	}

	public void setSisi1(double sisi1) {
		this.sisi1 = sisi1;
	}

	public double getSisi2() {
		return sisi2;
	}

	public void setSisi2(double sisi2) {
		this.sisi2 = sisi2;
	}

	public double getSisi3() {
		return sisi3;
	}

	public void setSisi3(double sisi3) {
		this.sisi3 = sisi3;
	}
	
}
