package com.harok.firstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harok.firstproject.entity.ExampleEntity;

//@ ↓ JpaRepository<테이블이름, pk의 타입>
@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> { 
    
    public ExampleEntity findByPk(int pk);                          //@ ↓ 매개변수 이름은 아무거나 상관 x
    public List<ExampleEntity> findByExampleColumn3AndExampleColumn2(boolean exampleColumn3, String exampleColumn2);
                            //@ 하지만 ↑ 여기 순서는 중요
    public boolean existsByExampleColumn3(boolean exampleColumn3);
}
