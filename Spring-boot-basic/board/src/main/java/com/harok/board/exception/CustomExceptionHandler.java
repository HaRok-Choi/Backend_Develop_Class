package com.harok.board.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harok.board.common.util.CustomResponse;
import com.harok.board.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    //@ 예외처리에 대한 상황
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> HttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return CustomResponse.validationFailed();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> HandlerMethodArgumentNotValidExceptio(MethodArgumentNotValidException exception) {
        return CustomResponse.validationFailed();
    }

}
