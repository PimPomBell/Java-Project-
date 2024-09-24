package main;
import java.util.*;

import model.Lecturer;
import model.People;
import model.Student;

public class Main {
	ArrayList<People> peoples = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	int menu, inpAge, inpSalary, remove;
	String inpName, inpRole;
	double inpGpa;
	
	public Main() {
		do {
				System.out.println("\n1. Add People");
				System.out.println("2. View People");
				System.out.println("3. Remove People");
				System.out.println("4. Exit");
				System.out.print(">> ");
				menu = s.nextInt();
				s.nextLine();
			
			switch (menu) {
			case 1:
				addPeople();
				break;
			case 2:
				if(peoples.isEmpty()) {
					System.out.println("There are no peoples in classroom");
				}
				else {
					viewPeople();
				}
				break;
			case 3:
				if(peoples.isEmpty()) {
					System.out.println("There are no peoples in classroom");
				}
				else {
					removePeople();
				}
				break;
			case 4:
				System.out.println("Thank You for using");
				break;
			}
		} while (menu != 4);
		
	}

	public void addPeople() {
		do {
			System.out.print("Input name [3 - 15 characters]: ");
			inpName = s.nextLine();
		} while (inpName.length() < 1 || inpName.length() > 15);
		
		do {
			System.out.print("Input age [min 16]: ");
			inpAge = s.nextInt();
			s.nextLine();
		} while (inpAge < 16);
		
		do {
			System.out.print("Input role ['Student', 'Lecturer']: ");
			inpRole = s.nextLine();
		} while (!inpRole.equals("Student") && !inpRole.equals("Lecturer"));
		
			if(inpRole.equals("Student")) {
				do {
					System.out.print("Input gpa [0-4]: ");
					inpGpa = s.nextDouble();
					s.nextLine();
					peoples.add(new Student(inpName, inpAge, inpRole, inpGpa));
				} while (inpGpa < 1 || inpGpa > 4);
				System.out.println("Student added succesfully");
			}
		
			if(inpRole.equals("Lecturer")) {
				do {
					System.out.print("Input salary [min 4000000]: ");
					inpSalary = s.nextInt();
					s.nextLine();
					peoples.add(new Lecturer(inpName, inpAge, inpRole, inpSalary));
				} while (inpSalary < 4000000);
				System.out.println("Lecturer added succesfully");
			}
	}
	
	public void viewPeople() {
//		int index = 0;
//		for (People people : peoples) {
//			index++;
//			System.out.print(index + ". ");
//			people.kenalan();
//			System.out.println();
//		}
		for (int i = 0; i < peoples.size(); i++) {
		        People people = peoples.get(i);
		        System.out.print((i + 1) + ". ");
		        people.kenalan();
		        System.out.println();
		}

		
	}
	
	public void removePeople() {
		viewPeople();
		System.out.println();
		do {
			System.out.print("Input peoples index to delete: ");
			remove = s.nextInt();
			s.nextLine();
		} while (remove < 1 || remove > peoples.size() );
		System.out.println("People deleted successfully !!");
		peoples.remove(remove-1);
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
