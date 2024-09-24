import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CryptoPort {
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Crypto> crypto = new ArrayList<>();
	
	int menu, amount, sell, sellAm, random, random1;
	String id, name, verif, captcha;
	double buy, sellP, sales, profit;
	public CryptoPort() {
		do {
			try {
				menus();
				menu = s.nextInt();
			} catch (Exception e) {
				System.out.print("Input must be number!");
			}
			s.nextLine();
			
		switch (menu) {
			case 1 :
			do {
				System.out.print("Input Crypto ID [3-5] : ");
				id = s.nextLine();
			} while (id.length()<3 || id.length()>5);
			
			do {
				System.out.print("Input Crypto Name [Length greater than or equal 3 and with a capital letter] : ");
				name = s.nextLine();
			} while (name.length()<=3 || !Character.isUpperCase(name.charAt(0)));
			
			do {			
				System.out.print("Input Crypto buying price (USDT) [greater than 0] : ");
				buy = s.nextDouble();
				s.nextLine();
			} while (buy <= 0);
			
			do {		
				System.out.print("Input amount [greater than 0] : ");
				amount = s.nextInt();
				s.nextLine();
			} while (amount <= 0);
			
			Crypto y = new Crypto(id, name, buy, amount);
			crypto.add(y);
			
			System.out.println(name + " has been added to your portfolio");
			System.out.println(); 
			break;
			case 2 :
				if(crypto.isEmpty()) {
					System.out.println("You don't own any crypto assets");
				}
				else {
				view();
				System.out.println("Press enter to continue!");
				s.nextLine();
				}
				break;
			case 3 :
				sell();
				break;
			case 4 :
				System.out.println("Thank you for using the app!");
				break;	
			}
		} while (menu != 4);
	}
	public void menus() {
		System.out.println("Crypto Portfolio");
		System.out.println("=======================");
		System.out.println("1. Add new crypto asset");
		System.out.println("2. View all crypto asset");
		System.out.println("3. Sell crypto asset");
		System.out.println("4. Exit");
		System.out.print(">>");	
	}
	public void view() {
		sort();
		System.out.printf("|%-4s|%-7s|%-20s|%-16s|%-12s|\n", "No", "ID", "Name Crypto", "Price (USDT)", "Amount");
		for(int i = 0; i<crypto.size(); i++) {
		System.out.printf("|%-4s|%-7s|%-20s|%-16s|%-12s|\n", (i+1), crypto.get(i).getId(), crypto.get(i).getName(), crypto.get(i).getPrice(), crypto.get(i).getAmount());	
		}
	}
	
	public void sell() {
		if(crypto.isEmpty()) {
			System.out.println("There is no crypto assets you can sell");
		}
		else {
			view();
			do {
					try {
						System.out.print("Choose your crypto you want to sell [1-" + crypto.size() + "] : ");
						sell = s.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
					s.nextLine();
			} while (sell < 0 || sell-1 > crypto.size()) ;
			
			do {
					System.out.print("Input amount " + crypto.get(sell).getId() + "do you want to sell [1-"+ crypto.get(sell).getAmount() + "] : ");
					sellAm = s.nextInt();
					s.nextLine();
			} while (sellAm < 1 || sellAm > crypto.get(sell).getAmount());
			
			do {
				System.out.print("Input " + crypto.get(sell).getId() + " selling price (USDT) [greater than 0] : ");
				sellP = s.nextDouble();
			} while (sellP < 0);
			
			do {
				captcha = (char)(rand.nextInt(26) + 65) + "" + (char)(rand.nextInt(26) + 65);
				for (int i = 0; i < 2; i++) {
					random = rand.nextInt(9) + 0;
					captcha = captcha + random;
					for (int j = 0; j < 1; j++) {
						random1 = rand.nextInt(2) + 1;
						captcha = captcha + random + random1;
					}
				}
				
				System.out.println("Verify your transaction");
				System.out.println(captcha);
				System.out.println("type the words above : ");
				verif = s.nextLine();
			} while (!verif.equals(captcha));
			
			
			sales = sellP*sellAm;
			
			profit = (sellP/buy-1)*100;
			
			System.out.println("You sell " + sellAm + " for " + sales + " USDT and get " + profit + "% profit");
			
			crypto.remove(sell-1);
			System.out.println("Press enter to continue...");
			s.nextLine();
		}
	}
	public void sort() {
		for(int i = 0; i<crypto.size(); i++) {
			for(int j = 0; j<crypto.size()-1; j++) {
				if(crypto.get(j).getId().compareTo(crypto.get(j+1).getId())>0) {
					Crypto temp = crypto.get(j);
					crypto.set(j, crypto.get(j+1) );
					crypto.set(j+1, temp);
				}
			}
		}
	}
	public static void main(String[] args) {
		new CryptoPort();
	}
}
