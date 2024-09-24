package main;

import java.util.*;

import model.Food;
import model.NonVege;
import model.Vege;

public class Main {
	ArrayList<Food> food = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	int menu, bprice, priceCounter, idCounter = 1, idx = 1, idx2 = 1, num, qty;
	String name, mdish, mtype, vege, nonvege, meat, fid;
	
	public Main() {
		do {
			System.out.println();
			System.out.println("Five Food Street");
			System.out.println("================");
			System.out.println("1. Insert New Menu");
			System.out.println("2. View All Menu");
			System.out.println("3. Sell Menu Item");
			System.out.println("4. Exit");
			System.out.print(">>> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1 : 
				insertMenu();
				break;
			case 2 :
				if(food.isEmpty()) {
					System.out.println("No menu available");
				}
				else {
					viewAllMenu();
				}
				break; 
			case 3 : 
				if(food.isEmpty()) {
					System.out.println("No menu available");
				}
				else {
					sellMenu();
				}
				break;
			case 4 :
				System.out.println("Thank You for Using this App");
				break;
			}
			
		} while (menu != 4);
	}
	
	public void insertMenu() {
		do {
			System.out.print("Input menu name [8-20]: ");
			name = s.nextLine();
		} while (name.length() < 8 || name.length() > 20);
		
		do {
			System.out.print("Input main dish [Rice | Noodle][Case Insensitive]: ");
			mdish = s.nextLine();
		} while (!mdish.equalsIgnoreCase("Rice") && !mdish.equalsIgnoreCase("Noodle"));
		
//		if(mdish.equalsIgnoreCase("Rice")) {
//			bprice = 5000;
//		}
//		else if(mdish.equalsIgnoreCase("Noodle")) {
//			bprice = 3000;
//		}
	
		do {
			System.out.print("Input menu type [Vege | Non-Vege][Case Sensitive]: ");
			mtype = s.nextLine();
		} while (!mtype.equals("Vege") && !mtype.equals("Non-Vege"));
		
		do {
			System.out.print("Input base Price [5000 - 25000][Multiple of 1000]: ");
			bprice = s.nextInt();
			s.nextLine();
		} while (bprice%1000 != 0);
		
		fid = generateId();
		
		if(mtype.equals("Vege")) {
			do {
				System.out.print("Input Vegetable [Potato | Tomato][Case Insensitive]: ");
				vege = s.nextLine();
			} while (!vege.equalsIgnoreCase("Potato") && !vege.equalsIgnoreCase("Tomato") );
			System.out.println("Vege food added successfully");
			
			Vege y = new Vege(fid, name, priceCounter, mtype, mdish, bprice, vege);
			y.countPrice();
			food.add(y);
		}

		else if(mtype.equals("Non-Vege")) {
			do {
				System.out.print("Input Meat [Beef | Chicken | Pork][Case Sensitive]: ");
				meat = s.nextLine();
			} while (!meat.equals("Beef") && !meat.equals("Chicken") && !meat.equals("Pork"));
			do {
				System.out.print("Input addOns [Meatballs | Fishballs | Fried Potato][Case Insensitive]: ");
				nonvege = s.nextLine();
			} while (!nonvege.equalsIgnoreCase("Meatballs") && !nonvege.equalsIgnoreCase("Fishballs") &&  !nonvege.equalsIgnoreCase("Fried Potato"));
			System.out.println("Non Vege food added successfully");
			 
			NonVege x = new NonVege(fid, name, priceCounter, mtype, mdish, bprice, meat, nonvege);
			x.countPrice();
			food.add(x);
		}
		
//		if(nonvege.equals("Beef")) {
//			priceCounter += name.length()*2500;
//		}
//		if(nonvege.equals("Chicken")) {
//			priceCounter += name.length()*1000;
//		}
//		if(nonvege.equals("Pork")) {
//			priceCounter += name.length()*2000;
//		}
//		
//		if(nonvege.equalsIgnoreCase("Meatballs")) {
//			priceCounter += 4000;
//		}
//		if(nonvege.equalsIgnoreCase("Fishballs")) {   
//			priceCounter += 3000;
//		}
//		if(nonvege.equalsIgnoreCase("Fried Potato")) {
//			priceCounter += 5000;
//		}
//		priceCounter += bprice;

	}
		
	public String generateId() {
		String formattedNumber = String.format("%03d", idCounter);
		fid = "VV" + formattedNumber;
		idCounter++;
		return fid;
	}
	
	public void viewAllMenu() {
		System.out.println("===============================================================");
		System.out.println("| No   | ID    | Name                  | Price     | Type     |");
		System.out.println("===============================================================");
		for (Food food2 : food) {
			if (food2 instanceof Vege) {
				System.out.printf("| %-4d | %-5s | %-21s | %-9d | %-8s |\n", idx, food2.getId(), food2.getName(), food2.getPrice(), food2.getType());
			}
			else if(food2 instanceof NonVege) {
				System.out.printf("| %-4d | %-5s | %-21s | %-9d | %-8s |\n", idx, food2.getId(), food2.getName(), food2.getPrice(), food2.getType());
			}
			idx++;
		}
		System.out.println("===============================================================");
	}
	
	public void sellMenu() {
		viewAllMenu();
		do {
			System.out.printf("Input number [1 - %d]: ", food.size());
			num = s.nextInt();
			s.nextLine();
		} while (num < 1 || num > food.size());
		
		do {
			System.out.print("Input quantity : ");
			qty = s.nextInt();
			s.nextLine();
		} while (qty < 0);
		
		int gtot = food.get(num-1).getPrice()*qty;
		
		System.out.println();
		System.out.println();
		System.out.printf("ID : %s\n", food.get(num-1).getId());
		System.out.printf("Menu Name : %s\n", food.get(num-1).getName());
		System.out.printf("Main dish : %s\n", food.get(num-1).getMainDish());
		System.out.printf("Price : %d\n", food.get(num-1).getPrice());
		System.out.printf("Grand total : %d\n", gtot);
		
		food.remove(num-1);
	}
	

	public static void main(String[] args) {
		new Main();
	}

}
