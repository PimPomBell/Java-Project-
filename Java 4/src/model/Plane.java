package model;

public abstract class Plane {
	protected String id;
	protected String name;
	protected String destination;
	protected String departure;
	protected int cost;
	protected int total;
	
	public Plane(String id, String name, String destination, String departure, int cost, int total) {
		this.id = id;
		this.name = name;
		this.destination = destination;
		this.departure = departure;
		this.cost = cost;
		this.total = total;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public abstract void countPrice();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
