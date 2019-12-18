package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Label;

public interface ILabelDAO {
	
	Label create(Label label);
	
	Label delete(Integer labelId);
	
	Label update(Integer labelId,Label label);
	
	List<Label> getAllLabel();

}
