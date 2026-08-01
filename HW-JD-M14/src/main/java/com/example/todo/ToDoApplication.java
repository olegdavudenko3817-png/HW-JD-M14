package com.example.todo;

import com.example.todo.crud.NoteService;
import com.example.todo.entity.Note;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication {
    @Autowired
    private NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Note note = new Note();
        note.setTitle("Hello World");
        note.setContent("This is a note");


        Note saved = noteService.add(note);

        System.out.println("Created: " + saved.getId());
        System.out.println("All notes: " + noteService.listAll());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("End Test");
    }

}