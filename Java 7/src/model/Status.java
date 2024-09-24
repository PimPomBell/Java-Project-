package model;

public abstract class Status {
	protected String id;
	protected String name;
	protected String gender;
	protected String phone;
	protected int point;
	
	public Status(String id, String name, String gender, String phone, int point) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.point = point;
	}
	
	public abstract int countPoint();

	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
