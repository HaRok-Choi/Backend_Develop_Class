package com.harok.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.harok.board.entity.LikeyEntity;
import com.harok.board.entity.primaryKey.LikeyPk;

@Repository
//@ 복합형 타입일때는 PK에 대한 타입을 만들어줘야 함.
public interface LikeyRepository extends JpaRepository<LikeyEntity, LikeyPk>{
    
    List<LikeyEntity> findByBoardNumber(int boardNumber);

    @Transactional
    void deleteByBoardNumber(int boardNumber);

}
