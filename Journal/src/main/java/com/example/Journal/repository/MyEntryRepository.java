package com.example.Journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Journal.entity.MyEntry;


@Repository
public interface MyEntryRepository extends JpaRepository<MyEntry,Integer>{

    
}