package main;

import java.util.*;

import model.Meat;
import model.Type;
import model.Vege;

public class Main {
	ArrayList<Type> blu = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	int menu, fprice, fqty, ffresh, counter = 1, delete;
	double mweight, mthick, gt, stot;
	String ftype, fname, fid;
	public Main() {
		do {
			System.out.println();
			System.out.println("Bluejack Market");
			System.out.println("===================");
			System.out.println("1. Add Cart");
			System.out.println("2. View Cart(s)");
			System.out.println("3. Delete Cart");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1 : 
				addCart();
				System.out.println("Press enter to continue...");
				s.nextLine();
				break;
			case 2 : 
				if(blu.isEmpty()) {
					System.out.println("No food(s)");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else{
					viewCart();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 3 : 
				if(blu.isEmpty()) {
					System.out.println("No food(s)");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else{
					removeCart();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 4 : 
				System.out.println("Thank you for using the app");
				break;
			}
			
		} while (menu != 4);
	}

	public void addCart() {
		do {
			System.out.print("Select type [Meat | Vegetable](Case sensitive): ");
			ftype = s.nextLine();
		} while (!ftype.equals("Meat") && !ftype.equals("Vegetable"));
		
		do {
			System.out.print("Input Food name [3..18 characters]: ");
			fname = s.nextLine();
		} while (fname.length() < 3 || fname.length() > 18);
		
		do {
			System.out.print("Input Price Per Unit [more than 0 and a multiple of 1000]: ");
			fprice = s.nextInt();
			s.nextLine();
		} while (fprice%1000 != 0);
		
		do {
			System.out.print("Input freshness level [1-5]: ");
			ffresh = s.nextInt();
			s.nextLine();
		} while (ffresh < 1 || ffresh > 5);
		
		fid = String.format("%d", counter);
		counter++;
		
		if(ftype.equals("Meat")) {
			do {
				System.out.print("Input meat weight [more than 0.0]: ");
				mweight = s.nextDouble();
				s.nextLine();
			} while (mweight < 0.0);
			
			do {
				System.out.print("Input meat thickness [more than 0.0]: ");
				mthick = s.nextDouble();
				s.nextLine();
			} while (mthick < 0.0);
			
			System.out.printf("Food with id %s has been sucessfully inserted...\n", fid);
			Meat x = new Meat(fid, ftype, fname, fprice, ffresh, gt, mweight, mthick);
			x.countPrice();
			blu.add(x);
		}
		
		if(ftype.equals("Vegetable")) {
			do {
				System.out.print("Input quantity [more than 0]: ");
				fqty = s.nextInt();
				s.nextLine();
			} while (fqty < 0);
			
			System.out.printf("Food with id %s has been sucessfully inserted...\n", fid);
			Vege y = new Vege(fid, ftype, fname, fprice, ffresh, gt, fqty);
			y.countPrice();
			blu.add(y);
		}
		
	}
	
	public void viewCart() {
		stot = 0;
		System.out.println("Orders");
			for (int i = 0; i < blu.size(); i++) {
				if (blu.get(i) instanceof Meat) {
					Meat m = (Meat)blu.get(i);
					System.out.println("===============================================");
					System.out.printf("ID                : %s\n", m.getId());
					System.out.printf("Type              : %s\n", m.getType());
					System.out.printf("Name              : %s\n", m.getName());
					System.out.printf("Price per Unit    : %d\n", m.getPrice());
					System.out.printf("Freshness level   : %d\n", m.getFresh());
					System.out.printf("Weight            : %.2f\n", m.getWeight());
					System.out.printf("Thickness         : %.2f\n", m.getThickness());
					System.out.printf("Subtotal          : %d\n", (int)m.getGtotal());
					stot += (int)m.getGtotal();
				} 
				else if (blu.get(i) instanceof Vege) {
					Vege v = (Vege)blu.get(i);
					System.out.println("==============================================");
					System.out.printf("ID                : %s\n", v.getId());
					System.out.printf("Type              : %s\n", v.getType());
					System.out.printf("Name              : %s\n", v.getName());
					System.out.printf("Price per Unit    : %d\n", v.getPrice());
					System.out.printf("Freshness level   : %d\n", v.getFresh());
					System.out.printf("Quantity          : %d\n", v.getQty());
					System.out.printf("Subtotal          : %d\n", (int)v.getGtotal());
					stot += (int)v.getGtotal();
				}
			}
					System.out.println("==============================================");
					System.out.printf("Total price       : %d\n", (int)stot);
					System.out.println();
	}
	
	public void removeCart() {
		viewCart();
		System.out.println();
		
		do {
			System.out.printf("Input food no that you want to delete[1-%d]: ", blu.size());
			delete = s.nextInt();
			s.nextLine();
		} while (delete < 1 | delete > blu.size());
		
		System.out.printf("Food with id %s has been successfully deleted...\n", blu.get(delete-1).getId());
		blu.remove(delete-1);
	}

	public static void main(String[] args) {
		new Main();
	}

}
