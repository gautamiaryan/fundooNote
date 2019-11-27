package com.bridgelabz.fundoo.service;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;

public interface NoteService {
	
	Note create(NoteDTO noteDTO);
	
	Note update(NoteDTO noteDTO);
	
	Note delete(Integer noteId);

}
