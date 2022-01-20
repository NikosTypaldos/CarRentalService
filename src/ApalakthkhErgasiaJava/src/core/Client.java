package ApalakthkhErgasiaJava.src.core;

public class Client {
	private String clientId,clientLicenceNum,clientName,clientSurname,clientEmail,clientAddress;
	private long clientPhoneNum;
	
	public Client(String clientId,String clientLicenceNum) {
		this.clientId = clientId;
		this.clientLicenceNum = clientLicenceNum;
	}
	
	public Client(String clientId, String clientLicenceNum, String clientName, String clientSurname, String clientEmail,String clientAddress,long clientPhoneNum) {
		setClientId(clientId);
		setClientLicenceNum(clientLicenceNum);
		setClientName(clientName);
		setClientSurname(clientSurname);
		setClientEmail(clientEmail);
		setClientAddress(clientAddress);
		setClientPhoneNum(clientPhoneNum);
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientLicenceNum() {
		return clientLicenceNum;
	}
	public void setClientLicenceNum(String clientLicenceNum) {
		this.clientLicenceNum = clientLicenceNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientSurname() {
		return clientSurname;
	}
	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public long getClientPhoneNum() {
		return clientPhoneNum;
	}
	public void setClientPhoneNum(long clientPhoneNum) {
		this.clientPhoneNum = clientPhoneNum;
	}

}
