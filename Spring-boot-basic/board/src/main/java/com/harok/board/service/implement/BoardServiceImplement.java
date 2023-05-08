package com.harok.board.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harok.board.common.util.CustomResponse;
import com.harok.board.dto.request.board.PatchBoardRequestDto;
import com.harok.board.dto.request.board.PostBoardRequestDto;
import com.harok.board.dto.request.board2.PatchBoardRequestDto2;
import com.harok.board.dto.request.board2.PostBoardRequestDto2;
import com.harok.board.dto.response.ResponseDto;
import com.harok.board.dto.response.board.GetBoardListResponseDto;
import com.harok.board.dto.response.board.GetBoardResponseDto;
import com.harok.board.entity.BoardEntity;
import com.harok.board.entity.CommentEntity;
import com.harok.board.entity.LikeyEntity;
import com.harok.board.entity.UserEntity;
import com.harok.board.entity.resultSet.BoardListResultSet;
import com.harok.board.repository.BoardRepository;
import com.harok.board.repository.CommentRepository;
import com.harok.board.repository.LikeyRepository;
import com.harok.board.repository.UserRepository;
import com.harok.board.service.BoardService;

@Service
public class BoardServiceImplement implements BoardService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private CommentRepository commentRepository;
    private LikeyRepository likeyRepository;

    @Autowired
    public BoardServiceImplement(
        UserRepository userRepository, 
        BoardRepository boardRepository,
        CommentRepository commentRepository,
        LikeyRepository likeyRepository
        ) {
        this.userRepository=userRepository;
        this.boardRepository=boardRepository;
        this.commentRepository=commentRepository;
        this.likeyRepository=likeyRepository;
    } 

     @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {

        String boardWriterEmail = dto.getBoardWriterEmail();
        PostBoardRequestDto2 dto2 = new PostBoardRequestDto2(dto);

        ResponseEntity<ResponseDto> response = postBoard(boardWriterEmail, dto2);

        return response;
    }

    @Override
    public ResponseEntity<ResponseDto> postBoard(String userEmail, PostBoardRequestDto2 dto) {
        
        ResponseDto body = null;

        try {
           //# 존재하지 않은 유저 오류 반환 
           boolean existedUserEmail = userRepository.existsByEmail(userEmail);
           if (!existedUserEmail) {
                ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
           }

           BoardEntity boardEntity = new BoardEntity(userEmail, dto);
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
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
       
        GetBoardResponseDto body = null;

        try {

            if (boardNumber == null) return CustomResponse.validationFailed();
           
            //# 존재하지 않는 게시물 번호
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return CustomResponse.notExistBoardNumber();

            int viewCount = boardEntity.getViewCount();
            boardEntity.setViewCount(++viewCount);
            boardRepository.save(boardEntity);

            String boardWriterEmail = boardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByEmail(boardWriterEmail);
            List<CommentEntity> commentEntities = commentRepository.findByBoardNumber(boardNumber);
            List<LikeyEntity> likeyEntities = likeyRepository.findByBoardNumber(boardNumber);

            body = new GetBoardResponseDto(boardEntity, userEntity, commentEntities, likeyEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {
        GetBoardListResponseDto body = null;

        try {
            List<BoardListResultSet> resultSet = boardRepository.getList();
            body = new GetBoardListResponseDto(resultSet);
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        GetBoardListResponseDto body = null;

        try {
            List<BoardListResultSet> resultSet = boardRepository.getTop3List();
            body = new GetBoardListResponseDto(resultSet);
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {
    
        String userEmail = dto.getUserEmail();
        PatchBoardRequestDto2 dto2 = new PatchBoardRequestDto2(dto);

        ResponseEntity<ResponseDto> response = patchBoard(userEmail, dto2);
       
        return response;
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchBoardRequestDto2 dto) {
        
        int boardNumber = dto.getBoardNumber();
        String boardTitle = dto.getBoardTitle();
        String boardContent = dto.getBoardContent();
        String boardImageUrl = dto.getBoardImageUrl();

        try {
            //# 1. 존재하지 않는 게시물 번호 반환
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return CustomResponse.notExistBoardNumber();

            //# 2. 존재하지 않는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(userEmail);
            if (!existedUserEmail) return CustomResponse.notExistUserEmail();

            //# 3. 권한 없음
            boolean equalWriter = boardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter) return CustomResponse.noPermissions();

            boardEntity.setTitle(boardTitle);
            boardEntity.setContent(boardContent);
            boardEntity.setBoardImageUrl(boardImageUrl);

            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            //# 4. 데이터베이스 에러
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        try {
            if (boardNumber == null) return CustomResponse.validationFailed();
            //# 1. 존재하지 않는 게시물 번호 반환
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return CustomResponse.notExistBoardNumber();

            //# 2. 존재하지 않는 유저 이메일 반환
            boolean existedUserEmail = userRepository.existsByEmail(userEmail);
            if (!existedUserEmail) return CustomResponse.notExistUserEmail();
            
            //# 3. 권한없음 반환
            boolean equalWriter = boardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter) return CustomResponse.noPermissions();

            likeyRepository.deleteByBoardNumber(boardNumber);
            commentRepository.deleteByBoardNumber(boardNumber);
            boardRepository.delete(boardEntity);
            //@ 지금 같이 위와 해도 에러가 뜸(트랜잭션 자체를 건드리는건 안좋음)
            //@ 그래서 Repository부분에 @Transactional을 추가해주어야 한다.
          
        } catch (Exception exception) {
            exception.printStackTrace();
            //# 4. 데이터베이스 에러
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }
    
}
