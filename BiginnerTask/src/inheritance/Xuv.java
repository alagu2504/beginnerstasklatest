package inheritance;
public class Xuv extends Car{
	private int seats;
	private int airBags;
	private String model;
	private String color;
	
	public Xuv() {
		super("Car constructor");
	}

	public int getSeats() {
		return seats;
	}
	public void setSeats(int seatsNo) {
		this.seats=seatsNo;
	}

	public int getAirBags() {
		return airBags;
	}
	public void setAirBags(int noOfAirBags) {
	this.airBags=noOfAirBags;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String modelName) {
		this.model=modelName;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String colorName) {
		this.color=colorName;
	}
}

