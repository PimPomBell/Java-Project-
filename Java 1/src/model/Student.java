package model;

public class Student extends People{
	
	private double gpa;
	
	public Student(String name, int age, String role, double gpa) {
		super(name, age, role);
		this.gpa = gpa;
	}
	
	@Override
	public void kenalan() {
		System.out.printf("Hello, my name is %s\n", this.getName() );
		System.out.printf("I am %d year(s) old\n", this.getAge());
		System.out.printf("I am a %s\n", this.getRole());
		System.out.printf("My GPA is %.2f from 4.0\n", this.getGpa());
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	



}
