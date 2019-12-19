package com.bridgelabz.fundoo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundoo.dao.INoteDAO;
import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;
import com.bridgelabz.fundoo.util.JWTProvider;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private INoteDAO noteDAO;
	
	/*
	 * @Autowired private JWTProvider jwtProvider;
	 */
//	@Autowired
//	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public String create(NoteDTO noteDTO,String tocken) {
		
		Note note =noteDTOToNote(noteDTO);
		Note noteObj = noteDAO.createNote(note);
		if (noteObj != null) {
			return "Note is Created";
		}
		return "Note is not Created";
	}

	@Transactional
	@Override
	public String update(Integer noteId, NoteDTO noteDTO,String token) {
		Note note = noteDAO.getNoteById(noteId);
		if (noteDTO.getTitle() != null) {
			note.setTitle(noteDTO.getTitle());
		}
		if (noteDTO.getDescription() != null) {
			note.setDescription(noteDTO.getDescription());
		}
        note.setUpdatedStamp(LocalDateTime.now());
		if (noteDAO.updateNote(noteId, note) != null) {
			return "Note is updated";
		}
		return "Note is not updated";
		
	}

	@Transactional
	@Override
	public String delete(Integer noteId,String token) {
		Note note=noteDAO.deleteNote(noteId);
		if(note!=null) {
			return "Note is deleted";
		}
		return "Note is not found";
	}

	public Note noteDTOToNote(NoteDTO noteDTO) {
		Note note = new Note();
		note.setTitle(noteDTO.getTitle());
		note.setDescription(noteDTO.getDescription());
		note.setPinned(false);
		note.setTrashed(false);
		note.setColor(null);
		note.setCreatedStamp(LocalDateTime.now());
		note.setUpdatedStamp(LocalDateTime.now());
		note.setRemaindMe(LocalDateTime.now());
		return note;

	}

	@Override
	public List<Note> showAllNotes(String token) {
		List<Note> noteList=noteDAO.getAllNotes();
		if(noteList!=null) {
			return noteList;
		}
		return null;
	}

}
