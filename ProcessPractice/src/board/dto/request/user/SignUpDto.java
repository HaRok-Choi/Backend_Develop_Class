package board.dto.request.user;
// 회원가입 dto
public class SignUpDto {
	
	private String email;			// 이메일
	private String password;		// 비밀번호
	private String passwordCheck;	// 비밀번호확인 
	private String nickname;		// 별명
	private String phoneNumber;		// 전화번호
	private String address;			// 주소
	private String addressDetail;	// 상세주소
	private String profileImageUrl; // 프로필사진
	
	public SignUpDto() {}

	public SignUpDto(String email, String password, String passwordCheck, String nickname, String phoneNumber,
			String address, String addressDetail, String profileImageUrl) {
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
	}

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public String toString() {
		return "SignUpDto [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", nickname=" + nickname + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", addressDetail=" + addressDetail + ", profileImageUrl=" + profileImageUrl + "]";
	}
	
//	입력한거 검증
	public boolean validate() {
		boolean result = this.email.isBlank() ||
						 this.password.isBlank() ||
						 this.nickname.isBlank() ||
						 this.phoneNumber.isBlank() ||
						 this.address.isBlank() ||
						 this.addressDetail.isBlank();
		return result;
	}
	
}
