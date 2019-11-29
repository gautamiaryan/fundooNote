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

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.service.LabelService;

@RestController
@RequestMapping("label")
public class LabelController {
	
	@Autowired
	private LabelService labelService;
	
	@PostMapping("/create")
	public ResponseEntity<Response> create(@Valid @RequestBody LabelDTO labelDTO){
		
		if(labelService.isCreated(labelDTO)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Label successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not created"),HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/update/{labelId}")
	public ResponseEntity<Response> update(@Valid @PathVariable Integer labelId,@RequestBody LabelDTO labelDTO){
		if(labelService.isUpadated(labelId, labelDTO)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Successfully Updated"),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not updated"),HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/{labelId}")
	public ResponseEntity<Response> delete(@Valid @PathVariable Integer labelId){
		if(labelService.isDeleted(labelId)) {
			return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Sucessfully deleted"),HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST.value(),"label with this id not found"),HttpStatus.BAD_REQUEST);
		
	}

}
