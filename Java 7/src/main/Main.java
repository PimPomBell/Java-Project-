package main;
import java.util.*;

import model.Status;
import model.VIP;
import model.Regular;


public class Main {
	ArrayList<Status> stat = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	boolean bool;
	int menu, queue1 = 0, queue2, point1 = 0, point2 = 0, index;
	String vid, lid, rid, sname, sgender, sphone, stype, vemail, watch;
	public Main() {
		do {
			System.out.println("JtheateR");
			System.out.println("========");
			System.out.println("1. Add new member");
			System.out.println("2. View all members");
			System.out.println("3. Watch a movie");
			System.out.println("0. exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
	
			switch (menu) {
			case 1 : 
				addMember();
				System.out.println("Press enter to continue");
				s.nextLine();
				break;
			case 2 : 
				if(stat.isEmpty()) {
					System.out.println("Currently, there are no member...");
					s.nextLine();
				}
				else {
				viewMember();
				System.out.println("Press enter to continue");
				s.nextLine();
				}
				break;
			case 3 : 
				if(stat.isEmpty()) {
					System.out.println("Currently, there are no member...");
					s.nextLine();
				}
				else {
				watchMovie();
				System.out.println("Press enter to continue");
				s.nextLine();
				}
				break;
			}
			
			if(menu == 0) {
				System.out.println("Thank you for using!");
				break;
			}
		} while (menu != 0);
		
	}

	public void addMember() {
	
		do {
			System.out.print("Input your name [5 - 12 characters]: ");
			sname = s.nextLine();
		} while (sname.length() < 5 || sname.length() > 12);
		
		do {
			System.out.print("Input your gender [Male / Female](Case Sensitive): ");
			sgender = s.nextLine();
		} while (!sgender.equals("Male") && !sgender.equals("Female"));
		
		do {
			System.out.print("Input your phone number [must be 12 characters and numeric]: ");
			sphone = s.nextLine();
		} while (!sphone.matches("\\d{12}"));
		
		do {
			System.out.print("Input your status [VIP / Regular](Case Sensitive): ");
			stype = s.nextLine();
		} while (!stype.equals("VIP") && !stype.equals("Regular"));
		
		if(stype.equals("VIP")) {
			vid = "V";
			for(int i = 0; i<5; i++) {
				int num = r.nextInt(10);
				vid = vid + num;
			}
			
			lid = "lounge";
			for(int i = 0; i<3; i++) {
				int num1 = r.nextInt(4);
				lid = lid + num1;
			} 
			
			do {
				System.out.print("Input your email [Must ends with '@gmail.com']: ");
				vemail = s.nextLine();
			} while (!vemail.endsWith("@gmail.com"));
			
			
			VIP x = new VIP(vid, sname, sgender, sphone, point1, lid, vemail);
			stat.add(x);
			System.out.println("A new member has been added");
			
			}
		else if(stype.equals("Regular")) {
			rid = "R";
			for(int i = 0; i<5; i++) {
				int num = r.nextInt(10);
				rid = rid + num;
			}
			
			queue2 = r.nextInt(6);
			
			Regular x = new Regular(rid, sname, sgender, sphone, point2, queue2);
			stat.add(x);
			
			System.out.println("A new member has been added");
		}
		
	}
	
	public void viewMember() {
		int idx =1;
		for (Status stats : stat) {
			if(stats instanceof VIP) {
				VIP x = (VIP)stats;
				System.out.printf("No : %d\n", idx);
				System.out.printf("Name : %s\n", x.getName());
				System.out.printf("Gender : %s\n", x.getGender());
				System.out.printf("Phone Number : %s\n", x.getPhone());
				System.out.printf("Status : VIP\n");
				System.out.printf("ID : %s\n", x.getId());
				System.out.printf("Points : %d\n", point1);
				System.out.printf("Email : %s\n", x.getEmail());
				System.out.printf("Lounge : %s\n", x.getLoungeId());
				System.out.printf("Queue : 0\n");
				System.out.println();
			}
			else if(stats instanceof Regular) {
				Regular y = (Regular)stats;
				System.out.printf("No : %d\n", idx);
				System.out.printf("Name : %s\n", y.getName());
				System.out.printf("Gender : %s\n", y.getGender());
				System.out.printf("Phone Number : %s\n", y.getPhone());
				System.out.printf("Status : Regular\n");
				System.out.printf("ID : %s\n", y.getId());
				System.out.printf("Points : %d\n", point2);
				System.out.printf("Email : -\n");
				System.out.printf("Lounge : -\n");
				System.out.printf("Queue : %d\n", y.getQueue());
				System.out.println();
			}
		idx++;
		}
		
	}
	public void watchMovie() {
	    viewMember();
	    do {
	        System.out.print("Input your ID : ");
	        watch = s.nextLine();
	        bool = false;
	        Status memberToWatch = null;

	        for (Status status : stat) {
	            if (status.getId().equals(watch)) {
	                memberToWatch = status;
	                bool = true;
	                break;
	            }
	        }

	        if (bool == true) {
	            if (memberToWatch instanceof VIP) {
	                VIP vipMember = (VIP) memberToWatch;
	                point1 += vipMember.countPoint();
	                System.out.println("Points added for VIP member.");
	            } else if (memberToWatch instanceof Regular) {
	                Regular regularMember = (Regular) memberToWatch;
	                point2 += regularMember.countPoint();
	                System.out.println("Points added for Regular member.");
	            }
	        } else {
	            System.out.println("There are no members with that ID.");
	            break;
	        }
	    } while (!bool);
	}

//		buat remove
//		Status temp = null;
//		do {
//			bool = false;
//			System.out.println("Input your ID : ");
//			watch = s.nextLine();
//			for (Status status : stat) {
//				if (status.getId().equals(watch)) {
//				    temp = status;
//					bool = true;
//					break;
//				}
//			} 
//			if(bool == false){
//			     System.out.println("There are no member with that ID");
//			}
//		} while (bool == false);
//		
//		stat.remove(stat.indexOf(temp));
		
		
	
	public static void main(String[] args) {
		new Main();
	}

}
