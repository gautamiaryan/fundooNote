package com.bridgelabz.fundoo.service;

import java.util.List;

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;

public interface ILabelService {
	
	boolean isCreated(LabelDTO labelDTO,String token);
	
	boolean isDeleted(Integer labelId,String token);
	
	boolean isUpadated(Integer labelId,LabelDTO labelDTO,String token);
	
	List<Label> getAllLabel(String token);
}
