package com.harok.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.harok.board.dto.request.user.PostUserRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private String address;
    private boolean consentPersonalInformation;
    private String profileImageUrl;

    //@ UserServiceImplement에 만들면 코드가 복잡해져서 Entity에다가 따로 만듦
    public UserEntity(PostUserRequestDto dto) {
        this.email=dto.getUserEmail();
        this.password=dto.getUserPassword();
        this.nickname=dto.getUserNickname();
        this.phoneNumber=dto.getUserPhoneNumber();
        this.address=dto.getUserAddress();
        this.consentPersonalInformation=true;
        this.profileImageUrl=dto.getUserProfileImageUrl();
    }
}
