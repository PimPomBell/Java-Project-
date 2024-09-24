package main;

import model.Mamalia;
import model.Kerbau;
import model.Paus;

public class TestHewan {

	public TestHewan() {
		Kerbau k = new Kerbau(200.1, 5);
		k.makan();
		
		Mamalia p = new Paus(500.25, 10); 
		p.makan();
		
		
		//test doang 
		System.out.println();
		System.out.printf("Berat kerbau : %.2f\n", k.getBerat());
		System.out.printf("Umur kerbau : %d\n", k.getUmur());
		System.out.println();
		System.out.printf("Berat paus : %.2f\n", p.getBerat());
		System.out.printf("Umur paus : %d\n", p.getUmur());
		
		
	}

	public static void main(String[] args) {
		new TestHewan();
	}

}
