package com.example.HW_JD_M14.crud;

import com.example.HW_JD_M14.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {

    private final Map<Long, Note> noteMap = new HashMap<Long, Note>();
    private long nextId = 1;

    @Override
    public List<Note> listAll() {

        return new ArrayList<Note>(noteMap.values());

    }

    @Override
    public Note add(Note note) {

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
    public void update(Note note) {
        Note foundNote = noteMap.get(note.getId());

        if (foundNote == null) {
            throw new RuntimeException("Note with id: " + note.getId() + " does not exist");
        }

        foundNote.setTitle(note.getTitle());
        foundNote.setContent(note.getContent());

    }

    @Override
    public Note getById(long id) {

        Note note = noteMap.get(id);

        if (note == null) {
            throw new RuntimeException("Note with id: " + id + " does not exist");
        }
        return note;
    }

}
