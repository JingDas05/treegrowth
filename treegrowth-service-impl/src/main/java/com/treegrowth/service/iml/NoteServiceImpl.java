package com.treegrowth.service.iml;

import com.treegrowth.dao.mybatis.NoteMapper;
import com.treegrowth.model.mybatis.entity.Note;
import com.treegrowth.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public void createNote(Note note) {
        noteMapper.insertNote(note);
    }

    @Override
    public Note getNote(Long noteId) {
        return noteMapper.selectNote(noteId);
    }
}
