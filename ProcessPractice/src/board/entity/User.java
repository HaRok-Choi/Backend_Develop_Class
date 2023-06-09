package board.entity;

import board.dto.request.user.SignUpDto;

// 회원
public class User {
//	지속적인 애들만 변수로 만들면 된다.
//	entity는 setters를 굳이 안쓴다는 규약이 있다. why? 수정 작업이 잘 일어나지 않기 때문
//	현재는 DB를 안쓰기 때문에 수정 받는 작업을 한다.
	
	private String email;
	private String password;
//	private String passwordCheck; -> 검증만 하기에 빼도 됨
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	
	public User() {}

	public User(String email, String password, String nickname, String phoneNumber, String address,
			String addressDetail, String profileImageUrl) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
	}
	
	public User(SignUpDto dto) {
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.nickname = dto.getNickname();
		this.phoneNumber = dto.getPhoneNumber();
		this.address = dto.getAddress();
		this.addressDetail = dto.getAddressDetail();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nickname=" + nickname + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl="
				+ profileImageUrl + "]";
	}
	
	
	
	
}
