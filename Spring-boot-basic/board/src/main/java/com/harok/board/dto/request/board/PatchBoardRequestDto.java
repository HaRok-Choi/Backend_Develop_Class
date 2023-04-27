package com.harok.board.dto.request.board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto {
    @NotBlank
    @Email
    private String userEmail;
    @NotBlank
    private Integer boardNumber;
    //@ int로 작성하면 @NotBlank를 쓰지 못함 그래서 Integer로 씀
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;
}
