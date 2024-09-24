package model;

public class Paus extends Mamalia {
	final int jumlah_sirip = 2;
	
	public Paus(double berat, int umur) {
		super(berat, umur);
	}

	
	public void berenang() {

	}

	@Override
	public void makan() {
		System.out.println("Karnivora");
		
	}

	@Override
	public void melahirkan() {
		
	}
}
