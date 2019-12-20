package com.bridgelabz.fundoo.dao;

import java.util.List;

import com.bridgelabz.fundoo.model.Label;

public interface ILabelDAO {
	
	Label create(Label label,String token);
	
	Label delete(Integer labelId,String token);
	
	Label update(Integer labelId,Label label,String token);
	
	List<Label> getAllLabel();

}
