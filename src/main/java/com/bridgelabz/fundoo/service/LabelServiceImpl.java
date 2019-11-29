package com.bridgelabz.fundoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundoo.dao.LabelDAO;
import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
@Service
public class LabelServiceImpl implements LabelService{
	
	@Autowired
	private LabelDAO labelDAO;
	
    @Transactional
	@Override
	public boolean isCreated(LabelDTO labelDTO) {
		Label label=labelDTOToLabel(labelDTO);
		Label labelObj=labelDAO.create(label);
		if(labelObj!=null) {
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean isDeleted(Integer labelId) {
		Label label=labelDAO.delete(labelId);
		if(label!=null) {
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean isUpadated(Integer labelId, LabelDTO labelDTO) {
		Label labelObj=labelDTOToLabel(labelDTO);
		Label label=labelDAO.update(labelId, labelObj);
		if(label!=null) {
			return true;
		}
		return false;
		
	}
	public Label labelDTOToLabel(LabelDTO labelDTO) {
		
		Label label = new Label();
		label.setName(labelDTO.getName());
		return label;
		
	}
	

}
