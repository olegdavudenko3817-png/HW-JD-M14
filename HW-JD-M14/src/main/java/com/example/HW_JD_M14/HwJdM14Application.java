package com.example.HW_JD_M14;

import com.example.HW_JD_M14.crud.NoteService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HwJdM14Application {

    @Autowired
    private NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(HwJdM14Application.class, args);
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