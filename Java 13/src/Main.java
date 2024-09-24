import java.util.*;

public class Main {
	ArrayList<Student> company =  new ArrayList<>();
	Scanner s = new Scanner(System.in);
	
	int menu, delete;
	String name, job;
	public Main() {
		do {
		System.out.println("1. Input data");
		System.out.println("2. View Data");	
		System.out.println("3. Delete");
		System.out.println("4. Exit");
		System.out.print(">>");
		menu = s.nextInt();
		s.nextLine();
		
		switch (menu) {
		case 1:
			do {
				try {
					System.out.print("Input name : ");
					name = s.nextLine();
				} catch (Exception e) {
					System.out.println("Input must be letters!");
				} 
			} while (name.length() < 5);
			
			do {
				try {
					System.out.println("Input job : ");
					job = s.nextLine();
				} catch (Exception e) {
					System.out.println("Input must be letters!");
				} 
			} while (!job.equals("OB") && !job.equals("CEO"));
			
			Student x = new Student(name, job);
			company.add(x);
			
			break;
		case 2:
			sort();
			System.out.println("View data below...");
			for(int i = 0; i<company.size(); i++) {
				System.out.println("Name : " + company.get(i).getName());
				System.out.println("Job : " + company.get(i).getJob());
				System.out.println();
			}
			System.out.println("Press enter to continue...");
			s.nextLine();
			break;
		case 3:
			do {
				System.out.println("Input number between [1 - " + company.size() + "] :");
				delete = s.nextInt();
				s.nextLine();
			} while (delete < 0 || delete > company.size());
			company.remove(delete-1);
			System.out.println("Press enter to continue..");
			s.nextLine();
			break;
		case 4:
			System.out.println("Thank You for using the app!");
			break;
		}
		
		
		}while(menu != 4);
		
		
	}
	
	public void sort() {
		for(int i = 0; i<company.size(); i++) {
			for(int j = 0; j<company.size()-1; j++) {
				if(company.get(j).getName().compareTo(company.get(j+1).getName())>0) {
					Student temp = company.get(j);
					company.set(j, company.get(j+1));
					company.set(j+1, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
