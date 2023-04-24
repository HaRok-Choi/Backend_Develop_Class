package com.harok.firstproject.service.implement;

import org.springframework.stereotype.Service;
import com.harok.firstproject.service.RestApiService;

//@ 어노테이션 걸지 않고 실행하면 애초에 실행이 되지 않음

@Service
public class RestApiServiceImplement implements RestApiService {
    
    public String getMethod() {
        return "Return to Service Layer";
    }
}
