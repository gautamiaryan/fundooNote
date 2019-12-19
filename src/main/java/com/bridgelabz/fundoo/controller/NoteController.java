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
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/notes/create/{token}")
	public ResponseEntity<Response> create(@Valid @RequestBody NoteDTO noteDTO,@PathVariable String token){
		noteService.create(noteDTO,token);
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Successfully created"),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/notes/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id ,@PathParam("token") String token){
		    noteService.delete(id,token);
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Successfully deleted id number"+id),HttpStatus.OK);
		
		
	}
	
	@PostMapping("/notes/update/{id}")
	public ResponseEntity<Response> update( @PathVariable Integer id,@RequestBody NoteDTO noteDTO,@PathParam("token") String token){
		noteService.update(id, noteDTO,token);
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Successfully updated id number"+id),HttpStatus.OK);
		
	}
	
	@GetMapping("/notes")
	public ResponseEntity<Response> getAllNotes(String token){
		List<Note> noteList=noteService.showAllNotes(token);
		if(noteList.isEmpty()) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"List is Empty",noteList),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"List of Notes ",noteList),HttpStatus.OK);

	}
	
	
	

}
