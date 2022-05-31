package ProjectCourse;

import java.util.ArrayList;
import java.util.Date;

import CourseWork.Assignment;
import CourseWork.Exam;


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
	
	
	
	
	
	public ArrayList<Double> PostGrades()
	{
		return exam.grades;
	}
	
	
	public void postAnnouncement()
	{
		
	}

	 
	
	
}
