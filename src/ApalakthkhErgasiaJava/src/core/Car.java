package ApalakthkhErgasiaJava.src.core;

public class Car extends Vehicle {
	private int seatNum,doorNum;
	private String seatHeight="-",baggageType = "-";
	public Car(String licensePlate,String brand,String fuelPowered,String vehicleType,int cubism,int rentalCost,int seatNum,int doorNum) {
		super(licensePlate,brand,fuelPowered,vehicleType,cubism,rentalCost);
		setSeatNum(seatNum);
		setDoorNum(doorNum);
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getDoorNum() {
		return doorNum;
	}

	public void setDoorNum(int doorNum) {
		this.doorNum = doorNum;
	}
	
	
	
	public String getSeatHeight() {
		return seatHeight;
	}

	public String getBaggageType() {
		return baggageType;
	}
}
