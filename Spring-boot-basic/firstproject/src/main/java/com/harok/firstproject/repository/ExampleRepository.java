package com.harok.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harok.firstproject.entity.ExampleEntity;

//@ ↓ JpaRepository<테이블이름, pk의 타입>
@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> { 
    
}
