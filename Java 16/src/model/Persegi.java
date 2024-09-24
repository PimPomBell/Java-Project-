package model;

public class Persegi extends Shape{

	public Persegi(int panjang) {
		super(panjang);
		
	}

	@Override
	public void printPersegi() {
		for(int i = 0; i < panjang; i++) {
			for(int j = 0; j < panjang; j++) {
				System.out.print("0 ");
			}
			System.out.println();
		}
	}

}
