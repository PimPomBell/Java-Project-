import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Secyoghurt {
	ArrayList<Yoghurt> yoghurt = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random ran = new Random();
	
	int menu, yprice, random, view, delete, update, random1;
	String yname, yflavour, yid;
	public Secyoghurt() {
		do {
			try {
				menulist();
				menu = s.nextInt();
			} catch (Exception e1) {
				System.out.println("Input must be number!");
			}
			s.nextLine();
			switch (menu) {
			case 1:
				do {
					System.out.print("Create Yoghurt name [more than 1 word] : ");
					yname = s.nextLine();
					if (!yname.contains(" ")) {
						System.out.println("Name must be more than 1 word!");
					}
				} while (!yname.contains(" "));
				do {
					System.out.print("Choose Base Flavour [Original | Peach | Strawberry | Charcoal] : ");
					yflavour = s.nextLine();
					if (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal")) {
						System.out.println("Choose from the base flavour provided!");
					}
				} while (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal") );
				do {
					try {
						System.out.print("Input Price [10000-100000] : ");
						yprice = s.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
					s.nextLine();
				} while (yprice < 10000 || yprice > 100000);
				
				yid = (char)(ran.nextInt(26)+65) + "" +(char)(ran.nextInt(26)+65);
				for (int i = 0; i<3; i++) {
					random = ran.nextInt(9)+0;
					yid = yid + random;
				}
				
				Yoghurt y = new Yoghurt(yid, yname, yflavour, yprice);
				yoghurt.add(y);
				System.out.println("Yoghurt sucessfully added!\n");
				break;
			case 2:
				do {
					try {
						viewlist();
						System.out.println("1. Delete Yoghurt");
						System.out.println("2. Update Yoghurt");
						System.out.println("3. Back to Main Menu");
						System.out.print(">>");
						view = s.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
					s.nextLine();
				
				switch(view) {
				case 1 : 
					try {
						System.out.print("Choose yoghurt to delete [1-" + yoghurt.size() + "] : ");
						delete = s.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
					s.nextLine();
					yoghurt.remove(delete-1);
					System.out.println("Yoghurt succesfully deleted!\n");
					break;
				case 2 :
					try {
						System.out.print("Choose yoghurt to update [1-" + yoghurt.size() + "] : ");
						update = s.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
					s.nextLine();
					do {
						System.out.print("Yoghurt name [more than 1 word] : ");
						yname = s.nextLine();
						if (!yname.contains(" ")) {
							System.out.println("Name must be more than 1 word!");
						}
					} while (!yname.contains(" "));
					do {
						System.out.print("Base Flavour [Original | Peach | Strawberry | Charcoal] : ");
						yflavour = s.nextLine();
						if (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal")) {
							System.out.println("Choose from the base flavour provided!");
						}
					} while (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal") );
					do {
						try {
							System.out.print("Price [10000-100000] : ");
							yprice = s.nextInt();
							if (yprice < 10000 || yprice > 100000) {
								System.out.println("Price must be between 10000-100000");
							}
						} catch (Exception e) {
							System.out.println("Input must be number!");
						}
						s.nextLine();
					} while (yprice < 10000 || yprice > 100000);
					
					yid = (char)(ran.nextInt(26)+65) + "" +(char)(ran.nextInt(26)+65);
					for (int i = 0; i<3; i++) {
						random1 = ran.nextInt(9)+0;
						yid = yid + random1;
					}					
					
					Yoghurt z = new Yoghurt(yid, yname, yflavour, yprice);
					yoghurt.set(update-1, z);
					System.out.println("Yoghurt sucessfully updated!\n");
					break;
				case 3 :
					break;
				}
			}while(view!=3);
				break;
			case 3 :
				System.out.println("Thank you for using!");
				break;
			}
		} while (menu != 3);
	}
	public void menulist() {
		System.out.println("1. Create New Yoghurt Creation");
		System.out.println("2. View Yoghurt list");
		System.out.println("3. Exit");
		System.out.print(">>");
	}
	public void sort() {
		for(int i = 0; i < yoghurt.size(); i++) {
			for(int j = 0; j < yoghurt.size()-1; j++) {
				if (yoghurt.get(j).getName().compareTo(yoghurt.get(j+1).getName())>0) {
				Yoghurt temp = yoghurt.get(j);
				yoghurt.set(j, yoghurt.get(j+1));
				yoghurt.set((j+1), temp);
				}
			}
		}
	}
	public void viewlist() {
		sort();
		System.out.println("--------------------------------------------------------------");
		System.out.println("| No | ID        | Name             | Flavour    | Price     |");
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i<yoghurt.size(); i++) {
			System.out.printf("| %-3s| %-10s| %-17s| %-11s| %-10d|\n",(i+1), yoghurt.get(i).getId(), yoghurt.get(i).getName(), yoghurt.get(i).getFlavour(), yoghurt.get(i).getPrice());
		}
		System.out.println("---------------------------------------------------------------");
	}
	public static void main(String[] args) {
	new Secyoghurt();	
	}
}
