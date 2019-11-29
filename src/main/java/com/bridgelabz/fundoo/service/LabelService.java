package com.bridgelabz.fundoo.service;

import com.bridgelabz.fundoo.dto.LabelDTO;

public interface LabelService {
	
	boolean isCreated(LabelDTO labelDTO);
	
	boolean isDeleted(Integer labelId);
	
	boolean isUpadated(Integer labelId,LabelDTO labelDTO);
}
