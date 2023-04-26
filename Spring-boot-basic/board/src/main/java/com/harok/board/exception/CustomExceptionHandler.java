package com.harok.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harok.board.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    //@ 예외처리에 대한 상황
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> HttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ResponseDto responseBody = new ResponseDto("VF", "Request Parameter Validation Failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

}
