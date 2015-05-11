package com.testsp.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.testsp.data.Student;
import com.testsp.data.Teacher;
import com.testsp.service.StudentService;


@ManagedBean
@SessionScoped
public class StudentBean {

	@ManagedProperty("#{studentService}")
	private StudentService studentService;

	private List<Student> students; 
	
	
	

	private Student student = new Student();

	private Teacher teacher = new Teacher();
	

	public String addStudent(){
		student.setTeacher(teacher);
		getStudentService().addStudent(student);
		
		return "list";
	}
	
	public String editStudent(){
		getStudentService().editStudent(student);
		
		return "list";
	}
	
	
	public String goToAdd(){
		
		
		return "add";
	}
	
	public void deleteStudent(Student student){
		getStudentService().deleteStudent(student);
	}
	
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudents() {
		return getStudentService().getStudents();
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String goToUpdatePage(Student student){
		setStudent(student);
		getTeacher().setTeaId(student.getTeacher().getTeaId());
		return "edit";
	}
	
}
