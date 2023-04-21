package com.harok.firstproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ExampleResponseDto {
    private String data1;
    private String data2;
    private String data3;
}
