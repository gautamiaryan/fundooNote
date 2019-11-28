package com.bridgelabz.fundoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Note createNote(Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
		int id = 0;
		id = (int) currentSession.save(note);
		if (id != 0) {
			return note;
		}
		return null;

	}

	@Override
	public Note updateNote(Integer noteId,Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note noteObj = currentSession.get(Note.class, noteId);
		if(noteObj!=null) {
			currentSession.update(note);
			return note;
		}
		return noteObj;

	}

	@Override
	public Note deleteNote(Integer noteId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		if(note!=null) {
		  currentSession.delete(note);
		  return note;
		}
		return note;

	}

	@Override
	public Note getNoteById(Integer noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Note note = currentSession.get(Note.class, noteId);
		return note;
	}

	@Override
	public List<Note> getAllNotes() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Note> query = currentSession.createQuery("from User", Note.class);
		List<Note> noteList = query.getResultList();
		return noteList;

	}

}
