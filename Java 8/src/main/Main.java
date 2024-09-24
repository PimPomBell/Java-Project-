package main;
import java.util.*;

import model.Designer;
import model.Gaming;
import model.Monitor;

public class Main {
	ArrayList<Monitor> mon = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	int menu, msize, refrate;
	double mweight, daccuracy;
	boolean bool;
	String mbrand, mname, mtype, did, gid, delete;
	public Main() {
		do {
			System.out.println("+======================+");
			System.out.println("|       FAnitor        |");
			System.out.println("+======================+");
			System.out.println("|1. Insert Monitor     |");
			System.out.println("|2. View Monitor       |");
			System.out.println("|3. Delete Monitor     |");
			System.out.println("|4. Exit               |");
			System.out.println("+======================+");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch (menu) {
			case 1 : 
				addMonitor();
				break;
			case 2 : 
				if(mon.isEmpty()) {
					System.out.println("There are no monitors yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					viewMonitor();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 3 : 
				if(mon.isEmpty()) {
					System.out.println("There are no monitors yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				else {
					removeMonitor();
					System.out.println("Press enter to continue...");
					s.nextLine();
				}
				break;
			case 4 : 
				System.out.println("Thank You for using");
				break;
			}
			
		} while (menu != 4);
		
	}
	
	public void addMonitor() {
		
		do {
			System.out.print("Insert monitor brand [AOC | LG | ASUS] [Case Sensitive]: ");
			mbrand = s.nextLine();
		} while (!mbrand.equals("AOC") && !mbrand.equals("LG") && !mbrand.equals("ASUS"));
		
		do {
			System.out.print("Insert Monitor Name [minimum 5 characters]: ");
			mname = s.nextLine();
		} while (mname.length() < 5);
		
		do {
			System.out.print("Input Monitor Size [20 - 30 inch]");
			msize = s.nextInt();
			s.nextLine();
		} while (msize < 20 || msize > 30);
		
		do {
			System.out.print("Input Monitor Weight [1.5 - 3.0 kg]: ");
			mweight = s.nextDouble();
			s.nextLine();
		} while (mweight < 1.5 || mweight > 3.0);
		
		do {
			System.out.print("Input Monitor Type [Designer | Gaming] [Case Sensitive]: ");
			mtype = s.nextLine();
		} while (!mtype.equals("Designer") && !mtype.equals("Gaming"));
		
		if(mtype.equals("Designer")) {
			do {
				System.out.print("Input Color Accuracy [0.0 - 2.0]: ");
				daccuracy = s.nextDouble();
				s.nextLine();
			} while (daccuracy < 0.0 || daccuracy > 2.0);
			
			did = "D";
			for(int i = 0; i<3; i++){
				int num = r.nextInt(9)+1;
				did  += num;
			}
			
			Designer d = new Designer(did, mbrand, mname, msize, mweight, daccuracy);
			d.countPrice();
			mon.add(d);
	
		}
		else if (mtype.equals("Gaming")){
			
			do {
				System.out.print("Input Refresh Rate [120 | 144 | 240]: ");
				refrate = s.nextInt();
				s.nextLine();
			} while (refrate != 120 && refrate != 144 && refrate != 240);
			
			gid = "G";
			for(int i = 0; i<3; i++){
				int num = r.nextInt(9)+1;
				gid  += num;
			}	
			
			Gaming g = new Gaming(gid, mbrand, mname, msize, mweight, refrate);
			g.countPrice();
			mon.add(g);
		}
	}
	
	public void viewMonitor() {
		int idx = 1;
		for (Monitor mo : mon) {
			if(mo instanceof Designer) {
				Designer x = (Designer)mo;
				System.out.printf("No : %d\n", idx);
				System.out.printf("ID : %s\n", x.getId());
				System.out.printf("Type : Designer\n");
				System.out.printf("Brand : %s\n", x.getBrand() );
				System.out.printf("Name : %s\n", x.getName());
				System.out.printf("Size : %d\n", x.getSize());
				System.out.printf("Weight : %f\n", x.getWeight());
				System.out.printf("Color Accuracy : %f\n", x.getAccuracy());
				System.out.printf("Refresh Rate : -\n");
				System.out.printf("Price : %d\n", x.countPrice());
				System.out.println();
			}
			else if(mo instanceof Gaming) {
				Gaming x = (Gaming)mo;
				System.out.printf("No : %d\n", idx);
				System.out.printf("ID : %s\n", x.getId());
				System.out.printf("Type : Gaming\n");
				System.out.printf("Brand : %s\n", x.getBrand() );
				System.out.printf("Name : %s\n", x.getName());
				System.out.printf("Size : %d\n", x.getSize());
				System.out.printf("Weight : %.2f\n", x.getWeight());
				System.out.printf("Color Accuracy : -\n");
				System.out.printf("Refresh Rate : %d\n", x.getRefresh());
				System.out.printf("Price : %d\n", x.countPrice());
				System.out.println();
			}
		idx++;
		}
	}
	
	public void removeMonitor() {
		viewMonitor();
		Monitor temp = null;
		do {
			bool = false;
			System.out.println("Input the ID to delete : ");
			delete = s.nextLine();
			for (Monitor monitor : mon) {
				if(monitor.getId().equals(delete)) {
					temp = monitor;
					mon.remove(mon.indexOf(temp));
					bool = true;
					break;
				}
			} 
			if(bool == false) {
				System.out.println("ID doesn't exixts");
				break;
			}			
		} while (bool == false);
		
		
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
