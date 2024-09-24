package main;
import java.util.*;

import model.Clothes;
import model.Shirt;
import model.Jacket;

public class Main {
	ArrayList<Clothes> clo = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	int menu, menu1, sprice, finprice, jprice, num, index = 0;
	String sname, ssize, jname, jsize, utype, uid, update;
	boolean bool;
	public Main() {
		do {
			System.out.println("UniCloth");
			System.out.println("1. Add new clothes");
			System.out.println("2. Update clothes");
			System.out.println("3. View all clothes");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch (menu) {
			case 1 : 
				System.out.println("What kind of clothes you want to add?");
				System.out.println("=======================================");
				System.out.println("1. Shirt");
				System.out.println("2. Jacket");
				System.out.println("0. Back");
				System.out.print(">> ");
				menu1 = s.nextInt();
				s.nextLine();
				
				switch(menu1) {
				case 1 : 
					do {
						System.out.print("Shirt name [5-20 characters & ends with 'shirt']: ");
						sname = s.nextLine();
					} while (sname.length() < 5 || sname.length() > 20 || !sname.endsWith("shirt"));
					
					do {
						System.out.print("Shirt size [S | M | L | XL](Case Sensitive): ");
						ssize = s.nextLine();
					} while (!ssize.equals("S") && !ssize.equals("M") && !ssize.equals("L") && !ssize.equals("XL"));
					
					do {
						System.out.print("Shirt sleeve type [Short | Long](Case Sensitive): ");
						utype = s.nextLine();
					} while (!utype.equals("Short") && !utype.equals("Long"));
					
					do {
						System.out.print("Shirt price [30000 - 250000]: ");
						sprice = s.nextInt();
						s.nextLine();
					} while (sprice < 30000 || sprice > 250000);
					System.out.println("New shirt added");
					
					uid = "SRT";
					for(int i = 0; i<3; i++) {
						num = r.nextInt(9) + 0;
						uid = uid + num;
					}
					
					
					Shirt x = new Shirt(uid, sname, ssize, utype, sprice, finprice);
					x.countPrice();
					clo.add(x);
					
					System.out.println("Press enter to continue");
					s.nextLine();
					
					break;
				case 2 : 
					do {
						System.out.print("Jacket namen [5-20 characters & ends with 'jacket']: ");
						jname = s.nextLine();
					} while (jname.length() < 5 || jname.length() > 20 || !jname.endsWith("jacket"));
					
					do {
						System.out.print("Jacket size [S | M | L | XL)(Case Sensitive): ");
						jsize = s.nextLine();
					} while (!jsize.equals("S") && !jsize.equals("M") && !jsize.equals("L") && !jsize.equals("XL"));
					
					do {
						System.out.print("Jacket type [Bomber | Hoodie](Case Sensitve): ");
						utype = s.nextLine();
					} while (!utype.equals("Bomber") && !utype.equals("Hoodie"));
					
					do {
						System.out.print("Jacket price [150000 - 500000]: ");
						jprice = s.nextInt();
						s.nextLine();
					} while (jprice < 150000 || jprice > 500000);
					System.out.println("New Jacket added!");
					
					uid = "JCK";
					for(int i = 0; i<3; i++) {
						num = r.nextInt(9) + 0;
						uid = uid + num;
					}
					
					Jacket y = new Jacket(uid, jname, jsize, utype, jprice, finprice);
					y.countPrice();
					clo.add(y);
				
					System.out.println("Press enter to continue");
					s.nextLine();
					break;
				case 3 : 
					break;
				}
				
				break;
			case 2 : 
				if(clo.isEmpty()) {
					System.out.println("Clothes empty!");
					System.out.println();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					updateList();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 3 : 
				if(clo.isEmpty()) {
					System.out.println("Clothes empty!");
					System.out.println();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					viewList();
					System.out.println();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 4 : 
				System.out.println("Thank You!");
				break;
			}
			
			
		} while (menu != 4);
	}

	public void viewList() {
		int idx = 01;
		System.out.println("+=====================================================================+");
		System.out.println("| No | ID     | Name                    | Type    | Size | Price      |");
		for (Clothes clothes : clo) {
		System.out.printf("| %-2s | %-5s | %-23s | %-7s | %-4s | Rp.%-7s |\n", idx, clothes.getId(), clothes.getName(), clothes.getType(), clothes.getSize(), clothes.getFinalPrice());	
		idx++;
		}
		System.out.println("+=====================================================================+");
	}
	
	public void updateList() {
		viewList();
		
		do {
			System.out.println("ID to update [0 to go back]: ");
			update = s.nextLine();
			for (Clothes clothes : clo) {
				if (clothes.getId().equals(update)) {
					clo.set(index, clothes);
					bool = true;
					break;
				}
				else if(update.equals("0")) {
					bool = true;
					break;
				}
				
			} 
		} while (bool == false);
		
		if(update.startsWith("SRT")) {
			do {
				System.out.print("Shirt name [5-20 characters & ends with 'shirt']: ");
				sname = s.nextLine();
			} while (sname.length() < 5 || sname.length() > 20 || !sname.endsWith("shirt"));
			
			do {
				System.out.print("Shirt size [S | M | L | XL](Case Sensitive): ");
				ssize = s.nextLine();
			} while (!ssize.equals("S") && !ssize.equals("M") && !ssize.equals("L") && !ssize.equals("XL"));
			
			do {
				System.out.print("Shirt sleeve type [Short | Long](Case Sensitive): ");
				utype = s.nextLine();
			} while (!utype.equals("Short") && !utype.equals("Long"));
			
			do {
				System.out.print("Shirt price [30000 - 250000]: ");
				sprice = s.nextInt();
				s.nextLine();
			} while (sprice < 30000 || sprice > 250000);
			
			Shirt w = new Shirt(uid, sname, ssize, utype, sprice, finprice);
			w.countPrice();
			clo.set(index, w);
			
			System.out.printf("Shirt %s updated\n", uid);
		}
		else if(update.startsWith("JCK")) {
			do {
				System.out.print("Jacket namen [5-20 characters & ends with 'jacket']: ");
				jname = s.nextLine();
			} while (jname.length() < 5 || jname.length() > 20 || !jname.endsWith("jacket"));
			
			do {
				System.out.print("Jacket size [S | M | L | XL)(Case Sensitive): ");
				jsize = s.nextLine();
			} while (!jsize.equals("S") && !jsize.equals("M") && !jsize.equals("L") && !jsize.equals("XL"));
			
			do {
				System.out.print("Jacket type [Bomber | Hoodie](Case Sensitve): ");
				utype = s.nextLine();
			} while (!utype.equals("Bomber") && !utype.equals("Hoodie"));
			
			do {
				System.out.print("Jacket price [150000 - 500000]: ");
				jprice = s.nextInt();
				s.nextLine();
			} while (jprice < 150000 || jprice > 500000);
			System.out.println("New Jacket added!");
			
			Jacket x = new Jacket(uid, jname, jsize, utype, jprice, finprice);
			x.countPrice();
			clo.set(index, x);
		
			System.out.printf("Jacket %s updated\n", uid);	
		}
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
