package com.bridgelabz.fundoo.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Note;

@Repository
public class NoteDAOImpl implements INoteDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Note createNote(Note note, Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		note.setUserId(userId);
		Integer id;
		id = (Integer) currentSession.save(note);
		if (id != 0) {
			return note;
		}
		return null;

	}

	@Override
	public Note updateNote(Long noteId, Note note, Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note noteObj = currentSession.get(Note.class, noteId);
		if (noteObj != null) {
			note.setUserId(userId);
			currentSession.update(note);
			return note;
		}
		return noteObj;

	}

	@Override
	public Note deleteNote(Long noteId, Long userId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);

		if (note != null) {
			note.setUserId(userId);
			currentSession.delete(note);
			return note;
		}
		return note;
	}

	@Override
	public Note getNoteById(Long noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		return note;
	}

	@Override
	public List<Note> getAllNotes(String token) {
		Long user_id = Long.valueOf(token);
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from Note where user_id=" + user_id, Note.class);
		List<Note> noteList = query.getResultList();
		return noteList;
	}

	@Override
	public List<Note> getAllTrashed(Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from Note where user_id=" + userId + "and note_trash=true",
				Note.class);
		return query.getResultList();
	}

	@Override
	public List<Note> getAllPinned(Long userId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Note> query=currentSession.createQuery("from Note where user_id="+userId+"and note_archieve =true",Note.class);
        return query.getResultList();
	}

	@Override
	public List<Note> getAllArchieved(Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from Note where user_id=" + userId + "and note_pin=true",Note.class);
		return query.getResultList();
	}

	@Override
	public List<Note> getNotesOfSameLabel(Long userId, Long labelId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Note> query=currentSession.createQuery("from Note where user_id"+userId+"and labelId="+labelId,Note.class);
		return query.getResultList();
	}

	@Override
	public boolean setRestored(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
		if(note.isTrashed()) {
			note.setTrashed(false);
			note.setUpdatedStamp(LocalDateTime.now());
			currentSession.save(note);
			return true;
		}
		return false;
		}
		
		return false;
		
	}

	@Override
	public boolean setTrashed(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
		if(!note.isTrashed()) {
			note.setTrashed(true);
			note.setUpdatedStamp(LocalDateTime.now());
			currentSession.save(note);
			return true;
		}
		return false;
		}
		
		return false;
	}

	@Override
	public boolean setArchieved(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			if(!note.isArchieve()) {
				note.setArchieve(true);
				note.setPinned(false);
				note.setUpdatedStamp(LocalDateTime.now());
				currentSession.save(note);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean setUnachieved(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			if(note.isArchieve()) {
				note.setArchieve(false);
				note.setUpdatedStamp(LocalDateTime.now());
				currentSession.save(note);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean setPinned(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			if(!note.isPinned()) {
				note.setArchieve(false);
				note.setPinned(true);
				note.setTrashed(false);
				note.setUpdatedStamp(LocalDateTime.now());
				currentSession.save(note);
				return true;
			}
			return false;
		}
		
		return false;
	}

	@Override
	public boolean setUnpinned(Long userId, Long noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			if(note.isPinned()) {
				note.setPinned(false);
				note.setUpdatedStamp(LocalDateTime.now());
				currentSession.save(note);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean setRemaineder(Long userId, Long noteId, LocalDateTime time) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			note.setRemainder(time);
			currentSession.save(note);
			return true;
		}
		return false;
	}

	@Override
	public boolean setColor(Long userId, Long noteId, String color) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note =getNoteById(noteId);
		if(note.getUserId().equals(userId)) {
			note.setColor(color);
			currentSession.save(note);
			return true;
		}
		return false;
	}
	
	
	
	

}
