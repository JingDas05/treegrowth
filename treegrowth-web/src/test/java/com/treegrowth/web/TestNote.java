package com.treegrowth.web;

import com.treegrowth.dao.mybatis.NoteMapper;
import com.treegrowth.model.mybatis.entity.Note;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {WebApplication.class})
public class TestNote {

    @Autowired
    private NoteMapper noteMapper;

    @ClassRule
    public static OutputCapture out = new OutputCapture();

    @Test
    public void test() {
        String output = out.toString();
        Long id = Long.parseLong(UUID.randomUUID().toString());
        Note note = new Note();
        note.setId(id);
        note.setName("测试");
        noteMapper.insertNote(note);
        assertTrue(noteMapper.selectNote(id).getName().equals("测试"));
    }
}
