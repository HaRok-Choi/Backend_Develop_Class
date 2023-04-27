package com.harok.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.harok.board.entity.primaryKey.LikeyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Likey")
@Table(name = "Likey")
@IdClass(LikeyPk.class)
//@ ↑ PK 설정한것들을 받아옴
public class LikeyEntity {
    
    @Id
    private int boardNumber;
    @Id
    private String userEmail;
    
}
