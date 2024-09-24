package main;
import java.util.*;

import model.Food;
import model.Meat;
import model.Vege;

public class Main {
	ArrayList<Food> food = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	int menu, fprice, ffresh, count = 1, fqty;
	String ftype, fname, mid, vid, delete;
	double mweight, mthick;
	public Main() {
		do {
			System.out.println("Bluejack Market");
			System.out.println("==================");
			System.out.println("1. Add Cart");
			System.out.println("2. View Cart(s)");
			System.out.println("3. Delete Cart");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch (menu) {
			case 1 : 
				addCart();
				System.out.println("Press enter to continue...");
				s.nextLine();
				break;
			case 2 :
				if(food.isEmpty()) {
					System.out.println("No food(s)");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					viewCart();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 3 :
				if(food.isEmpty()) {
					System.out.println("No food(s)");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					deleteCart();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 4 :
				
				break;
			}
			
		} while (menu != 4);
	}

	public void deleteCart() {
		viewCart();
		boolean bool = false;
		do {
			System.out.print("Input food ID to delete : ");
			delete = s.nextLine();
			for (Food fud : food) {
				if (fud.getId().equals(delete)) {
					food.remove(food.indexOf(fud));
					bool = true;
					break;
				}
			}
			if (bool == false) {
				System.out.println("There is no food with that ID!");
				break;
			} 
		} while (bool == false);
	}
	
	
	public void viewCart() {
		double tot = 0;
		System.out.println("Orders");
		for (Food f : food) {
			if(f instanceof Meat) {
				Meat m = (Meat)f;
				System.out.println("===========================================");
				System.out.printf("ID                  : %s\n", m.getId());
				System.out.printf("Type                : Meat\n");
				System.out.printf("Name                : %s\n", m.getName());
				System.out.printf("Price per Unit      : %d\n", m.getPrice());
				System.out.printf("Freshness level     : %d\n", m.getFreshness());
				System.out.printf("Weight              : %.2f\n", m.getWeight());
				System.out.printf("Thickness           : %.2f\n", m.getThickness());
				System.out.printf("Subtotal            : %d\n", (int)m.countPrice());
				System.out.println("===========================================");
				tot += m.countPrice();
			}
			else if(f instanceof Vege) {
				Vege v = (Vege)f;
				System.out.println("===========================================");
				System.out.printf("ID                  : %s\n", v.getId());
				System.out.printf("Type                : Vegetable\n");
				System.out.printf("Name                : %s\n", v.getName());
				System.out.printf("Price per Unit      : %d\n", v.getPrice());
				System.out.printf("Freshness level     : %d\n", v.getFreshness());
				System.out.printf("Quantity            : %d\n", v.getQuantity());
				System.out.printf("Subtotal            : %d\n", (int)v.countPrice());
				System.out.println("===========================================");
				tot += v.countPrice();
			}
		}
				System.out.printf("Total Price          : %d\n", (int)tot);
	}
	
	public void addCart() {
		do {
			System.out.print("Select type [ Meat | Vegetable ](Case Sensitive): ");
			ftype = s.nextLine();
		} while (!ftype.equals("Meat") && !ftype.equals("Vegetable"));
		
		do {
			System.out.print("Input Food Name [ 3..18 characters ]: ");
			fname = s.nextLine();
		} while (fname.length() < 3 || fname.length() > 18);
		
		do {
			System.out.print("Input Price Per Unit [ more than 0 and a multiple of 1000 ]: ");
			fprice = s.nextInt();
			s.nextLine();
		} while (fprice <= 0 || fprice%1000 != 0);
		
		do {
			System.out.print("Input freshness level [ 1..5 ]: ");
			ffresh = s.nextInt();
			s.nextLine();
		} while (ffresh < 1 || ffresh > 5);
		
		if(ftype.equals("Meat")) {
			mid = "MM" + String.format("%03d", count);
			count++;
			
			do {
				System.out.print("Input meat weight [ more than 0.0 ]: ");
				mweight = s.nextDouble();
				s.nextLine();
			} while (mweight <= 0.0);
			
			do {
				System.out.print("Input meat thickness [ more than 0.0 ]: ");
				mthick = s.nextDouble();
				s.nextLine();
			} while (mthick <= 0.0);
			
			Meat m = new Meat(mid, fname, fprice, ffresh, mweight, mthick);
			m.countPrice();
			food.add(m);
			
			System.out.println();
			System.out.printf("Food with id %s has been successfully inserted...\n", mid);
		}
		else if(ftype.equals("Vegetable")) {
			vid = "VV" + String.format("%03d", count);
			count++;
			
			do {
				System.out.print("Input quantity [ more than 0 ]: ");
				fqty = s.nextInt();
				s.nextLine();
			} while (fqty <= 0);
			
			Vege v = new Vege(vid, fname, fprice, ffresh, fqty);
			v.countPrice();
			food.add(v);
			
			System.out.println();
			System.out.printf("Food with id %s has been successfully inserted...\n", vid);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
