package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import projectcourse.Course;
import projectcourse.CourseManagement;
import coursework.Assignment;
import coursework.Exam;

public class TA  extends User implements ITAObservable , IStudTAObserver {

	
	private String department;
	private String CA;
	public CourseManagement courseManagement=new CourseManagement();
	
	ArrayList<Student> studentsForEmailNotification=new ArrayList<>();
	ArrayList<Student> studentsForSMSNotification=new ArrayList<>();
	ArrayList<Professor> professorsForEmailNotification=new ArrayList<>();
	ArrayList<Professor> professorsForSMSNotification=new ArrayList<>();

	
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public TA(String name,String email,String phoneNumber,String department)
	{
		super(name,email,phoneNumber);
		this.department=department;
	}
	
	
	@Override
	public void register(Course course)
	{
		course.TAsRegistedIn.add(this);
		
	}
	
	
	public void subscribeProfessorForEmail(Professor professor)
	{
		professorsForEmailNotification.add(professor);
	}
	
	public void subscribeStudentForEmail(Student student)
	{
		studentsForEmailNotification.add(student);
	}
	
	public void subscribeProfessorForSMS(Professor professor)
	{
		professorsForSMSNotification.add(professor);
	}
	
	public void subscribeStudentForSMS(Student student)
	{
		studentsForSMSNotification.add(student);
	}
	
	public void unsubscribeStudentForEmail(Student student)
	{
		studentsForEmailNotification.remove(student);
	}
	
	public void unsubscribeProfessorForSMS(Professor professor)
	{
		professorsForSMSNotification.remove(professor);
	}
	
	public void unsubscribeProfessorForEmail(Professor professor)
	{
		professorsForEmailNotification.remove(professor);
	}
	
	public void unsubscribeStudentForSMS(Student student)
	{
		studentsForSMSNotification.remove(student);
	}
	
	public void notifyAllStudProfsByEmail(Assignment assign,Course course)
	{
		
		
		for(Student stud : studentsForEmailNotification)
		{
			
			if(course.StudentsRegistedIn.contains(stud))
			{
				stud.updateStudProfByEmail(this.name,assign,course);
			}
			
			
			
		}
		
		for(Professor prof : professorsForEmailNotification)
		{
			
			
			if(course.ProfessorsRegistedIn.contains(prof))
			{
				prof.updateStudProfByEmail(this.name,assign,course);
			}
			
			
			
			
		}
		
	}
	
	
	public void notifyAllStudProfsBySMS(Assignment assign,Course course)
	{
		
		
		for(Student stud : studentsForSMSNotification)
		{
			
			
			if(course.StudentsRegistedIn.contains(stud))
			{
				stud.updateStudProfBySMS(this.name,assign,course);
			}
			
			
			
			
		}
		
		
		for(Professor prof : professorsForSMSNotification)
		{
			
			
			if(course.ProfessorsRegistedIn.contains(prof))
			{
				prof.updateStudProfBySMS(this.name,assign,course);
			}
			
			
			
			
		}
		
	}
	
	
	
	public void notifyAllStudProfsForAddedExamByEmail(Exam exam,Course course)
	{
		for(Student stud : studentsForEmailNotification)
		{
			if(course.StudentsRegistedIn.contains(stud))
			{
				stud.updateAddExamByEmail(this.name, exam, course);
			}
		}
		
		for(Professor prof : professorsForEmailNotification)
		{
			if(course.ProfessorsRegistedIn.contains(prof))
			{
				prof.updateAddExamByEmail(this.name, exam, course);
			}
		}
	}
	
	
	public void notifyAllStudProfsForAddedExamBySMS(Exam exam,Course course)
	{
		for(Student stud : studentsForSMSNotification)
		{
			if(course.StudentsRegistedIn.contains(stud))
			{
				stud.updateAddExamBySMS(this.name, exam, course);
			}
		}
		
		
		for(Professor prof : professorsForSMSNotification)
		{
			if(course.ProfessorsRegistedIn.contains(prof))
			{
				prof.updateAddExamBySMS(this.name, exam, course);
			}
		}
		
	}
	
	
	
	
	public String addAssignmentByTA(String name,String body,Date date,Course course)
	{
		
		CA=course.getName();
		
		
		courseManagement.addAssignment(name,body,date,course);
		
		
		
		notifyAllStudProfsByEmail(new Assignment(name, body, date),course);
		notifyAllStudProfsBySMS(new Assignment(name, body, date),course);
		
		return name + CA;
		
	}
	
	
	

	
	public String addExam(String name,String duration,Course course)
	{
		
		
		CA=course.getName();
		course.exams.add(new Exam(name,duration));
		
		notifyAllStudProfsForAddedExamByEmail(new Exam(name,duration), course);
		notifyAllStudProfsForAddedExamBySMS(new Exam(name,duration), course);
		
		return name + CA;
		
		
		
	}

	public String updateStudTAByEmail(String name,Course course)
	{
		CA=course.getName();
		return name + CA;
	}


	
	public String updateStudTABySMS(String name,Course course)
	{
		CA=course.getName();
		return name + CA;
	}

	@Override
	public String updateStudTAExamByEmail(String name, Exam exam, Course course) {
		CA=course.getName();
		return name + CA;
	}

	@Override
	public String updateStudTAExamBySMS(String name, Exam exam, Course course) {
		CA=course.getName();
		return name + CA;
	}
	
	
	
	
	
}
