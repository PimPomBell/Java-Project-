package model;

public class Regular extends Status{
	private int queue;
		


	public Regular(String id, String name, String gender, String phone, int point, int queue) {
		super(id, name, gender, phone, point);
		this.queue = queue;
	}
	
	
	public int getQueue() {
		return queue;
	}


	public void setQueue(int queue) {
		this.queue = queue;
	}


	@Override
	public int countPoint() {
		int rpoint = name.length();
		return rpoint;
	}
	
	
	
}
