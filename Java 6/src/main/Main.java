package main;
import java.util.*;

import model.Apple;
import model.Fruit;
import model.Banana;

public class Main {
	ArrayList <Fruit> fruit = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	int menu, bprice, aweight, num, bweight, balance = 1000, sell;
	String ftype, avariety, fid, bripe;
	public Main() {
		do {
			System.out.println();
			System.out.println("+===+===+===+");
			System.out.println("+ De Fruitz +");
			System.out.println("+===+===+===+");
			System.out.println("BALANCE : " + balance);
			System.out.println("1. Buy Fruit");
			System.out.println("2. Sell Fruit");
			System.out.println("3. View All Fruit");
			System.out.println("4. Exit");
			System.out.print(">> ");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1 : 
				addFruit();
				break;
			case 2 : 
				sellFruit();
				break;
			case 3 : 
				viewFruit();
				break;
			case 4 : 
				System.out.println("Thank You for using the app!");
				break;
			}
			
		} while (menu != 4);
		
		
	}

	public void addFruit() {
		bprice = r.nextInt(100-50+1) + 50;		
		
		do {
			System.out.print("Input fruit type [Apple | Banana] (case insensitive) : ");
			ftype = s.nextLine();
		} while (!ftype.equalsIgnoreCase("Apple") && (!ftype.equalsIgnoreCase("Banana")));
		
		if(ftype.equals("Apple")) {
			do {
				System.out.print("Input apple weight (50-500)g (inclusive) : ");
				aweight = s.nextInt();
			} while (aweight == 0 || aweight < 50 || aweight > 500);
			
			do {
				System.out.print("Input apple variety [Fuji | Gala | Honeycrisp | Golden Delicious] (case sensitive) : ");
				avariety = s.nextLine();
			} while (!avariety.equals("Fuji") && !avariety.equals("Gala") && !avariety.equals("Honeycrisp")&& !avariety.equals("Golden Delicious"));
		
			
			fid = String.format("AP%03d", r.nextInt(999)+1);
			
			Apple x = new Apple(fid, bprice, aweight, avariety);
			x.countPrice();
			fruit.add(x);
		}
		else {
			bprice = r.nextInt(100-50+1) + 50;	
			
			do {
				System.out.print("Input apple weight (50-500)g (inclusive) : ");
				bweight = s.nextInt();
			} while (bweight == 0 || bweight < 50 || bweight > 500);
			
			do {
				System.out.print("Input banana ripeness [Overripe | Semi-ripe | Ripe | Unripe] (case sensitive) : ");
				bripe = s.nextLine();
			} while (!bripe.equals("Overripe") && !bripe.equals("Semi-ripe") && !bripe.equals("Ripe") && !bripe.equals("Unripe"));
			
			fid = String.format("BN%03d", r.nextInt(999)+1);
			
			Banana y = new Banana(fid, bprice, bweight, bripe);
			y.countPrice();
			fruit.add(y);
		}
	}
	
	public void viewFruit() {
		int idx = 0;
		System.out.println("=================================================================");
		System.out.println("| No. | ID    | Type   | Weight  | Variety         | Ripeness   |");
		System.out.println("=================================================================");
		for (Fruit f : fruit) {
			if(f instanceof Apple) {
				Apple a = (Apple)f;
				System.out.printf("| %-3d | %-5s | Apple  | %-7d | %-15s | -          |\n", idx, a.getId(), a.getWeight(), a.getVariety());
			}
			else if (f instanceof Banana){
				Banana b = (Banana)f;
				System.out.printf("| %-3d | %-5s | Banana | %-7d | -               | %-10s |\n", idx, b.getId(), b.getWeight(), b.getRipeness());	
			}
		idx++;
		}
		System.out.println("=================================================================");
	}
	
	public void sellFruit() {
		viewFruit();
		do {
			System.out.println("");
			sell = s.nextInt();
			s.nextLine();
		} while (sell < 0 || sell > fruit.size());
		
		System.out.printf("Fruit sold for %f", fruit.get(sell-1).countPrice());
		balance = balance + (int)fruit.get(sell-1).countPrice();
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
