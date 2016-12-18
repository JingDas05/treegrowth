package com.treegrowth.web.api;

import com.treegrowth.model.mybatis.entity.Note;
import com.treegrowth.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/notes")
public class NoteApi {

    @Autowired
    private NoteService noteService;

    @RequestMapping(method = POST)
    public void createNote(@RequestBody Note note) {
       noteService.createNote(note);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Note noteDetail(@PathVariable(value = "id") String noteId) {
        return noteService.getNote(noteId);
    }

}
