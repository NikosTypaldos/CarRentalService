package ApalakthkhErgasiaJava.src.core;

import java.util.Random;

public class Store {
	private String cityName,brand;
	private final int uniqueIdStore;
	private static int  MAX_CODE;
	
	public Store(String cityName,String brand) {
		this.cityName = cityName;
		this.uniqueIdStore = 10000 + new Random().nextInt(50000);
		this.brand = brand;
		MAX_CODE += 1;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getUniqueIdStore() {
		return uniqueIdStore;
	}
	
}
