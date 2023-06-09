package board.controller;

import board.common.constant.HttpStatus;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
import board.dto.response.ResponseDto;
import board.dto.response.user.SignInResponseDto;
import board.service.UserService;

// 검증처리를 여기서 함, 입력을 위한 것들을 여기서 넘겨줌
public class UserController {
	
	private UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
//	회원가입
	public void signUp(SignUpDto dto) {
//		SignUpDto에서 검증한 메서드 불러옴
		if (dto.validate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<Boolean> response = userService.signUp(dto);
		System.out.println(response.toString());	// 값 확인 용도
//		비밀번호 비교하기 위한것은 비즈니스 로직에 해당하기 때문에 여기서 검증하지 않는다.
	}
	
//	로그인
	public void signIn(SignInDto dto) {
		if (dto.validate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<SignInResponseDto> response = userService.signIn(dto);
		System.out.println(response.toString());	// 값 확인 용도
	}
	
}
