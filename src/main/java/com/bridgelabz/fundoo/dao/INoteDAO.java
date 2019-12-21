package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface INoteDAO {
	
	Note createNote(Note note,Long userId);
	
	Note updateNote(Long noteId,Note note,Long userId);
	
	Note deleteNote(Long noteId,Long userId);
	
	Note getNoteById(Long noteId);
	
	List<Note> getAllNotes(String token);

}
