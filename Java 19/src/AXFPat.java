public class AXFPat {
	private String name; 
	private String gender;
	private String email;
	private String id;
	
	public AXFPat(String name, String gender, String email, String id) {
		this.name = name;
		this.gender = gender;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
