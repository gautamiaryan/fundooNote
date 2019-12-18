package com.bridgelabz.fundoo.service;

import java.util.List;

import com.bridgelabz.fundoo.model.Note;

public interface ElasticSearch {
	
	String CreateNote(Note note);

	String UpdateNote(Note note);

	String DeleteNote(Note note);

	List<Note> searchbytitle(String title);

}
