package com.testsp.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.testsp.data.Teacher;


@Component
public class TeacherService {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addTeacher(Teacher tea){
		//Acquire session
		Session session = sessionFactory.getCurrentSession();
		 // Save teacher, saving behavior get done in a transactional manner
        session.save(tea);
	}
	
	@Transactional
	public List<Teacher> getTeachers(){
		return getSessionFactory().getCurrentSession()
				.createQuery("from Teacher t ORDER BY t.teaId ASC").list();
	}


	@Transactional
	public void deleteTeacher(Teacher teacher){
				
		getSessionFactory().getCurrentSession().delete(teacher);
	}
	
	@Transactional
	public void updateTeacher(Teacher teacher){
		
		getSessionFactory().getCurrentSession().update(teacher);
	}
	
	
	
	
	
}
