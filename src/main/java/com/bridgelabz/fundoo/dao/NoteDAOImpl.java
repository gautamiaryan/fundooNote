package com.bridgelabz.fundoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Note;

@Repository
public class NoteDAOImpl implements NoteDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void createNote(Note note) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(note);
		
	}

	@Override
	public void updateNote(Note note) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.update(note);
       			
	}

	@Override
	public void deleteNote(Integer noteId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Note note=currentSession.get(Note.class,noteId);
		currentSession.delete(note);
        
	}

	@Override
	public Note getNoteById(Integer noteId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Note note=currentSession.get(Note.class,noteId);
		return note;
	}

	@Override
	public List<Note> getAllNotes() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Note> query=currentSession.createQuery("from User",Note.class);
		List<Note> noteList=query.getResultList();
		return noteList;
	    
	}
	
	
	
	

	
}
