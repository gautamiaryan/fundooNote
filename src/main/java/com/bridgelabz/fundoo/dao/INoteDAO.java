package com.bridgelabz.fundoo.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface INoteDAO {
	
	Note createNote(Note note,Long userId);
	
	Note updateNote(Long noteId,Note note,Long userId);
	
	Note deleteNote(Long noteId,Long userId);
	
	Note getNoteById(Long noteId);
	
	List<Note> getAllNotes(String token);
	
	List<Note> getAllTrashed(Long userId);
	
	List<Note> getAllPinned(Long userId);
	
	List<Note> getAllArchieved(Long userId);
	
	List<Note> getNotesOfSameLabel(Long userId,Long labelId);
	
	boolean setTrashed(Long userId,Long noteId);
	  
	boolean setRestored(Long userId,Long noteId);
	
	boolean setArchieved(Long userId,Long noteId);
	
	boolean setUnachieved(Long userId,Long noteId);
	
	boolean setPinned(Long userId,Long noteId);
	
	boolean setUnpinned(Long userId,Long noteId);

    boolean setRemaineder(Long userId,Long noteId,LocalDateTime time);
    
    boolean setColor(Long userId,Long noteId,String color);
}
