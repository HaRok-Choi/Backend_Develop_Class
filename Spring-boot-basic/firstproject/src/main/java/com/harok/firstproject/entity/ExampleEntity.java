package com.harok.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Example") //@ Example의 이름을 써야 된다.
@Table(name = "Example")
public class ExampleEntity {
    //@ java네이밍 규칙은 카멜케이스, db테이블에는 (_소문자) 해야됨.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "example_column1", nullable = false, unique = true)
    private int pk;
    private String exampleColumn2;
    private boolean exampleColumn3;
}
