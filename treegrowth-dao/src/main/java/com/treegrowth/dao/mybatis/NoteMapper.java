package com.treegrowth.dao.mybatis;

import com.treegrowth.model.mybatis.entity.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {

    @Insert("INSERT into tg_notes(id,name) VALUES(#{id},#{name})")
    void insertNote(Note note);

    @Delete("DELETE FROM tg_notes where id =#{id}")
    void deleteNote(Long id);

    @Update("UPDATE tg_notes SET id=#{id}, name=#{name}")
    void updateNote(Note note);

    @Select("SELECT * from tg_notes WHERE id=#{id}")
    Note selectNote(Long id);

}
