package com.example.Journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Journal.entity.Entry;


@Repository
public interface EntryRepository extends JpaRepository<Entry,Integer>{

    
} 
