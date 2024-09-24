import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
	ArrayList<Yogurt> yogurt = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	int menu, yprice, view, delete, update, random1;
	int random = 0;
	String yname, yflavour, yid;
	
	public Main() {
		do {
		menulist();
		menu = s.nextInt();
		s.nextLine();
		
		switch(menu) {
		case 1 :
			do {
				System.out.println("Create Yoghurt Name [mosre than 1 word] : ");
				yname = s.nextLine();
				if(!yname.contains(" ")) {
					System.out.println("Name must be more than 1 word");
				}
			} while (!yname.contains(" "));
			
			do {
				System.out.println("Choose Base Flavour [Original | Peach | Strawberry | Charcoal] : ");
				yflavour = s.nextLine();
				if(!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal")) {
					System.out.println("Choose from the base flavour provided!");
				}
			} while (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal"));
			
			do {
				try {
					System.out.println("Input price [10000-100000] : ");
					yprice = s.nextInt();
				} catch (Exception e) {
					System.out.println("Input must be number!\n");
				}
				s.nextLine();
				
				if(yprice < 10000 || yprice > 100000) {
					System.out.println("Price must be between 10000 - 100000!");
				}
			} while (yprice <= 10000 || yprice >= 100000);
			
			yid = (char)(rand.nextInt(26)+65) + "" + (char)(rand.nextInt(26)+65);
			for(int i = 0; i<3;i++) {
				random = rand.nextInt(9)+0;
				yid = yid + random;
			}
		
			Yogurt y = new Yogurt(yid,yname,yflavour,yprice);
			yogurt.add(y);
			System.out.println("Yoghurt succesfully added!");
			break;
		case 2:
			if (yogurt.isEmpty()) {
				System.out.println("There is no Yoghurt creation!");
			}
			else {
			do {
			sort();
			viewlist();
			System.out.println("1. Delete Yoghurt");
			System.out.println("2. Update Yoghurt");
			System.out.println("3. Back to Main Menu");
			System.out.println(">>");
			view = s.nextInt();
			s.nextLine();
			
			switch(view) {
			case 1 :
				viewlist();
				do {
					System.out.println("Choose yoghurt to delete[1-" + yogurt.size() + "] : ");
						delete = s.nextInt();
						s.nextLine();
				} while (delete < 1 || delete > yogurt.size());
				yogurt.remove(delete-1);
				System.out.println("Yoghurt succesfully deleted!");
				break;
			case 2 : 
				viewlist();
				do {
					System.out.println("Choose yoghurt to update[1-" + yogurt.size() + "] : ");
					update = s.nextInt();
					s.nextLine();
				} while (update<1 || update>yogurt.size());
				
				do {
					System.out.println("Yoghurt Name [more than 1 word] : ");
					yname = s.nextLine();
					if (!yname.contains(" ")) {
						System.out.println("Name must be more than 1 word!");
					}
				} while (!yname.contains(" "));
				
				do {
					System.out.println("Base Flavour [Original | Peach | Strawberry | Charcoal] : ");
					yflavour = s.nextLine();
				} while (!yflavour.equals("Original") && !yflavour.equals("Peach") && !yflavour.equals("Strawberry") && !yflavour.equals("Charcoal"));
				
				do {
					System.out.println("Price [10000-1000000] : ");
					yprice = s.nextInt();
					s.nextLine();
					if (yprice < 10000 || yprice >100000) {
						System.out.println("Price must be between 10000 -  100000!");
					}
				} while (yprice <= 10000 || yprice >= 100000);		
				
				yid = (char)(rand.nextInt(90-65+1)+65) + "" + (char)(rand.nextInt(90-65+1)+65);
				for(int i = 0; i<3; i++) {
					random1 = rand.nextInt(9)+0;
					yid = yid + random1;
				}
				Yogurt z = new Yogurt(yid, yname, yflavour, yprice);
				yogurt.set(update-1, z);
				System.out.println("Yoghurt sucessfully updated!");
				break;
			case 3 :
				break;
			}
		}while(view != 3);
	}
		case 3 :
			System.out.println("Thank You for using!");
			break;			
			}
		}while(menu != 3);	
	}

	public void menulist() {
		System.out.println("1. Create New Yoghurt Creation");
		System.out.println("2. View Yoghurt List");
		System.out.println("3. Exit");
		System.out.println(">>");
	}
	
	public void viewlist() {
		sort();
		System.out.println("------------------------------------------------------------");
		System.out.println("| No | ID        | Name             | Flavour   | Price    |");
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i<yogurt.size();i++) {
			System.out.printf("| %-3s| %-10s| %-17s|%-11s|%-10d|\n", (i+1), yogurt.get(i).getId(),yogurt.get(i).getName(),yogurt.get(i).getFlavour(),yogurt.get(i).getPrice());
		}
		System.out.println("------------------------------------------------------------");
	}
	
	public void sort() {
		for(int i = 0; i<yogurt.size();i++) {
			for(int j = 0; i<yogurt.size()-1;j++) {
				if(yogurt.get(j).getName().compareTo(yogurt.get(j+1).getName())>0){
					Yogurt temp = yogurt.get(j);
					yogurt.set(j, yogurt.get(j+1));
					yogurt.set(j+1, temp);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}
