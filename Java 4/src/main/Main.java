package main;
import java.util.*;

import model.Plane;
import model.Economy;
import model.Business;

public class Main {
	ArrayList<Plane> pln = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	int menu, menu1, pcost, bagcost, totcost, idCounter = 1, delete;
	String pname, pdestination, pdeparture, fid, loType;
	public Main() {
		do {
			System.out.println("JetStar Flights");
			System.out.println("=====================");
			System.out.println("1. Add flight");
			System.out.println("2. View all flights");
			System.out.println("3. Delete flight");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1 : 
				System.out.println("Choose type of the flights : ");
				System.out.println("1. Economy Class");
				System.out.println("2. Business Class");
				System.out.println("3. Back");
				System.out.print(">> ");
				menu1 = s.nextInt();
				s.nextLine();
				switch (menu1) {
				case 1 : 	
					do {
						System.out.print("Flight name [ends with 'Airlines'] : ");
						pname = s.nextLine();
					} while (!pname.endsWith("Airlines"));
					
					do {
						System.out.print("Flight destination [5-25 characters] : ");
						pdestination = s.nextLine();
					} while (pdestination.length() < 5 || pname.length() > 25);
					
					do {
						System.out.print("Flight departure place [cannot same with flight destination] : ");
						pdeparture = s.nextLine();
					} while (pdeparture.equals(pdestination));
					
					
					do {
						System.out.print("Input cost [more than 0] : ");
						pcost = s.nextInt();
						s.nextLine();
					} while (pcost < 0);
			
					
					do {
						System.out.print("Input baggage cost [more than 0] : ");
						bagcost = s.nextInt();
						s.nextLine();
					} while (bagcost < 0);
									
					fid = generateId();
					
					Economy y = new Economy(fid, pname, pdestination, pdeparture, pcost, totcost, bagcost);
					y.countPrice();
					pln.add(y);	
					
					System.out.println("Flight has been successfully added! [press enter]");
					s.nextLine();
					break;
				case 2 : 
					do {
						System.out.print("Flight name [ends with 'Airlines'] : ");
						pname = s.nextLine();
					} while (!pname.endsWith("Airlines"));
					
					do {
						System.out.print("Flight destination [5-25 characters] : ");
						pdestination = s.nextLine();
					} while (pdestination.length() < 5 || pname.length() > 25);
					
					do {
						System.out.print("Flight departure place [cannot same with flight destination] : ");
						pdeparture = s.nextLine();
					} while (pdeparture.equals(pdestination));
					
					
					do {
						System.out.print("Input cost [more than 0] : ");
						pcost = s.nextInt();
						s.nextLine();
					} while (pcost < 0);
					
					fid = generateId();
					
					do {
						System.out.print("Input lounge type [bar | buffet | restaurant] (Case Sensitive): ");
						loType = s.nextLine();
					} while (!loType.equals("bar") && !loType.equals("buffet") && !loType.equals("restaurant"));
				
					
					Business z = new Business(fid, pname, pdestination, pdeparture, pcost, totcost, loType);
					z.countPrice();
					pln.add(z);
					
					System.out.println("Flight has been successfully added! [press enter]");
					s.nextLine();
				
					break;
				case 3 : 
					break;
				}
				
				break;
			case 2 : 
				if(pln.isEmpty()) {
					System.out.println("There's no flights right now");
					System.out.println("Wanna go back? [press enter]");
					s.nextLine();
				}
				else {
					viewList();
					System.out.println("Wanna go back? [press enter]");
					s.nextLine();
					
				}
				break;
			case 3 :
				if(pln.isEmpty()) {
					System.out.println("There's no flights right now");
					System.out.println("Wanna go back? [press enter]");
					s.nextLine();
				}
				else {
					removeList();
					s.nextLine();
				}
				break;
			case 4 : 
				System.out.println("Thankyou for using the program");
				break;
			}
			
		} while (menu != 4);
	}
	
	public void removeList() {
		viewList();
		do {
			System.out.printf("Put input Flight Number to delete [1-%d] : ", pln.size());
			delete = s.nextInt();
			s.nextLine();
			if(delete == 0) {
				break;
			}
		} while (delete < 1 | delete > pln.size());
		
		
		System.out.printf("Succesfully deleted %s [press enter]", pln.get(delete-1).getName());
		pln.remove(delete-1);
	}
	
	
	public void viewList() {
		int idx = 1;
		for (Plane plane : pln) {
			if(plane instanceof Economy) {
				Economy m = (Economy)plane;
				System.out.printf("No : %d\n", idx);
				System.out.printf("ID : %s\n", m.getId());
				System.out.printf("Name : %s\n", m.getName());
				System.out.printf("Total cost :%d\n",m.getTotal());
				System.out.printf("Destination: %s\n", m.getDestination());
				System.out.printf("Departure : %s\n", m.getDeparture());
				System.out.printf("Baggage cost : %d\n", m.getBaggageCost());
				System.out.println("Lounge : -\n");
				System.out.println();
			}
			else if (plane instanceof Business) {
				Business u = (Business)plane;
				System.out.printf("No : %d\n", idx);
				System.out.printf("ID : %s\n", u.getId());
				System.out.printf("Name : %s\n", u.getName());
				System.out.printf("Total cost :%d\n",u.getTotal());
				System.out.printf("Destination: %s\n", u.getDestination());
				System.out.printf("Departure : %s\n", u.getDeparture());
				System.out.printf("Baggage cost : - \n");
				System.out.printf("Lounge : %s\n", u.getLoungeType());
				System.out.println();
			}
			idx++;
		}
		
	}
	
	public String generateId() {
		String x = String.format("%03d", idCounter);
		fid = "FL" + x;
		idCounter++;
		return x;
	}

	public static void main(String[] args) {
		new Main();
	}

}
