package model;

public class VIP extends Status{
	private String loungeId;
	private String email;


	public VIP(String id, String name, String gender, String phone, int point, String loungeId, String email) {
		super(id, name, gender, phone, point);
		this.loungeId = loungeId;
		this.email = email;
	}

	


	public String getLoungeId() {
		return loungeId;
	}




	public void setLoungeId(String loungeId) {
		this.loungeId = loungeId;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public int countPoint() {
		int vpoint = name.length()*2;
		return vpoint;
	}
	
	
	
	
}
