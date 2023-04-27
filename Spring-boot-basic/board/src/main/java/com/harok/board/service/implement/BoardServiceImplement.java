package com.harok.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harok.board.dto.request.board.PatchBoardRequestDto;
import com.harok.board.dto.request.board.PostBoardRequestDto;
import com.harok.board.dto.response.ResponseDto;
import com.harok.board.dto.response.board.GetBoardListResponseDto;
import com.harok.board.dto.response.board.GetBoardResponseDto;
import com.harok.board.entity.BoardEntity;
import com.harok.board.repository.BoardRepository;
import com.harok.board.repository.UserRepository;
import com.harok.board.service.BoardService;

@Service
public class BoardServiceImplement implements BoardService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImplement(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository=userRepository;
        this.boardRepository=boardRepository;
    } 

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {
        
        ResponseDto body = null;

        String boardWriterEmail = dto.getBoardWriterEmail();

        try {
           //# 존재하지 않은 유저 오류 반환 
           boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
           if (!existedUserEmail) {
                ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
           }

           BoardEntity boardEntity = new BoardEntity(dto);
           boardRepository.save(boardEntity);

           body = new ResponseDto("SU", "SUCCESS");

        } catch (Exception exception) {
            //# 데이터베이스 오류 반환
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "DataBase Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        //# 성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer BoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardTop3'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
    
}
