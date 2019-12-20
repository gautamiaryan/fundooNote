package com.bridgelabz.fundoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundoo.dao.ILabelDAO;
import com.bridgelabz.fundoo.dto.LabelDTO;
import com.bridgelabz.fundoo.model.Label;
@Service
public class LabelServiceImpl implements ILabelService{
	
	@Autowired
	private ILabelDAO labelDAO;
	
    @Transactional
	@Override
	public boolean isCreated(LabelDTO labelDTO,String token) {
		Label label=labelDTOToLabel(labelDTO);
		Label labelObj=labelDAO.create(label,token);
		if(labelObj!=null) {
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean isDeleted(Integer labelId,String token) {
		Label label=labelDAO.delete(labelId,token);
		if(label!=null) {
			return true;
		}
		return false;
	}
    @Transactional
	@Override
	public boolean isUpadated(Integer labelId, LabelDTO labelDTO,String token) {
		Label labelObj=labelDTOToLabel(labelDTO);
		Label label=labelDAO.update(labelId, labelObj,token);
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
	@Override
	public List<Label> getAllLabel(String token) {
		return labelDAO.getAllLabel();
	}
	
	
}
