package main;

import java.util.*;

import model.Type;
import model.Accoustic;
import model.Electric;

public class Main {
	ArrayList<Type> type = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	int menu, menu1, gstring;
	String gmodel, gbrand, gamp, eid, aid, ghyb, delete;
	public Main() {
		do {
			System.out.println("1. Insert Guitar");
			System.out.println("2. View Guitar Catalogue");
			System.out.println("3. Delete Guitar");
			System.out.println("4. Exit");
			System.out.print("Input menu: ");
			menu = s.nextInt();
			s.nextLine();
			
			switch (menu) {
			case 1 : 
				insertGuitar();
				System.out.println("Press enter to continue");
				s.nextLine();
				break;
			case 2 :
				if(type.isEmpty()) {
					System.out.println("There are no guitars in the catalog yet!");
					System.out.println("Press enter to continue");
					s.nextLine();
				}
				else {
					viewGuitar();
					System.out.println("Press enter to continue");
					s.nextLine();
				}
				break;
			case 3 :
				if(type.isEmpty()) {
					System.out.println("There are no guitars in the catalog yet!");
					System.out.println("Press enter to continue");
					s.nextLine();
				}
				else {
					removeGuitar();
					System.out.println("Press enter to continue");
					s.nextLine();
				}
				break;
			case 4 :
				System.out.println("Thank You for Using");
				break;
			}
			
		} while (menu != 4);
		
	}

	public void insertGuitar() {
		System.out.println("Input guitar type: ");
		System.out.println("1. Electric");
		System.out.println("2. Accoustic");
		System.out.println("3. Cancel");
		System.out.print("Input: ");
		menu1 = s.nextInt();
		s.nextLine();
		
		switch (menu1) {
		case 1 :
			eid = "E";
			for(int i = 0; i<3; i++) {
				int num = r.nextInt(10);
				eid += num;
			}
			
			
			do {
				System.out.print("Input model [5-10 Chracters]: ");
				gmodel = s.nextLine();
			} while (gmodel.length() < 5 || gmodel.length() > 10);
			
			do {
				System.out.print("Input Brand [Yamaha | Fender | Cort] [Case Sensitive]: ");
				gbrand = s.nextLine();
			} while (!gbrand.equals("Yamaha") && !gbrand.equals("Fender") && !gbrand.equals("Cort"));
			
			do {
				System.out.print("Input numberOfStrings [6-8]: ");
				gstring = s.nextInt();
				s.nextLine();
			} while (gstring < 6 || gstring > 8 );
			
			do {
				System.out.print("Include Amp? [Yes | No] [Case Insensitive]: ");
				gamp = s.nextLine();
			} while (!gamp.equalsIgnoreCase("Yes") && !gamp.equalsIgnoreCase("No"));
			
			Electric e = new Electric(eid, gmodel, gbrand, gstring, gamp);
			e.countPrice();
			type.add(e);
			
			System.out.println();
			System.out.println("New electric guitar added!");
			break;
		case 2 :
			aid = "A";
			for(int i = 0; i<3; i++) {
				int num = r.nextInt(10);
				aid += num;
			}
			
			
			do {
				System.out.print("Input model [5-10 Chracters]: ");
				gmodel = s.nextLine();
			} while (gmodel.length() < 5 || gmodel.length() > 10);
			
			do {
				System.out.print("Input Brand [Yamaha | Fender | Cort] [Case Sensitive]: ");
				gbrand = s.nextLine();
			} while (!gbrand.equals("Yamaha") && !gbrand.equals("Fender") && !gbrand.equals("Cort"));
			
			do {
				System.out.print("Input numberOfStrings [6-8]: ");
				gstring = s.nextInt();
				s.nextLine();
			} while (gstring < 6 || gstring > 8 );
			
			do {
				System.out.print("Is the guitar Hybrid? [Yes | No] [Case Insensitive]: ");
				ghyb = s.nextLine();
			} while (!ghyb.equalsIgnoreCase("Yes") && !ghyb.equalsIgnoreCase("No"));
			
			Accoustic a = new Accoustic(aid, gmodel, gbrand, gstring, ghyb);
			a.countPrice();
			type.add(a);
			
			System.out.println();
			System.out.println("New accoustic guitar added!");			
			break;
		case 3 :
			break;
		}
	}
	
	public void viewGuitar() {
		int idx = 1;
		System.out.println("+----+--------+--------------+------------+---------+---------+--------+-------+------------+");
		System.out.println("| No | ID     |  Type        | Model      | Brand   | Strings | Hybrid | Amp   | Price      |");
		System.out.println("+----+--------+--------------+------------+---------+---------+--------+-------+------------+");
		for (Type t : type) {
			if(t instanceof Electric) {
				Electric e = (Electric)t;
				System.out.printf("| %-2d | %-6s | Electric     | %-10s | %-7s | %-7d | -      | %-5s | %-10s |\n",idx, e.getId(), e.getModel(), e.getBrand(), e.getString(), e.getAmp(), e.countPrice());
			}
			else if(t instanceof Accoustic) {
				Accoustic a = (Accoustic)t;
				System.out.printf("| %-2d | %-6s | Accoustic    | %-10s | %-7s | %-7d | %-6s | -     | %-10s |\n",idx, a.getId(), a.getModel(), a.getBrand(), a.getString(), a.getHybrid(), a.countPrice());
			}
		idx++;
		}
		System.out.println("+----+--------+--------------+------------+---------+---------+--------+-------+------------+");
	}
	
	public void removeGuitar() {
		viewGuitar();
		//Type temp = null;
		boolean bool = false;
		do {
			System.out.println("Choose ID to delete: ");
			delete = s.nextLine();
			for (Type t : type) {
				if (t.getId().equals(delete)) {
					type.remove(type.indexOf(t));
					bool = true;
					break;
				}
			} 
			if(bool == false) {
				System.out.println("ID not found");
				break;
			}
		} while (bool == false);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
