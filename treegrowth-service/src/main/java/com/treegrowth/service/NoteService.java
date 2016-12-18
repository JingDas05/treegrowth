package com.treegrowth.service;

import com.treegrowth.model.mybatis.entity.Note;

public interface NoteService {

    void createNote(Note note);

    Note getNote(String noteId);
}
