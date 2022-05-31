package Users;

import java.util.ArrayList;
import java.util.Date;

import CourseWork.Assignment;
import CourseWork.Exam;
import ProjectCourse.Course;
import ProjectCourse.CourseManagement;

public class Professor extends User implements IProfObservable , IStudProfObserver {

		
	private String department;
	private Date hirringDate; 
	private String phTopic;
	CourseManagement courseMangement = new CourseManagement();
	
	
	
	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;
	ArrayList<TA> taForEmailNotification;
	ArrayList<TA> taForSMSNotification;
	
	
	public Professor(String name,String email,String phoneNumber,Date hirringDate,String phTopic)
	{
		super(name,email,phoneNumber);
		this.hirringDate=hirringDate;
		this.phTopic=phTopic;
		studentsForEmailNotification=new ArrayList<Student>();
		studentsForSMSNotification=new ArrayList<Student>();
		taForEmailNotification=new ArrayList<TA>();
		taForSMSNotification=new ArrayList<TA>();
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getHirringDate() {
		return hirringDate;
	}
	public void setHirringDate(Date hirringDate) {
		this.hirringDate = hirringDate;
	}
	public String getPhTopic() {
		return phTopic;
	}
	public void setPhTopic(String phTopic) {
		this.phTopic = phTopic;
	}

	
	
	@Override
	public void register(Course course)
	{
		course.ProfessorsRegistedIn.add(this);
		
	}
	
	public void subscribeTAForEmail(TA t)
	 {
		 taForEmailNotification.add(t);
	 }
	 
	 public void subscribeTAForSMS(TA t)
	 {
		 taForSMSNotification.add(t);
	 }
	 
	 public void subscribeStudentForEmail(Student p)
	 {
		 studentsForEmailNotification.add(p);
	 }
	 
	 public void subscribeStudentForSMS(Student p)
	 {
		 studentsForSMSNotification.add(p);
	 }
	 
	 public void unsubscribeTAForEmail(TA t)
	 {
		 taForEmailNotification.remove(t);
	 }
	 
	 public void unsubscribeStudentForSMS(Student p)
	 {
		 studentsForSMSNotification.remove(p);
	 }
	 
	 public void unsubscribeStudentForEmail(Student p)
	 {
		 studentsForEmailNotification.remove(p);
	 }
	 
	 public void unsubscribeTAForSMS(TA ta)
	 {
		 taForSMSNotification.remove(ta);
	 }
	 
	 public void addAssignmentByProf(String name,String body,Date date,Course course)
	 {
			
			System.out.println("Prof " +this.name +"has added "+ name + ", its content is " + body);
			System.out.println(" and its due date at "+ date);
			System.out.println("\n");
			
			courseMangement.addAssignment(name,body,date,course);
			
			
			
			notifyAllStudTAsByEmail(new Assignment(name, body, date),course);
			notifyAllStudTAsBySMS(new Assignment(name, body, date),course);
			
			
			
	}
	 public void addExam(String name,String duration,Course course)
	{
			
			
			System.out.println("TA " +this.name +"has added exam"+ name+ "Exam duration is " + duration +" Good Luck");
			System.out.println("\n");
			course.exams.add(new Exam(name,duration));
			
			notifyAllStudTAsByEmail(new Exam(name,duration), course);
			notifyAllStudTAsBySMS(new Exam(name,duration), course);
			
			
			
	}
	 public void postAnnouncement(String bodyOfTheannoucement)
	{
			System.out.println("TA " +this.name +"has announced that"+ bodyOfTheannoucement);
			System.out.println("\n");
			
			
			notifyAllStudProfAnnoucementByEmail(bodyOfTheannoucement);
			notifyAllStudProfAnnoucementBySMS(bodyOfTheannoucement);
			
	}
	 public void postGrades()
	{
			
			
		System.out.println("TA " +this.name +"has added grades "+ " Good Luck");
		System.out.println("\n");
		
			
			
	}
		
	 
	 
	 
	 public void notifyAllStudTAsByEmail(Assignment assign,Course course)
		{
			
			
			for(Student stud : studentsForEmailNotification)
			{
				
				if(course.StudentsRegistedIn.contains(stud))
				{
					stud.updateStudProfByEmail(this.name,assign,course);
				}
				
				
				
			}
			
			for(TA ta : taForEmailNotification)
			{
				
				
				if(course.TAsRegistedIn.contains(ta))
				{
					ta.updateStudTAByEmail(this.name,assign,course);
				}
				
				
				
				
			}
			
		}
		
		
		public void notifyAllStudTAsBySMS(Assignment assign,Course course)
		{
			
			
			for(Student stud : studentsForSMSNotification)
			{
				
				
				if(course.StudentsRegistedIn.contains(stud))
				{
					stud.updateStudProfBySMS(this.name,assign,course);
				}
				
				
				
				
			}
			
			
			for(TA ta : taForSMSNotification)
			{
				
				
				if(course.ProfessorsRegistedIn.contains(ta))
				{
					ta.updateStudTABySMS(this.name,assign,course);
				}
				
				
				
				
			}
			
		}
		
		
		
		public void notifyAllStudTAsByEmail(Exam exam,Course course)
		{
			for(Student stud : studentsForEmailNotification)
			{
				if(course.StudentsRegistedIn.contains(stud))
				{
					stud.updateAddExamByEmail(this.name,exam,course);
				}
			}
			
			for(TA ta : taForEmailNotification)
			{
				if(course.ProfessorsRegistedIn.contains(ta))
				{
					ta.updateStudTAExamByEmail(this.name, exam, course);
				}
			}
		}
		
		
		public void notifyAllStudTAsBySMS(Exam exam,Course course)
		{
			for(Student stud : studentsForSMSNotification)
			{
				if(course.StudentsRegistedIn.contains(stud))
				{
					stud.updateAddExamByEmail(this.name,exam,course);
				}
			}
			
			for(TA ta : taForSMSNotification)
			{
				if(course.ProfessorsRegistedIn.contains(ta))
				{
					ta.updateStudTAExamByEmail(this.name, exam, course);
				}
			}
		}
		
		
		public void notifyAllStudProfAnnoucementByEmail(String bodyOfAnnounce)
		{
			for(Student stud : studentsForSMSNotification)
			{
				
				stud.updatePostAnnouncementsBySMS(this.name,bodyOfAnnounce);
				
			}
			
			
			for(TA ta : taForEmailNotification)
			{
				
				ta.updatePostAnnouncementsByEmails(this.name, bodyOfAnnounce);
				
			}
		}
		
		public void notifyAllStudProfAnnoucementBySMS(String bodyOfAnnounce)
		{
			for(Student stud : studentsForSMSNotification)
			{
				
				stud.updatePostAnnouncementsBySMS(this.name,bodyOfAnnounce);
				
			}
			
			
			for(TA ta : taForSMSNotification)
			{
				
				ta.updatePostAnnouncementsBySMSs(this.name,bodyOfAnnounce);
				
			}
		}
	 
	 
	 
	 

	@Override
	public void updateStudProfByEmail(String taName,Assignment assign,Course course) {
		// TODO Auto-generated method stub
		
		System.out.println(name + " has recieved the assignment added by " + taName+ ", sent by email "+course.getName());
		
	}

	@Override
	public void updateStudProfBySMS(String taName,Assignment assing,Course course) {
		// TODO Auto-generated method stub
		System.out.println(name + " has recieved the assignment added by " + taName+ ", sent by SMS "+course.getName());
	}
	
	
	
	public void updateAddExamByEmail(String taName,Exam exam,Course course)
	{
		System.out.println(name + " has recieved the exam added by " + taName+ ", sent by Email "+course.getName());
	}
	
	public void updateAddExamBySMS(String taName,Exam exam,Course course)
	{
		System.out.println(name + " has recieved the exam added by " + taName+ ", sent by SMS "+course.getName());
	}
	
	public void updatePostAnnouncementsByEmail(String name,String bodyOfAnnoucementns)
	{
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by email "+bodyOfAnnoucementns);
	}

	
	public void updatePostAnnouncementsBySMS(String name,String bodyOfAnnoucementns)
	{
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by SMS "+bodyOfAnnoucementns);
	}
	
	
	
}
