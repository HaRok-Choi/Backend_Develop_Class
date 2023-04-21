package com.harok.firstproject.dto.request;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ExampleDto {
    //@ ↓ 무언가를 설정하고 적용시켜줘야 된다.
    // @NotEmpty --> 띄어쓰기도 문자로 인식함
    @NotBlank // --> 공백이 있으면 안됨
    private String parameter1;
    @Length(min = 0, max = 20) //@ <-- 위치에 따라 적용하는 곳이 바뀜
    private String parameter2;
    private String parameter3;
}
