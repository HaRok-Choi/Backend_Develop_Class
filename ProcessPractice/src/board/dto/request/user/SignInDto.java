package board.dto.request.user;
// 로그인 관련 Dto
public class SignInDto {
	
	private String email;
	private String password;
	
	public SignInDto() {}

	public SignInDto(String email, String password) {
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "SignInDto [email=" + email + ", password=" + password + "]";
	}
	
//	검증하는거
	public boolean validate() {
		boolean result = this.email.isBlank() || this.password.isBlank(); 
		return result;
	}
}
