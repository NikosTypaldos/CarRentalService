package ApalakthkhErgasiaJava.src.core;

import java.util.Random;

public class City {
	private static int MAX_CODE;
	private String name;
	private final int uniqueId;
	
	public City(String name) {
		this.name = name;
		this.uniqueId = 1000 + new Random().nextInt(50000);
		MAX_CODE += 1;
	}
	
	public String getCityName() {
		return name;
	}
	
	public void setCityName(String name) {
		this.name = name;
	}

	public int getUniqueId() {
		return uniqueId;
	}
	public int getMAX_CODE() {
		return MAX_CODE;
	}

	
	

}
