package com.testsp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.testsp.data.Teacher;



public class Main {

	public static void main(String [] args){
	
		/*// Create a configuration instance
		Configuration configuration = new Configuration();
		
		//Provide configuration file
		configuration.configure("hibernate.cfg.xml");
		//Build a SessionFactory
		SessionFactory factory = configuration.buildSessionFactory
				(new StandardServiceRegistryBuilder().configure().build());
		//Get current session, current session is already associated with Thread
		Session session = factory.getCurrentSession();
	
		//Create Teacher 
		Teacher tea = new Teacher();
		//tea.setTea_Name("AAAAA");
		
		//Save
		session.save(tea);
		// Commit, calling of commit will cause save an instance of employee
        session.getTransaction().commit();*/
		
	}
	
}
