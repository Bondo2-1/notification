package ProjectCourse;

import java.util.ArrayList;

import CourseWork.Assignment;
import CourseWork.Exam;
import Users.Professor;
import Users.Student;
import Users.TA;

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
		
		announcemetns=new ArrayList<String>();
		exams=new ArrayList<Exam>();
		assigns=new ArrayList<Assignment>();
		StudentsRegistedIn=new ArrayList<Student>();
		TAsRegistedIn=new ArrayList<TA>();
		ProfessorsRegistedIn=new ArrayList<Professor>();
		
		
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
