package com.bridgelabz.fundoo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.model.Note;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.service.INoteService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Fundoo Notes ")
public class NoteController {
	
	@Autowired
	private INoteService noteService;
	
	@PostMapping("/notes/create")
	public ResponseEntity<Response> create(@Valid @RequestBody NoteDTO noteDTO,@RequestHeader String token){
		noteService.create(noteDTO,token);
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Successfully created"),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/notes/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id ,@RequestHeader String token){
		    noteService.delete(id,token);
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Successfully deleted id number"+id),HttpStatus.OK);
		
		
	}
	
	@PostMapping("/notes/update/{id}")
	public ResponseEntity<Response> update( @PathVariable Long id,@RequestBody NoteDTO noteDTO,@RequestHeader String token){
		noteService.update(id, noteDTO,token);
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Successfully updated id number"+id),HttpStatus.OK);
		
	}
	
	@GetMapping("/notes")
	public ResponseEntity<Response> getAllNotes(@RequestParam(value = "token") String token){
		List<Note> noteList=noteService.showAllNotes(token);
		if(noteList.isEmpty()) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"List is Empty",noteList),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Notes ",noteList),HttpStatus.OK);

	}
	
	@GetMapping("/trashednotes")
	public ResponseEntity<Response> getTrashedNotes(@RequestHeader String token){
		List<Note> trashedNotes=noteService.getTrashed(token);
		if(trashedNotes.isEmpty()) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"List is Empty",trashedNotes),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Trashed notes",trashedNotes),HttpStatus.OK);
	}
	
	@GetMapping("/archievednotes")
	public ResponseEntity<Response> getArchievedNotes(@RequestHeader String token){
		List<Note> archievedNotes=noteService.getTrashed(token);
		if(archievedNotes.isEmpty()) {
			return new ResponseEntity<> (new Response(HttpStatus.BAD_REQUEST.value(),"List is Empty",archievedNotes),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Archieved Notes",archievedNotes),HttpStatus.OK);
	}
	
	@GetMapping("/pinnedNotes")
	public ResponseEntity<Response> getPinnedNotes(@RequestHeader String token){
		List<Note> pinnedNotes=noteService.getPinned(token);
		if(pinnedNotes.isEmpty()) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"List is Empty",pinnedNotes),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Pinned Notes",pinnedNotes),HttpStatus.OK);
	}
	
	
	
	

}
