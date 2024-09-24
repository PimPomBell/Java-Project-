package main;
import java.util.*;

import model.Bidang;
import model.PersegiPanjang;
import model.SegiTiga;

public class Main {
	ArrayList<Bidang> bid = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	int menu;
	double pjg, lbr, s1, s2, s3;
	public Main() {
		do {
			System.out.println();
			System.out.println("Pilih Bidang");
			System.out.println("1. Persegi Panjang");
			System.out.println("2. Segi Tiga");
			System.out.println("3. Exit");
			System.out.print(">>");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1 :
				do {
					System.out.print("Masukkan Panjang : ");
					pjg = s.nextDouble();
					s.nextLine();
				} while (pjg <= 0);
				
				do {
					System.out.print("Masukkan Panjang : ");
					lbr = s.nextDouble();
					s.nextLine();
				} while (lbr <= 0);
				
				PersegiPanjang p = new PersegiPanjang(pjg, lbr);
				bid.add(p);
				System.out.println();
				System.out.printf("Luas Persegi Panjang : %.2f\n", p.luas());
				System.out.printf("Keliling Persegi Panjang : %.2f\n", p.keliling());
				break;
			case 2 :
				method2();
				break;
			case 3 :
				System.out.println("Thank You for Using!");
				break;
			}
			
		} while (menu != 3);
	}
	
	//method1 sama method 2 sama aja hasilnya, cuman beda metode
	
	public void method1() {		
		//sisi terpendek kalo dijumlahin lebih besar dari sisi terpanjang maka bener 
		//sisi terpendek kalo dijumlahin lebih kecil dari sisi terpanjang maka salah
		double sisiPendek;
		double sisiPanjang;
		
		
		do {
			do {
				System.out.print("Masukkan sisi1 : ");
				s1 = s.nextDouble();
				s.nextLine();
			} while (s1 <= 0);
			do {
				System.out.print("Masukkan sisi2 : ");
				s2 = s.nextDouble();
				s.nextLine();
			} while (s2 <= 0);
			do {
				System.out.print("Masukkan sisi3 : ");
				s3 = s.nextDouble();
				s.nextLine();
			} while (s3 <= 0);
			
			double[] sisi = { s1, s2, s3 };
			Arrays.sort(sisi);
			
			sisiPendek = sisi[0] + sisi[1];
			sisiPanjang = sisi[2];
			if(sisiPendek > sisiPanjang) {
				SegiTiga s = new SegiTiga(s1, s2, s3);
				bid.add(s);
				System.out.println();
				System.out.printf("Luas Segi tiga : %.2f\n", s.luas());
				System.out.printf("Keliling Persegi Panjang : %.2f\n", s.keliling());
			}
		} while (sisiPendek <= sisiPanjang);
	}

	public void method2() {
		double sisiTerpendek, sisiTengah, sisiTerpanjang;
		
		do {
			do {
				System.out.print("Masukkan sisi1 : ");
				s1 = s.nextDouble();
				s.nextLine();
			} while (s1 <= 0);
			do {
				System.out.print("Masukkan sisi2 : ");
				s2 = s.nextDouble();
				s.nextLine();
			} while (s2 <= 0);
			do {
				System.out.print("Masukkan sisi3 : ");
				s3 = s.nextDouble();
				s.nextLine();
			} while (s3 <= 0);
			sisiTerpendek = Math.min(Math.min(s1, s2), s3);
			sisiTerpanjang = Math.max(Math.max(s1, s2), s3);
			sisiTengah = s1 + s2 + s3 - sisiTerpendek - sisiTerpanjang;
			
			if(sisiTengah + sisiTerpendek > sisiTerpanjang) {
				SegiTiga s = new SegiTiga(s1, s2, s3);
				bid.add(s);
				System.out.println();
				System.out.printf("Luas Segi tiga : %.2f\n", s.luas());
				System.out.printf("Keliling Persegi Panjang : %.2f\n", s.keliling());
			}
			
		} while (sisiTengah + sisiTerpendek <= sisiTerpanjang);
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
