package com.example.Journal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Journal.entity.MyEntry;
import com.example.Journal.repository.MyEntryRepository;


@Service
public class MyEntryService {

    @Autowired
    private MyEntryRepository myEntry;
    
    public void saveMyEntry(MyEntry entry){
        myEntry.save(entry);
    }

    public List<MyEntry> getAllEntry(){
        return myEntry.findAll();
    }
    
    public void deleteById(int id) {
        myEntry.deleteById(id);
    }
    
}
