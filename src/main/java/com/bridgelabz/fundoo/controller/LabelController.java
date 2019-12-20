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
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.service.ILabelService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Fundoo Notes ")
public class LabelController {
	
	@Autowired
	private ILabelService labelService;
	
	@PostMapping("labels/create")
	public ResponseEntity<Response> create(@Valid @RequestBody LabelDTO labelDTO,@RequestHeader String token){
		
		if(labelService.isCreated(labelDTO,token)) {
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Label successfully create"),HttpStatus.OK);
		}
		 return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not created"),HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("labels/update/{labelId}")
	public ResponseEntity<Response> update(@Valid @PathVariable Integer labelId,@RequestBody LabelDTO labelDTO,@RequestHeader String token){
		if(labelService.isUpadated(labelId, labelDTO,token)) {
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Successfully Updated"),HttpStatus.OK);
		}
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"Label not updated"),HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("labels/delete/{labelId}")
	public ResponseEntity<Response> delete(@Valid @PathVariable Integer labelId,@RequestHeader String token){
		if(labelService.isDeleted(labelId,token)) {
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"Sucessfully deleted"),HttpStatus.OK);
		}
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"label with this id not found"),HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/labels")
	public ResponseEntity<Response> getAllLabel(@RequestHeader String token){
		List<Label> labelList=labelService.getAllLabel(token);
		if(labelList.isEmpty()) {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),"No label found"),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"No label found",labelList),HttpStatus.OK);
	}

}
