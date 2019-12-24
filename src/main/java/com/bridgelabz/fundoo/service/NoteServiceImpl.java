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

import reactor.core.publisher.Mono;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private INoteDAO noteDAO;

	@Autowired
	private WebClientService webClientService;
	
	@Transactional
	@Override
	public String create(NoteDTO noteDTO, String tocken) {
		Long user_id = webClientService.getUserId(tocken);
		if (user_id != 0) {
			Note note = noteDTOToNote(noteDTO);
			Note noteObj = noteDAO.createNote(note, user_id);
			if (noteObj != null) {
				return "Note is Created";
			}
		}
		return "Note is not Created";
	}

	@Transactional
	@Override
	public String update(Long noteId, NoteDTO noteDTO, String token) {
		Note note = noteDAO.getNoteById(noteId);
		Long user_id = webClientService.getUserId(token);
		if (user_id != 0) {
			if (noteDTO.getTitle() != null) {
				note.setTitle(noteDTO.getTitle());
			}
			if (noteDTO.getDescription() != null) {
				note.setDescription(noteDTO.getDescription());
			}
			note.setUpdatedStamp(LocalDateTime.now());
			if (noteDAO.updateNote(noteId, note, user_id) != null) {
				return "Note is updated";
			}
		}
		return "Note is not updated";

	}

	@Transactional
	@Override
	public String delete(Long noteId, String token) {
		Long user_id = webClientService.getUserId(token);
		if (user_id != 0) {
			Note note = noteDAO.deleteNote(noteId,user_id);
			if (note != null) {
				return "Note is deleted";
			}
		}
		return "Note is not found";
	}

	public Note noteDTOToNote(NoteDTO noteDTO) {
		Note note = new Note();
		note.setTitle(noteDTO.getTitle());
		note.setDescription(noteDTO.getDescription());
		note.setPinned(false);
		note.setTrashed(false);
		note.setArchieve(false);
		note.setColor(null);
		note.setCreatedStamp(LocalDateTime.now());
		note.setUpdatedStamp(LocalDateTime.now());
		note.setRemainder(LocalDateTime.now());
		return note;

	}
    @Transactional
	@Override
	public List<Note> showAllNotes(String token) {
		
		List<Note> noteList = noteDAO.getAllNotes(token);
		if (noteList != null) {
			return noteList;
		}
		return null;
	}
    @Transactional
	@Override
	public List<Note> getArchieved(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> archievedNotes=null;
		if(userId!=null) {
			archievedNotes=noteDAO.getAllArchieved(userId);
		}
		return archievedNotes;
	}
    @Transactional
	@Override
	public List<Note> getTrashed(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> trashedNotes=null;
		if(userId!=null) {
			trashedNotes=noteDAO.getAllTrashed(userId);
		}
		return trashedNotes;
	}
    @Transactional
	@Override
	public List<Note> getPinned(String token) {
		Long userId=webClientService.getUserId(token);
		List<Note> pinnedNotes=null;
		if(userId!=null) {
			pinnedNotes=noteDAO.getAllPinned(userId);
		}
		return pinnedNotes;
	}

}
