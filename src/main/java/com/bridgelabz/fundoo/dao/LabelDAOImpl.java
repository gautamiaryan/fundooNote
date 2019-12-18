package com.bridgelabz.fundoo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoo.model.Label;
@Repository
public class LabelDAOImpl  implements ILabelDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Label create(Label label) {
		Session currentSession=entityManager.unwrap(Session.class);
		int status=0;
		status=(int) currentSession.save(label);
		if(status!=0) {
			return label;
		}
		return null;
	}

	@Override
	public Label delete(Integer labelId) {
		Session currentSession=entityManager.unwrap(Session.class);
		Label label=currentSession.get(Label.class, labelId);
		if(label!=null) {
			currentSession.delete(label);
			return label;
		}
		return label;
	}

	@Override
	public Label update(Integer labelId, Label label) {
		Session currentSession=entityManager.unwrap(Session.class);
		Label labelObj=currentSession.get(Label.class, labelId);
		if(labelObj!=null) {
			currentSession.update(label);
			return label;
		}
		return labelObj;
		
	}

	@Override
	public List<Label> getAllLabel() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Label> query=currentSession.createQuery("from Label",Label.class);
		return query.getResultList();
		
	}

	
	
	
	
	

}
