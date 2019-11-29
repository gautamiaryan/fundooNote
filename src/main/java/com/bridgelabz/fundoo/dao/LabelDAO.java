package com.bridgelabz.fundoo.dao;

import com.bridgelabz.fundoo.model.Label;

public interface LabelDAO {
	
	Label create(Label label);
	
	Label delete(Integer labelId);
	
	Label update(Integer labelId,Label label);

}
