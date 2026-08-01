package com.example.HW_JD_M14.crud;

import com.example.HW_JD_M14.entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<entity.Note> listAll();
    entity.Note add(entity.Note note);
    void deleteById(long id);
    void update(entity.Note note);
    entity.Note getById(long id);

}
