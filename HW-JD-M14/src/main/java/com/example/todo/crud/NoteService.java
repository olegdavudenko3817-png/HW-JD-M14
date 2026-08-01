package com.example.todo.crud;

import com.example.todo.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);

}
