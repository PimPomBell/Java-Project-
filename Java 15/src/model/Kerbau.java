package model;

public class Kerbau extends Mamalia{
	final int jumlah_tanduk = 2;
	
	public Kerbau(double berat, int umur) {
		super(berat, umur);
		// TODO Auto-generated constructor stub
	}
	
	public void memamahbiak() {
	
	}

	@Override
	public void makan() {
		System.out.println("Herbivora");
		
	}

	@Override
	public void melahirkan() {
		
	}
	
}
