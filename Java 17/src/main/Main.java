package main;
import java.util.*;

import model.Menu;
import model.Regular;
import model.Special;

public class Main {
	ArrayList<Menu> menuList = new ArrayList <>();
	Scanner s = new Scanner(System.in);
	int menu, mprice, mdiscount;
	String mcode, mname, delete;
	public Main() {
		do {
			try {
				System.out.println();
				System.out.println("Family restaurant");
				System.out.println("================================");
				System.out.println("1. Add Regular Menu");
				System.out.println("2. Add Special Menu");
				System.out.println("3. Show All Menu");
				System.out.println("4. Delete Regular Menu");
				System.out.println("5. Delete Special Menu");
				System.out.println("6. Exit");
				System.out.print("Choice [1-6]: ");
				menu = s.nextInt();
			} catch (Exception e) {
				
			}
			s.nextLine();
			
			switch(menu) {
			case 1 :
				case1();
				System.out.println("Add Success!");
				break;
			case 2 :
				case2();
				System.out.println("Add Success!");
				break;
			case 3 :
				if(menuList.isEmpty()) {
					System.out.println("No Data");
				}
				else {
					case3();	
				}
				break;
			case 4 :
					boolean bool = false;
					for (Menu menu : menuList) {
						if(menu instanceof Regular) {
							bool = true;
							vreg();
							break;
						}
						else if(bool == false) {
							System.out.println("No Data");
							break;
						}
					}
				break;
			case 5 :
				boolean bool1 = false;
				for (Menu menu : menuList) {
					if(menu instanceof Special) {
						vspe();
						bool1 = true;
						break;
					}
					else if(bool1 == false) {
						System.out.println("No Data");
					}	
				}				
				break;
			case 6 : 
				System.out.println("Thank You");
				break;
			}
			
		} while (menu != 6);
		
	}
	
	public void case1() {
		boolean bool = false;
		System.out.println("Add Regular Menu");
		System.out.println("--------------------------------");
		do {
			System.out.print("Input menu code [R...]: ");
			mcode = s.nextLine();
			for (Menu menu : menuList) {
				if(menu.getMenuCode().equals(mcode)) {
					bool = true;
				}
				else {
					bool = false;
				}
			}
		} while (mcode.length() != 4 || !mcode.startsWith("R") || bool == true);
		
		do {
			System.out.print("Input menu name [5-20]: ");
			mname = s.nextLine();
		} while (mname.length() < 5 || mname.length() > 20);
	
		do {
			System.out.print("Input menu price [10000 - 100000]: ");
			mprice = s.nextInt();
			s.nextLine();
		} while (mprice < 10000 || mprice > 100000);
		
		Regular r = new Regular(mcode, mname, mprice);
		menuList.add(r);
	}
	
	public void case2() {
		boolean bool = false;
		System.out.println("Add Special Menu");
		System.out.println("--------------------------------");
		do {
			System.out.print("Input menu code [S...]: ");
			mcode = s.nextLine();
			for (Menu menu : menuList) {
				if(menu.getMenuCode().equals(mcode)) {
					bool = true;
					break;
				}
				else {
					bool = false;
					break;
				}
			}
		} while (mcode.length() != 4 || !mcode.startsWith("S") || bool == true);
		
		do {
			System.out.print("Input menu name [5-20]: ");
			mname = s.nextLine();
		} while (mname.length() < 5 || mname.length() > 20);
	
		do {
			System.out.print("Input menu price [10000 - 100000]: ");
			mprice = s.nextInt();
			s.nextLine();
		} while (mprice < 10000 || mprice > 100000);
		
		do {
			System.out.print("Input menu discount [10% | 25% | 50%]: ");
			mdiscount = s.nextInt();
			s.nextLine();
		} while (mdiscount != 10 && mdiscount != 25 && mdiscount != 50);
		
		Special s = new Special(mcode, mname, mprice, mdiscount);
		menuList.add(s);	
	}
	
	public void case3() {
		int idx = 1;
		System.out.println("Regular Menu");
		System.out.println("==================================================");
		System.out.println("No. | Kode  | Nama                    | Harga    |");
		System.out.println("--------------------------------------------------");
		for (Menu menu : menuList) {
			if(menu instanceof Regular) {
				Regular r = (Regular)menu;
				System.out.printf("%-3d | %-5s | %-23s | %-8s |\n", 
						(idx), r.getMenuCode(), r.getMenuName(), r.getPrice());
			}
			idx++;
		}
		
		System.out.println();
		System.out.println();
		
		int idx1 = 1;
		System.out.println("Special Menu");
		System.out.println("===============================================================");
		System.out.println("No. | Kode  | Nama                    | Harga    | Diskon     |");
		System.out.println("---------------------------------------------------------------");
		for (Menu menu : menuList) {
			if(menu instanceof Special) {
				Special s = (Special)menu;
				System.out.printf("%-3d | %-5s | %-23s | %-8s | %-10d |\n", 
						(idx1), s.getMenuCode(), s.getMenuName(), s.getPrice(), s.getDiscount());
			}
			idx1++;
		}
	}
	
	
	public void vreg() {
		int idx = 1;
		System.out.println("Regular Menu");
		System.out.println("==================================================");
		System.out.println("No. | Kode  | Nama                    | Harga    |");
		System.out.println("--------------------------------------------------");
		for (Menu menu : menuList) {
			if(menu instanceof Regular) {
				Regular r = (Regular)menu;
				System.out.printf("%-3d | %-5s | %-23s | %-8s |\n", 
						(idx), r.getMenuCode(), r.getMenuName(), r.getPrice());
			}
			idx++;
		}
		
		System.out.println("Delete Regular Menu");
		System.out.println("------------------------------");
		
			boolean b = false;
			do {
				do {
					System.out.print("Inut menu code [R...]: ");
					delete = s.nextLine();
					if (delete.equals("0")) {
						b = true;
						break;
					}
				} while (!delete.startsWith("R"));
				
				for (Menu menu : menuList) {
					if (menu instanceof Regular) {
						Regular r = (Regular) menu;
						if (r.getMenuCode().equals(delete)) {
							menuList.remove(menuList.indexOf(r));
							System.out.println("Delete Success!");
							b = true;
							break;
						}
					}
				} 
				
				if(b == false) {
					System.out.println("The code is wrong!");
				}
			} while (b == false);
		
		
		
	}
	
	public void vspe() {
		int idx1 = 1;
		System.out.println("Regular Menu");
		System.out.println("===============================================================");
		System.out.println("No. | Kode  | Nama                    | Harga    | Diskon     |");
		System.out.println("---------------------------------------------------------------");
		for (Menu menu : menuList) {
			if(menu instanceof Special) {
				Special s = (Special)menu;
				System.out.printf("%-3d | %-5s | %-23s | %-8s |\n", 
						(idx1), s.getMenuCode(), s.getMenuName(), s.getPrice(), s.getDiscount());
			}
			idx1++;
		}
		
		boolean b = false;
		do {
			do {
				System.out.print("Inut menu code [S...]: ");
				delete = s.nextLine();
				if (delete.equals("0")) {
					b = true;
					break;
				}
			} while (!delete.startsWith("S"));
			for (Menu menu : menuList) {
				if (menu instanceof Special) {
					Special s = (Special) menu;
					if (s.getMenuCode().equals(delete)) {
						menuList.remove(menuList.indexOf(s));
						System.out.println("Delete Success!");
						b = true;
						break;
					}
				}
			}
			if (b == false) {
				System.out.println("The code is wrong");
			} 
		} while (b == false);
		
	}
	

	public static void main(String[] args) {
		new Main();
	}

}
