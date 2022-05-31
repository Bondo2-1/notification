package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ProjectCourse.Course;
import ProjectCourse.CourseManagement;
import CourseWork.Assignment;
import CourseWork.Exam;

public class TA  extends User implements ITAObservable , IStudTAObserver {

	
	private String department;
	public CourseManagement courseManagement=new CourseManagement();
	
	ArrayList<Student> studentsForEmailNotification=new ArrayList<Student>();
	ArrayList<Student> studentsForSMSNotification=new ArrayList<Student>();
	ArrayList<Professor> professorsForEmailNotification=new ArrayList<Professor>();
	ArrayList<Professor> professorsForSMSNotification=new ArrayList<Professor>();

	
	
	
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
	
	
	
	
	public void addAssignmentByTA(String name,String body,Date date,Course course)
	{
		
		System.out.println("TA " +this.name +"has added "+ name + ", its content is " + body);
		System.out.println(" and its due date at "+ date);
		System.out.println("\n");
		
		courseManagement.addAssignment(name,body,date,course);
		
		
		
		notifyAllStudProfsByEmail(new Assignment(name, body, date),course);
		notifyAllStudProfsBySMS(new Assignment(name, body, date),course);
		
		
		
	}
	
	
	

	
	public void addExam(String name,String duration,Course course)
	{
		
		
		System.out.println("TA " +this.name +"has added exam"+ name+ "Exam duration is " + duration +" Good Luck");
		System.out.println("\n");
		course.exams.add(new Exam(name,duration));
		
		notifyAllStudProfsForAddedExamByEmail(new Exam(name,duration), course);
		notifyAllStudProfsForAddedExamBySMS(new Exam(name,duration), course);
		
		
		
	}
	
	
	
	public void notifyAllStudProfAnnoucementByEmail(String bodyOfAnnounce)
	{
		for(Student stud : studentsForSMSNotification)
		{
			
			
			stud.updatePostAnnouncementsByEmails(this.name,bodyOfAnnounce);
			
		}
		
		
		for(Professor prof : professorsForSMSNotification)
		{
			
			
			prof.updatePostAnnouncementsByEmail(this.name,bodyOfAnnounce);
			
		}
	}
	
	public void notifyAllStudProfAnnoucementBySMS(String bodyOfAnnounce)
	{
		for(Student stud : studentsForSMSNotification)
		{
			
			stud.updatePostAnnouncementsBySMS(this.name,bodyOfAnnounce);
			
		}
		
		
		for(Professor prof : professorsForSMSNotification)
		{
			
			prof.updatePostAnnouncementsBySMS(this.name,bodyOfAnnounce);
			
		}
	}
	
	
	public void postGrades()
	{
		
		System.out.println("TA " +this.name +"has added grades "+ " Good Luck");
		System.out.println("\n");
		
	}

	
	public void postAnnouncement(String bodyOfTheannoucement)
	{
		System.out.println("TA " +this.name +"has announced that"+ bodyOfTheannoucement);
		System.out.println("\n");
		
		
		notifyAllStudProfAnnoucementByEmail(bodyOfTheannoucement);
		notifyAllStudProfAnnoucementBySMS(bodyOfTheannoucement);
		
	}
	
	
	
	
	
	
	
	
	

	public void updateStudTAByEmail(String name,Assignment assign,Course course)
	{
		System.out.println(this.name + " has recieved the assignment added by " + name+ ", sent by email "+course.getName());
	}


	
	public void updateStudTABySMS(String name,Assignment assign,Course course)
	{
		System.out.println(this.name + " has recieved the assignment added by " + name+ ", sent by SMS "+course.getName());
	}

	@Override
	public void updateStudTAExamByEmail(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by Email "+course.getName());
	}

	@Override
	public void updateStudTAExamBySMS(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by SMS "+course.getName());
	}
	
	
	public void updatePostAnnouncementsByEmails(String name,String bodyOfAnnoucementns)
	{
		System.out.println(this.name + " has recieved the annoucement added by " + name+ ", sent by Email ");
	}
	public void updatePostAnnouncementsBySMSs(String name,String bodyOfAnnoucementns)
	{
		System.out.println(this.name + " has recieved the annoucement added by " + name+ ", sent by SMS ");
	}
	
	
	
	
	
	
	
	
	
}
