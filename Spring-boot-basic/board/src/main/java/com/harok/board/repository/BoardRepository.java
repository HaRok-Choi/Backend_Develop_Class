package com.harok.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harok.board.entity.BoardEntity;
import com.harok.board.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

    public BoardEntity findByBoardNumber(int boardNumber);

    //@ sql절이 다 끝나면 띄어쓰기 해줘야 됨
    @Query(
        value=
        "SELECT " +
        "B.board_number AS boardNumber," +
        "B.title AS boardTitle," +
        "B.content AS boardContent," +
        "B.board_image_url AS boardImageUrl," +
        "B.write_datetime AS boardWriteDatetime," +
        "B.view_count AS viewCount," +
        "U.email AS boardWriteEmail," +
        "U.nickname AS boardWriterNickname," +
        "U.profile_image_url AS boardWriterProfileImageUrl," +
        "count(DISTINCT C.comment_number) AS commentCount," +
        "count(DISTINCT L.user_email) AS LikeCount " +
        "FROM Board B, Comment C, Likey L, User U " +
        "WHERE B.board_number = C.board_number " +
        "AND B.board_number = L.board_number " +
        "AND B.writer_email = U.email " +
        "GROUP BY B.board_number " +
        "ORDER BY boardWritedatetime DESC;" ,
        nativeQuery = true
    )

    public List<BoardListResultSet> getList();

    @Query(
        value=
        "SELECT " +
        "B.board_number AS boardNumber," +
        "B.title AS boardTitle," +
        "B.content AS boardContent," +
        "B.board_image_url AS boardImageUrl," +
        "B.write_datetime AS boardWriteDatetime," +
        "B.view_count AS viewCount," +
        "U.email AS boardWriteEmail," +
        "U.nickname AS boardWriterNickname," +
        "U.profile_image_url AS boardWriterProfileImageUrl," +
        "count(DISTINCT C.comment_number) AS commentCount," +
        "count(DISTINCT L.user_email) AS LikeCount " +
        "FROM Board B, Comment C, Likey L, User U " +
        "WHERE B.board_number = C.board_number " +
        "AND B.board_number = L.board_number " +
        "AND B.writer_email = U.email " +
        "GROUP BY B.board_number " +
        "ORDER BY B.write_datetime DESC " +
        "LIMIT 3",
        nativeQuery = true
    )

    public List<BoardListResultSet> getTop3List();

}
