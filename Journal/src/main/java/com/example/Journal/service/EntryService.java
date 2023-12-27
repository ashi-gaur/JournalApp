package com.example.Journal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.Journal.entity.Entry;
import com.example.Journal.repository.EntryRepository;


@Service
public class EntryService {
    
    @Autowired
    private EntryRepository repo;

    public void save(Entry e){
        repo.save(e);
    }
    public List<Entry> getAllEntry(){
        return repo.findAll();
    }
    public Entry getEntryById(int id){
        return repo.findById(id).get();
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
