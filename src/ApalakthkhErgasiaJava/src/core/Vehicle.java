package ApalakthkhErgasiaJava.src.core;

public abstract class Vehicle {
	private String licensePlate,brand,fuelPowered,vehicleType;
	private int cubism =0,rentalCost=0;
	
	public Vehicle(String brand,String licensePlate, String fuelPowered, String vehicleType, int cubism, int rentalCost) {
		setLicensePlate(licensePlate);
		setBrand(brand);
		setFuelPowered(fuelPowered);
		setVehicleType(vehicleType);
		setCubism(cubism);
		setRentalCost(rentalCost);
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFuelPowered() {
		return fuelPowered;
	}
	public void setFuelPowered(String fuelPowered) {
		this.fuelPowered = fuelPowered;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getCubism() {
		return cubism;
	}
	public void setCubism(int cubism) {
		this.cubism = cubism;
	}
	public int getRentalCost() {
		return rentalCost;
	}
	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}
	
}
