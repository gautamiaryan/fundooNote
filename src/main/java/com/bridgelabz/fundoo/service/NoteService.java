package com.bridgelabz.fundoo.service;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;

public interface NoteService {
	
	boolean  isCreated(NoteDTO noteDTO);
	
	boolean isUpdated(Integer id,NoteDTO noteDTO);
	
	boolean isDeleted(Integer noteId);

}
