package com.example.HW_JD_M14.crud;

import com.example.HW_JD_M14.entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {

    private final Map<Long, entity.Note> noteMap = new HashMap<Long, entity.Note>();
    private long nextId = 1;

    @Override
    public List<entity.Note> listAll() {
        return new ArrayList<entity.Note>(noteMap.values());
    }

    @Override
    public entity.Note add(entity.Note note) {
        note.setId(nextId++);
        noteMap.put(note.getId(), note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new RuntimeException("Note with id: " + id + " does not exist");
        }
        noteMap.remove(id);
    }

    @Override
    public void update(entity.Note note) {
        entity.Note foundNote = noteMap.get(note.getId());

        if (foundNote == null) {
            throw new RuntimeException("Note with id: " + note.getId() + " does not exist");
        }
        foundNote.setTitle(note.getTitle());
        foundNote.setContent(note.getContent());
    }

    @Override
    public entity.Note getById(long id) {
        entity.Note note = noteMap.get(id);

        if (note == null) {
            throw new RuntimeException("Note with id: " + id + " does not exist");
        }
        return note;
    }
}
