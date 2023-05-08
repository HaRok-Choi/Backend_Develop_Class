package com.harok.board.service;

import org.springframework.http.ResponseEntity;

import com.harok.board.dto.request.auth.SignInRequestDto;
import com.harok.board.dto.request.auth.SignUpRequestDto;
import com.harok.board.dto.response.ResponseDto;
import com.harok.board.dto.response.auth.SignInResponseDto;

public interface AuthService {
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
