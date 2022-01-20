package ApalakthkhErgasiaJava.src.core;

public class TwoWheeled extends Vehicle{
	private float seatHeight;
	private String baggageType,doorNum="-",seatNum="-";
	
	public TwoWheeled(String licensePlate,String brand,String fuelPowered,String vehicleType,int cubism,float seatHeight,String baggageType,int rentalCost) {
		super(licensePlate,brand,fuelPowered,vehicleType,cubism,rentalCost);
		setSeatHeight(seatHeight);
		this.baggageType = baggageType;
	}
	
	public float getSeatHeight() {
		return seatHeight;
	}
	
	public void setSeatHeight(float seatHeight) {
		this.seatHeight = seatHeight;
	}

	public String getBaggageType() {
		return baggageType;
	}
	
	public void setBaggageType(String baggageType) {
		this.baggageType = baggageType;
	}

	
	
	//Getters for TableView
	public String getDoorNum() {
		return doorNum;
	}
	
	public String getSeatNum() {
		return seatNum;
	}
}
