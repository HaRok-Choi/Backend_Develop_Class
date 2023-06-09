package java_exam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CustomerInformation {
	
	private String customerNumber;
	private String name;
	private String gender;
	private String date;
	private String address;
	private String phoneNumber;
	private boolean marketingReceived;
	private boolean ConsentToCollectPersonalInformation;
	
	Date nowDate = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd");
	String changedDate = simpleDateFormat.format(nowDate);
	
	public CustomerInformation() {}
	
	public CustomerInformation(String name, String gender, Date date, String address,
			String phoneNumber, boolean marketingReceived, boolean consentToCollectPersonalInformation) {
		this.customerNumber = UUID.randomUUID().toString();
		this.name = name;
		this.gender = gender;
		this.date = changedDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.marketingReceived = marketingReceived;
		this.ConsentToCollectPersonalInformation = consentToCollectPersonalInformation;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isMarketingReceived() {
		return marketingReceived;
	}

	public void setMarketingReceived(boolean marketingReceived) {
		this.marketingReceived = marketingReceived;
	}

	public boolean isConsentToCollectPersonalInformation() {
		return ConsentToCollectPersonalInformation;
	}

	public void setConsentToCollectPersonalInformation(boolean consentToCollectPersonalInformation) {
		this.ConsentToCollectPersonalInformation = consentToCollectPersonalInformation;
	}

	@Override
	public String toString() {
		return "CustomerInformation [customerNumber=" + UUID.randomUUID().toString() + ", name=" + name + ", gender=" + gender
				+ ", date=" + changedDate + ", address=" + address + ", phoneNumber=" + phoneNumber + ", marketingReceived="
				+ marketingReceived + ", ConsentToCollectPersonalInformation=" + ConsentToCollectPersonalInformation
				+ "]";
	}
	
	public boolean vaild() {
		boolean result = this.name.isBlank() ||
						 this.gender.isBlank() ||
						 this.address.isBlank() ||
						 this.phoneNumber.isBlank();
		return result;
	}
}
