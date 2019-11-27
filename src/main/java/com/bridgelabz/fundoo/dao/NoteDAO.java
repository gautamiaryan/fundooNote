package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface NoteDAO {
	
	void createNote(Note note);
	
	void updateNote(Note note);
	
	void deleteNote(Integer noteId);
	
	Note getNoteById(Integer noteId);
	
	List<Note> getAllNotes();

}
