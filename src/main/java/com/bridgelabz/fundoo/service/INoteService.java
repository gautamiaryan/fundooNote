package com.bridgelabz.fundoo.service;

import java.util.List;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;

public interface INoteService {
	
	String create(NoteDTO noteDTO,String tocken);
	
	String  update(Integer id,NoteDTO noteDTO,String token);
	
	String  delete(Integer noteId,String token);
	
	List<Note> showAllNotes(String token);

}
