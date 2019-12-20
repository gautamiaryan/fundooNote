package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface INoteDAO {
	
	Note createNote(Note note,String token);
	
	Note updateNote(Integer noteId,Note note,String token);
	
	Note deleteNote(Integer noteId,String token);
	
	Note getNoteById(Integer noteId);
	
	List<Note> getAllNotes(String token);

}
