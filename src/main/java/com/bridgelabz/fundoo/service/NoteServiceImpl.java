package com.bridgelabz.fundoo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundoo.dao.NoteDAO;
import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;

	@Transactional
	@Override
	public boolean isCreated(NoteDTO noteDTO) {
		Note note = noteDTOToNote(noteDTO);
		Note noteObj = noteDAO.createNote(note);
		if (noteObj != null) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean isUpdated(Integer noteId, NoteDTO noteDTO) {
		Note note = noteDAO.getNoteById(noteId);
		if (noteDTO.getTitle() != null) {
			note.setTitle(noteDTO.getTitle());
		}
		if (noteDTO.getDescription() != null) {
			note.setDescription(noteDTO.getDescription());
		}
        note.setUpdatedStamp(LocalDateTime.now());
		if (noteDAO.updateNote(noteId, note) != null) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean isDeleted(Integer noteId) {
		noteDAO.deleteNote(noteId);
		return true;
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

}
