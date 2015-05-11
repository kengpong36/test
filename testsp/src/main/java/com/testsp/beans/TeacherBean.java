package com.testsp.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import com.testsp.service.TeacherService;
import com.testsp.data.Teacher;;

//ถ้าไม่ตั้งชื่อbean เรียกใช้จะเป็นตัวเล็ก
@ManagedBean
@SessionScoped
public class TeacherBean implements Serializable{

	private List<Teacher> teachers;
	

	@ManagedProperty("#{teacherService}")
	private TeacherService teacherService;
	
	private Teacher teacher = new Teacher();
	
	private HashMap<String,Integer> hashTeacher;
	

	public HashMap<String, Integer> getHashTeacher() {
		
		hashTeacher = new HashMap<String, Integer>();
		
		List<Teacher> listTeacher = getTeacherService().getTeachers();
		
		for (Teacher item : listTeacher) {
			
			hashTeacher.put(item.getTeaName(),item.getTeaId());
		}
		
		
		
		return hashTeacher;
			
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String addTeacher(){
		//Calling Business Service
		teacherService.addTeacher(teacher);
		//Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Teacher"+this.teacher.getTeaName()+
						"Is Add Successfully"));
		return "list";
	}
	
	public List<Teacher> getTeachers() {
		return getTeacherService().getTeachers();
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void deleteTeacher(Teacher teacher){
	
		getTeacherService().deleteTeacher(teacher);
	
		//add Message
		FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The Teacher Delete Successfully"));
			
		
	}
	
	public String goToUpdatePage(Teacher teacher){
		setTeacher(teacher);
		
		return "edit";
	}

	public String editTeacher(){
		getTeacherService().updateTeacher(this.teacher);
		
		return "list";
	}
	
}
