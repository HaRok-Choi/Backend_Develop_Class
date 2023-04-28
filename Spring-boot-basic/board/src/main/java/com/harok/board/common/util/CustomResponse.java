package com.harok.board.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.harok.board.dto.response.ResponseDto;

//@ 메서드로 받아올려고 하는 곳
public class CustomResponse {

    public static ResponseEntity<ResponseDto> success() {
        ResponseDto body = new ResponseDto("SU", "SUCCESS");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    } 
    
    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto errorBody = new ResponseDto("DE", "DataBase Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> validationFailed() {
        ResponseDto errorBody = new ResponseDto("VF", "Request Parameter Validation Failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistBoardNumber() {
        ResponseDto errorBody = new ResponseDto("NB", "Non-Existent Board Number");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExistUserEmail() {
        ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User Email");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> noPermissions() {
        ResponseDto errorBody = new ResponseDto("NP", "No Permissions");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorBody);
    }

}
