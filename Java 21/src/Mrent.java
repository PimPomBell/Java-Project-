import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mrent {
	ArrayList<Movie> mo = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	
	int menu, rating, random, add, price, index, money;
	String title, genre, id;
	public Mrent() {
		do {
			try {
				menu();
				menu = s.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be number!");
			}
			s.nextLine();
			switch (menu) {
			case 1:
				do {
					System.out.print("Input Movie Title [Length Must be 3 - 20 chars]           :");
					title = s.nextLine();
				} while (title.length()<3 || title.length()>20);
				
				do {
					System.out.print("Input Movie genre[Horror | Comedy | Action]               :");
					genre = s.nextLine();
				} while (!genre.equals("Horror") && !genre.equals("Comedy") && !genre.equals("Action"));
				
				do {
					System.out.print("Input Movie Rating[1-10]                                  :");
					rating = s.nextInt();
					s.nextLine();
				} while (rating < 1 || rating >10);
				
				id = (char)(rand.nextInt(26)+65) + "" + (char)(rand.nextInt(26)+65) ;
				for(int i = 0; i<3; i++) {
					random = rand.nextInt(9)+0;
					id = id + random;
				}
				
					System.out.print("Generated MovieID                                         :" + id);
				
				if (genre.equals("Comedy")) {
					add = 3000;
				}
				if (genre.equals("Action")) {
					add = 4000;
				}
				if (genre.equals("Horror")) {
					add = 5000;
				}
				
				price = (title.length()*500) + add;
				
				Movie x = new Movie(title, genre, rating, id, price);
				mo.add(x);
				
				System.out.println();
				System.out.println("Insert Success!");
				System.out.println();
				break;
			case 2:
				if (mo.isEmpty()) {
					System.out.println("NO MOVIE FOUND\n");
				}
				else {
				view();
				System.out.println();
				}
				break;
			case 3:
				if (mo.isEmpty()) {
					System.out.println("NO MOVIE FOUND\n");
				}
				else{
					view();
					do {
						try {
							System.out.println("Choose Movie index [1-" + mo.size() + "]:");
							index = s.nextInt();
						} catch (Exception e) {
							System.out.println("Input Must be Numeric");
						}
						s.nextLine();
					} while (index > mo.size() || index < 0);
					
					do {
						try {
							System.out.println("Input Money to Rent [Min " + mo.get(index - 1).getPrice() + "]:");
							money = s.nextInt();
						} catch (Exception e) {
							System.out.println("Input must be number!");
						}
						s.nextLine();
					} while (money < mo.get(index - 1).getPrice());
					
					System.out.println("Pay Rent Succesful with " + (money - price) + " Change" );
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Thank you for using the app!");
				break;
			}
		} while (menu != 4);
	}
	public void menu() {
		System.out.println("==============");
		System.out.println(" MOVIE RENTAL ");
		System.out.println("==============");
		System.out.println("1. Add new Movie");
		System.out.println("2. View Movie (Sort by Title Ascending)");
		System.out.println("3. Rent Movie");
		System.out.println("4. EXIT");
		System.out.println(">>");
	}
	public void view() {
			sort();
			System.out.println("======================================================================");
			System.out.println("| NO   | ID      | Title               | Genre   | Rating | Price    |");
			System.out.println("======================================================================");
		for (int i = 0; i<mo.size(); i++) {
			System.out.printf("| %-5s| %-8s| %-20s| %-8s| %-7d| %-9s|\n", (i+1), mo.get(i).getId(), mo.get(i).getTitle(), mo.get(i).getGenre(), mo.get(i).getRating(), mo.get(i).getPrice() );
		}
			System.out.println("======================================================================");
			System.out.println();
	}
	public void sort() {
		for(int i = 0; i<mo.size(); i++) {
			for(int j = 0; j<mo.size()-1; j++) {
				if(mo.get(j).getTitle().compareTo(mo.get(j+1).getTitle())>0) {
					Movie temp = mo.get(j);
					mo.set(j, mo.get(j+1));
					mo.set(j+1, temp);
				}
			}
		}
	}
	public static void main(String[] args) {
		new Mrent();
	}
}
