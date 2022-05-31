package projectcourse;

import java.util.ArrayList;

import coursework.Assignment;
import coursework.Exam;
import users.Professor;
import users.Student;
import users.TA;

public class Course {
	
	private String name;
	private String code;
	
	
	public ArrayList<Exam> exams;
	public ArrayList<String> announcemetns;
	
	public ArrayList<Assignment> assigns;
	public ArrayList<Student> StudentsRegistedIn;
	public ArrayList<TA> TAsRegistedIn;
	public ArrayList<Professor> ProfessorsRegistedIn;
	
	
	
	
	public Course()
	{
		
	}
	
	public Course(String name,String code)
	{
		this.name=name;
		this.code=code;
		
		announcemetns=new ArrayList<>();
		exams=new ArrayList<>();
		assigns=new ArrayList<>();
		StudentsRegistedIn=new ArrayList<>();
		TAsRegistedIn=new ArrayList<>();
		ProfessorsRegistedIn=new ArrayList<>();
		
		
	}
	
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	
	


	
	
	
	

	

}
