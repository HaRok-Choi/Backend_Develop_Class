package com.harok.firstproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harok.firstproject.dto.request.ExampleDto;
import com.harok.firstproject.dto.response.ExampleResponseDto;
import com.harok.firstproject.service.implement.RestApiServiceImplement;

class ParamDto {
    private String data1;
    private String data2;

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public void setData1(String data1) {
        this.data1=data1;
    }

    public void setData2(String data2) {
        this.data2=data2;
    }
}

//@ Rest API를 위한 Controller임을 명시해주는 어노테이션
//@ @Controller + @ResponseBody = @RestController
//@ Response는 HTML을 제외한 MIME type을 반환
@RestController

//@ URL path 패턴을 지정해서 해당 패턴이면 지정한 클래스로 처리하도록 함
@RequestMapping(value = "api")

public class RestApiController {

    @Autowired
    //@ ↑ Spring이 알아서 읽어오고 적용시켜줌 (아래와 같이 쓸려면 @Autowired 무조건 걸어줘야 됨)
    private RestApiServiceImplement restApiService;

    //@ 생성자는 @Autowired를 굳이 안걸어도 된다.
    // public RestApiController(RestApiServiceImplement restApiService) {
    //     this.restApiService=restApiService;
    // }

    //@ ↓ 가독성이 떨어짐
    @RequestMapping(method = {RequestMethod.GET}, value = "hello2")
    public String hello2() {
        return "hello2 rok";
    }

    //@ GET Method @GetMapping
    //@ GET Method : 클라이언트가 서버에게 데이터를 받기위한 요청의 Method
    //@ @RequestMapping(method= {RequestMethod.GET}, value="get-method")와 똑같다.
    @GetMapping("get-method")
    public String getMethod() {
        return restApiService.getMethod();
    }

    //@ Post Method @PostMapping
    //@ Post Method : 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    //@ @RequestMapping(method= {RequestMethod.POST}, value="post-method")와 똑같다.
    //@ 실제 작성을 하기위한 용도임
    @PostMapping("post-method")
    public String postMethod() {
        return restApiService.postMethod(); 
    }

    //@ Patch Method @PatchMapping
    //@ Patch Method : 클라이언트가 서버에 데이터를 일부만 수정하기 위한 요청의 메소드
    //@ @RequestMapping(method= {RequestMethod.PATCH}, value="patch-method")와 똑같다.
    @PatchMapping("patch-method")
    public String patchMethod() {
        return restApiService.patchMethod(); 
    }

    //@ Delete Method @DeleteMapping
    //@ Delete Method : 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 Method
    //@ @RequestMapping(method= {RequestMethod.DELETE}, value="delete-method")와 똑같다.
    @DeleteMapping("delete-method")
    public String deleteMethod() {
        return restApiService.deleteMethod(); 
    } 

    //@ @PathVariable()로 Get, Delete Method에서 데이터 받기
    //@ 리소스에 지정한 패턴에 맞춰서 요청의 URL을 지정한다면 패턴에 맞춰 데이터를 받아오는 형식
    //@ ↓ URL 둘중 하나를 받을 때 
    @GetMapping({"path-variable/{data1}/{data2}", "path-variable/{data1}"})
    public String pathVariable(
        //@ ↓ 2개 이상 받을 때, 데이터 값을 입력받지 않을 때 required = false로 지정해주면 됨
        //@ required가 안오면 value 지워도 됨, 변수명은 쓰기 용도라서 달라도 됨
        @PathVariable("data1") String dataA,
        @PathVariable(value = "data2", required = false) String dataB
    ) {
        return dataA + dataB + " 데이터를 입력받았습니다.";
    }

    //@ @RequestParam으로 Get, Delete Method에서 데이터 받기
    //@ 완전한 path 뒤에 ?name=value[&...] 형식에 맞춰 name에 해당하는 value를 받아오는 형식
    @GetMapping("request-param")
    public String requestParam(
        @RequestParam String data1,
        @RequestParam String data2    
    ) {
        return data1 + data2 + " 데이터를 입력받았습니다.";
        // return dto.getData1() + dto.getData2() + " 데이터를 입력받았습니다.";
    }

    //@ @RequestBody로 Post, Put, Patch Method에서 데이터 받기
    //@ Request Body에 있는 데이터를 받기 위한 어노테이션
    //@ 객체형태로도 반환이 가능함
    //@ POSTMAN 기준으로 body부분에 값을 넣어줘야 됨
    @PostMapping("request-body")
    // public String requestBody(
    //     @RequestBody String data
    //     @RequestBody ParamDto dto
    // ) {
    //     return dto.getData1() + dto.getData2() + " 데이터를 입력받았습니다.";
    // }
    public ResponseEntity<ParamDto> requestBody(
        @RequestBody ParamDto dto
    ) {
        return ResponseEntity.status(408).body(dto);
    }

    @PostMapping("lombok")
    public ResponseEntity<ExampleResponseDto> lombok(
        //@ ↓ 적용 시켜줘야 됨
        @Valid
        @RequestBody ExampleDto requestBody
    ) {
        String data1 = requestBody.getParameter1();
        String data2 = requestBody.getParameter2();
        String data3 = requestBody.getParameter3();

        ExampleResponseDto responseData = ExampleResponseDto.builder().data1(data1).build();
        //@ 멤버변수에 값을 넣을 수 있는 것

        return ResponseEntity.status(200).body(responseData);
    }
}
