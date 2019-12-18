package com.bridgelabz.fundoo.service;

import java.util.List;

import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;

public interface ILabelService {
	
	boolean isCreated(LabelDTO labelDTO);
	
	boolean isDeleted(Integer labelId);
	
	boolean isUpadated(Integer labelId,LabelDTO labelDTO);
	
	List<Label> getAllLabel();
}
