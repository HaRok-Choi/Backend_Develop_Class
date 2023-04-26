package com.harok.board.service;

import org.springframework.http.ResponseEntity;

import com.harok.board.dto.request.user.PostUserRequestDto;
import com.harok.board.dto.response.ResponseDto;

public interface UserService {
    
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);

}
