package com.harok.board.dto.request.board2;

import javax.validation.constraints.NotBlank;

import com.harok.board.dto.request.board.PostBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostBoardRequestDto2 {
    public PostBoardRequestDto2(PostBoardRequestDto dto) {
    }
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;
}
