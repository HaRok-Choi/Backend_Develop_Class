package board.controller;

import java.util.List;

import board.common.constant.HttpStatus;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.DeleteBoardResponseDto;
import board.dto.response.board.GetBoardListResponseDto;
import board.dto.response.board.GetBoardResponseDto;
import board.dto.response.board.PatchBoardResponseDto;
import board.dto.response.board.PostBoardResponseDto;
import board.service.BoardService;

public class BoardController {
	
	private BoardService boardService;
	
	public BoardController() {
		boardService = new BoardService();
	}
	
	public void postBoard(PostBoardDto dto) {
//		작성자 이메일이 비었을때
		if (dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		
//		제목과 본문이 잘못됐을때
		if (dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<PostBoardResponseDto> response = boardService.postBoard(dto);
		System.out.println(response.toString());
	}
	
	public void getBoardList() {
//		List형식으로 보여질거기 때문에 제너릭안에 List로 묶는다.
		ResponseDto<List<GetBoardListResponseDto>> response = boardService.getBoardList();
		System.out.println(response.toString());
	}
	
//	boardNumber에 대한 입력검증
	public void getBoard(int boardNumber) {
		if (boardNumber <= 0) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
		System.out.println(response.toString());
	}
	
//	수정부분: 모든값이 입력됐는지, 작성자이메일이 비었는지
	public void patchBoard(PatchBoardDto dto) {
		if (dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		
		if (dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<PatchBoardResponseDto> response = boardService.patchBoard(dto);
		System.out.println(response.toString());
	}
	
//	입력한거 검증 및 삭제부분
	public void deleteBoard(int boardNumber, String email) {
		boolean auth = email.isBlank();
		if (auth) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		
		boolean valid = boardNumber <= 0;
		if (valid) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<List<DeleteBoardResponseDto>> response = boardService.deleteBoard(boardNumber, email);
		System.out.println(response.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
