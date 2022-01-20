package ApalakthkhErgasiaJava.src.core;
import java.util.Date;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Rental {
	private int totalCost;
	private final int uniqueId;
	private int rentedVehicleLicense;
	private String rentedToName,getFromStore,returnToStore;
	private Date rentDate,returnDate;
	private static int  MAX_CODE;
	
	public Rental(int totalCost, int rentedVehicleLicense, String rentedToName, String getFromStore,String returnToStore, String rentDate, String returnDate) throws ParseException {
		setTotalCost(totalCost);
		setRentedVehicle(rentedVehicleLicense);
		setRentedToName(rentedToName);
		setGetFromStore(getFromStore);
		setReturnToStore(returnToStore);
		setRentDate(rentDate);
		setReturnDate(returnDate);
		uniqueId = 1000 + new Random().nextInt(50000);
		MAX_CODE += 1;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getRentedVehicle() {
		return rentedVehicleLicense;
	}
	public void setRentedVehicle(int rentedVehicleLicense) {
		this.rentedVehicleLicense = rentedVehicleLicense;
	}
	public String getRentedToName() {
		return rentedToName;
	}
	public void setRentedToName(String rentedToName) {
		this.rentedToName = rentedToName;
	}
	public String getGetFromStore() {
		return getFromStore;
	}
	public void setGetFromStore(String getFromStore) {
		this.getFromStore = getFromStore;
	}
	public String getReturnToStore() {
		return returnToStore;
	}
	public void setReturnToStore(String returnToStore) {
		this.returnToStore = returnToStore;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.rentDate = (Date) simpleDateFormat.parse(rentDate);
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate2) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.returnDate = (Date) simpleDateFormat.parse(returnDate2);
	}
	
}
