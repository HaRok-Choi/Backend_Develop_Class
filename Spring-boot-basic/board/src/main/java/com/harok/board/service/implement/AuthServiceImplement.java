package com.harok.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.harok.board.common.util.CustomResponse;
import com.harok.board.dto.request.auth.SignInRequestDto;
import com.harok.board.dto.request.auth.SignUpRequestDto;
import com.harok.board.dto.response.ResponseDto;
import com.harok.board.dto.response.auth.SignInResponseDto;
import com.harok.board.entity.UserEntity;
import com.harok.board.provider.JwtProvider;
import com.harok.board.repository.UserRepository;
import com.harok.board.service.AuthService;

@Service
public class AuthServiceImplement implements AuthService {
    
    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImplement(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = new BCryptPasswordEncoder(); 
    }

    //! 회원가입
    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {

        String email = dto.getUserEmail();
        String nickname = dto.getUserNickname();
        String phoneNumber = dto.getUserPhoneNumber();
        String password = dto.getUserPassword();

        try {
            //# 1. 존재하는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(email);
            if (existedUserEmail) return CustomResponse.existUserEmail();

            //# 2. 존재하는 유저 닉네임 반환
            boolean existedUserNickname = userRepository.existsByNickname(nickname);
            if (existedUserNickname) return CustomResponse.existUserNickname();

            //# 3. 존재하는 휴대폰 번호 반환
            boolean existedUserPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if (existedUserPhoneNumber) return CustomResponse.existUserePhoneNumber();

            //@ 암호화 작업
            String encodedPassword = passwordEncoder.encode(password);
            dto.setUserPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            //# 4. 데이터베이스 오류
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    //! 로그인
    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        SignInResponseDto body = null;

        String email = dto.getUserEmail();
        String password = dto.getUserPassword();

        try {
            //# 1. 로그인 실패 (이메일 x)
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return CustomResponse.signInFailed();

            //# 2. 로그인 실패 (패스워드 x)
            String encordedPassword = userEntity.getPassword(); //@ ← 암호화 과정
            boolean equaledPassword = passwordEncoder.matches(password, encordedPassword);
            //@ ↑ 암호화된 비번을 비교함
            if (!equaledPassword) return CustomResponse.signInFailed();

            String jwt = jwtProvider.create(email);
            body = new SignInResponseDto(jwt);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
