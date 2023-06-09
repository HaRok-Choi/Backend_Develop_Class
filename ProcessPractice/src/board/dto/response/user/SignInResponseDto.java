package board.dto.response.user;

import java.util.UUID;

import board.entity.User;

// 유저 정보 반환
public class SignInResponseDto {
	
//	비밀번호는 보안상 반환 안함
	private String email;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	private String token;
	
	public SignInResponseDto() {}

	public SignInResponseDto(String email, String nickname, String phoneNumber, String address, String addressDetail,
			String profileImageUrl, String token) {
		this.email = email;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
		this.token = token;
	}
	
	public SignInResponseDto(User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.phoneNumber = user.getPhoneNumber();
		this.address = user.getAddress();
		this.addressDetail = user.getAddressDetail();
		this.profileImageUrl = user.getProfileImageUrl();
		this.token = UUID.randomUUID().toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SignInResponseDto [email=" + email + ", nickname=" + nickname + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl=" + profileImageUrl
				+ ", token=" + token + "]";
	}
	
	
}
