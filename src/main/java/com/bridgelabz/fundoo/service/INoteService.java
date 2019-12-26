package com.bridgelabz.fundoo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;

public interface INoteService {
	
	String create(NoteDTO noteDTO,String tocken);
	
	String  update(Long id,NoteDTO noteDTO,String token);
	
	String  delete(Long noteId,String token);
	
	List<Note> showAllNotes(String token);
	
	List<Note> getArchieved(String token);
	
	List<Note> getTrashed(String token);
    
	List<Note> getPinned(String token);
	
	boolean trashed(String token,Long noteId);
	
	boolean restored(String token,Long noteId);
	
	boolean pinned(String token,Long noteId);
	
	boolean unPinned(String token,Long noteId);
	
	boolean archieved(String token,Long noteId);
	
	boolean unarchieved(String token,Long noteId);
	
	boolean remindMe(String token,Long noteId,LocalDateTime time);
	
	boolean setColor(String token,Long noteId,String color);
	



}
