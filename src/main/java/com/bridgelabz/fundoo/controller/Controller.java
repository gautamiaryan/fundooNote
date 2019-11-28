package com.bridgelabz.fundoo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.dto.NoteDTO;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.service.NoteService;

@RestController
@RequestMapping("/note")
public class Controller {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/create")
	public ResponseEntity<Response> create(@Valid @RequestBody NoteDTO noteDTO){
		if(noteService.isCreated(noteDTO)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Successfully created"),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Unsuccessfull"),HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id){
		if(noteService.isDeleted(id)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Successfully deleted id number"+id),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Note with id numer"+id),HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Response> update(@PathVariable Integer id,@RequestBody NoteDTO noteDTO){
		if(noteService.isUpdated(id, noteDTO)) {
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Successfully updated id number"+id),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Not updated Note with id numer"+id),HttpStatus.BAD_REQUEST);

		
	}
	
	
	

}
