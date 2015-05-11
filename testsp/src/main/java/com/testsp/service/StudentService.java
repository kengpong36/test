package com.testsp.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.testsp.data.Student;

@Component
public class StudentService {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addStudent(Student student){
		getSessionFactory().getCurrentSession().save(student);
	}
	
	@Transactional
	public void editStudent(Student student){
		getSessionFactory().getCurrentSession().update(student);
	}
	
	@Transactional
	public void deleteStudent(Student student){
		getSessionFactory().getCurrentSession().delete(student);
	}
	
	@Transactional
	public List<Student> getStudents(){
		return getSessionFactory().getCurrentSession()
					.createQuery("from Student s join fetch s.teacher ORDER BY s.stuId ASC")
						.list();
		
	}
}
