package model;

public abstract class People {
	private String name;
	private int age;
	public String getName() {
		return name;
	}

	public abstract void kenalan();
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String role;
	
	public People(String name, int age, String role) {
		super();
		this.name = name;
		this.age = age;
		this.role = role;
	}
	

}
