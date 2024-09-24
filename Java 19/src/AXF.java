import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AXF {
	ArrayList<AXFPat> axf = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	
	String name, gender, email, fire, w;
	int menu, random;
	boolean bool;
	
	public AXF() {
	do {
		System.out.println("1 - Register new worker");
		System.out.println("2 - View all worker");
		System.out.println("3 - Fire worker");
		System.out.println("4 - Exit");
		System.out.println(">>");
		menu = s.nextInt();
		s.nextLine();
		
		switch (menu) {
		case 1 :
			do {
				System.out.print("Input worker name [5..20]: ");
				name = s.nextLine();
			} while (name.length()<5 || name.length()>20);
			
			do {
				System.out.print("Input worker gender [Male | Female] (case sensitive): ");
				gender = s.nextLine();
			} while (!gender.equals("Male") && !gender.equals("Female"));
			
			do {
				System.out.print("Input email (must contains @ and ends with .com): ");
				email = s.nextLine();
			} while (!email.contains("@") || !email.endsWith(".com"));
			
			w = "W" + "R";
			for(int i = 0; i<3; i++) {
				random = rand.nextInt(9)+0;
				w = w + random;
			}
			
			
			AXFPat z = new AXFPat(name, gender, email, w);
			axf.add(z);
			System.out.println("Successfully hired worker...");
			System.out.println("Press Enter to Continue...");
			s.nextLine();
			break;
		case 2 :
			if (axf.isEmpty()) {
				System.out.println("There are no worker yet...");
				System.out.println("Press enter to Continue...");
				s.nextLine();
			}
			else {
				sort();
				viewlist();
				System.out.println("Press Enter to Continue...");
				s.nextLine();
			}
			break;
		case 3 :
			if (axf.isEmpty()) {
				System.out.println("There are no worker yet...");
				System.out.println("Press enter to Continue...");
				s.nextLine();
			}
			else {
				sort();
				viewlist();
	
				do {
					System.out.print("Input worker ID [back to back] (case sensitive): ");
					fire = s.nextLine();
					for (int i = 0; i < axf.size(); i++) {
						if (axf.get(i).getId().equals(fire)) {
							axf.remove(i);
							bool = true;
							break;
						}
						else {
							System.out.println("Input the correct id");
						}
					}
				} while (bool == false);
				
				System.out.println("Successfully fired worker...");
				System.out.println("Press Enter to Continue...");
				s.nextLine();
			}
			break;
		case 4 :
			System.out.println("Thank youo for using this program.");
			break;
		}
	} while (menu != 4);	
	}
	public void viewlist() {
			
			for(int i = 0; i<axf.size(); i++) {
				System.out.println("No          : " + (i+1));	
				System.out.println("ID          : " + axf.get(i).getId());
				System.out.println("Name        : " + axf.get(i).getName());
				System.out.println("Gender      : " + axf.get(i).getGender());
				System.out.println("Email       : " + axf.get(i).getEmail());
				System.out.println();
				System.out.println();
		}
	}
	
	public void sort() {
		for(int i = 0; i<axf.size(); i++) {
			for(int j = 0; j<axf.size()-1; j++) {
				if(axf.get(j).getId().compareTo(axf.get(j+1).getId()) > 0 ) {
					AXFPat temp = axf.get(j);
					axf.set(j, axf.get(j+1));
					axf.set(j+1, temp);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		new AXF();
	}
}
