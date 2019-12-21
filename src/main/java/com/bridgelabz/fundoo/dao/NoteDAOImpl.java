package com.bridgelabz.fundoo.dao;

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
	public Note createNote(Note note,Long userId) {
		Session currentSession=entityManager.unwrap(Session.class);  
	    note.setUserId(userId);
		Integer id;
		id = (Integer)currentSession.save(note);
		if (id != 0) {
			return note;
		}
		return null;

	}

	@Override
	public Note updateNote(Long noteId,Note note,Long userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note noteObj = currentSession.get(Note.class, noteId);
		if(noteObj!=null) {
			note.setUserId(userId);
			currentSession.update(note);
			return note;
		}
		return noteObj;

	}

	@Override
	public Note deleteNote(Long noteId,Long userId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		
		if(note!=null) {
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
		Long user_id=Long.valueOf(token);
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Note> query = currentSession.createQuery("from Note where user_id="+user_id, Note.class);
		List<Note> noteList = query.getResultList();
		return noteList;
	}

}
