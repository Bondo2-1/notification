package projectcourse;

import java.util.ArrayList;
import java.util.Date;

import coursework.Assignment;
import coursework.Exam;


public class CourseManagement {
	
	private Course course=new Course();
	private Exam exam=new Exam();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	

	
	public void addAssignment(String name,String body,Date date,Course cour)
	{
		
		cour.assigns.add(new Assignment(name,body,date));
	}
		
	public ArrayList<Double> postgrades()
	{
		return (ArrayList<Double>) Exam.grades;
	}	
}
