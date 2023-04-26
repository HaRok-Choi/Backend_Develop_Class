package com.harok.board.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostUserRequestDto {
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userNickname;
    @NotBlank
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$") //@ <- 괄호 안 정규식이 들어가야 됨
    private String userPhoneNumber;
    @NotBlank
    private String userAddress;
    private String userProfileImageUrl;

}
