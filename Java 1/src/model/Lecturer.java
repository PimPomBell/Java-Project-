package model;

public class Lecturer extends People {

	private int salary;
	
	public Lecturer(String name, int age, String role, int salary) {
		super(name, age, role);
		this.salary = salary;
	}

	@Override
	public void kenalan() {
		System.out.printf("Hello, my name is %s\n", this.getName() );
		System.out.printf("I am %d year(s) old\n", this.getAge());
		System.out.printf("I am a %s\n", this.getRole());
		System.out.printf("My salary is %d\n", this.getSalary());
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}



}
