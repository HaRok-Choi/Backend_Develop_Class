package com.harok.board.dto.request.board2;

import javax.validation.constraints.NotBlank;

import com.harok.board.dto.request.board.PatchBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto2 {
    @NotBlank
    private Integer boardNumber;
    //@ int로 작성하면 @NotBlank를 쓰지 못함 그래서 Integer로 씀
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PatchBoardRequestDto2(PatchBoardRequestDto dto) {
        this.boardNumber=dto.getBoardNumber();
        this.boardTitle=dto.getBoardTitle();
        this.boardContent=dto.getBoardContent();
        this.boardImageUrl=dto.getBoardImageUrl();
    }
}
