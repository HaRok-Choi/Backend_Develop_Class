package board.service;

import board.common.constant.ResponseMessage;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
import board.dto.response.ResponseDto;
import board.dto.response.user.SignInResponseDto;
import board.entity.User;
import board.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public ResponseDto<Boolean> signUp(SignUpDto dto) {
//		비밀번호 비교는 여기서 검증을 함
		String email = dto.getEmail();
		String password = dto.getPassword();
		String passwordCheck = dto.getPasswordCheck();
		
		boolean hasEmail = userRepository.existsByEmail(email);
		if (hasEmail) {
			return new ResponseDto<Boolean>(false, ResponseMessage.EXIST_EMAIL, false);
		}
		
		if (!password.equals(passwordCheck)) {
			return new ResponseDto<Boolean>(false, ResponseMessage.PASSWORD_NOT_MATCH, false);
		}
		
		User user = new User(dto);
		userRepository.save(user);
		
		return new ResponseDto<Boolean>(true, ResponseMessage.SUCCESS, true);
	}
	
//	로그인 할때 DB에 있는 이메일, 비밀번호 일치 여부
	public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
		SignInResponseDto data = null;
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return new ResponseDto<SignInResponseDto>(false, ResponseMessage.FAIL_SIGN_IN, null);
		}
		
		boolean isEqualPassword = user.getPassword().equals(password);
		if (!isEqualPassword) {
			return new ResponseDto<SignInResponseDto>(false, ResponseMessage.FAIL_SIGN_IN, null);
		}
		
		data = new SignInResponseDto(user);
		
		return new ResponseDto<SignInResponseDto>(true, ResponseMessage.SUCCESS, data);
	}
	
}
