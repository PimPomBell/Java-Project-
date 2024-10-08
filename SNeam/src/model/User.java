package model;

public class User {
	private String userId;
	private String username;
	private String password;
	private String phonenumber;
	private String email;
	private String role;
	
	public User(String userId, String username, String password, String phonenumber, String email, String role) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.email = email;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
