package java_exam;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String email;
	private String password;
	private String passwordCheck;
	private String name;
	private String telNumber;
	
	public User(String email, String password, String passwordCheck, String name, String telNumber) {
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.name = name;
		this.telNumber = telNumber;
	}
	public User() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck + ", name=" + name
				+ ", telNumber=" + telNumber + "]";
	}
	
	public boolean valid() {
		boolean result = this.email.isBlank() ||
						 this.password.isBlank() ||
						 this.passwordCheck.isBlank() ||
						 this.name.isBlank() ||
						 this.telNumber.isBlank();
		return result;
	}
}


