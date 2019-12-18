package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface INoteDAO {
	
	Note createNote(Note note);
	
	Note updateNote(Integer noteId,Note note);
	
	Note deleteNote(Integer noteId);
	
	Note getNoteById(Integer noteId);
	
	List<Note> getAllNotes();

}
