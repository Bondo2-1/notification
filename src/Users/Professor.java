package users;


import java.util.ArrayList;
import java.util.Date;


import projectcourse.Course;
import coursework.Assignment;
import coursework.Exam;


public class Professor extends User implements IProfObservable , IStudProfObserver {

		
	private String department;
	private Date hirringDate; 
	private String phTopic;
	private String ca;
	
	
	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;
	ArrayList<TA> taForEmailNotification;
	ArrayList<TA> taForSMSNotification;
	
	
	public Professor(String name,String email,String phoneNumber,Date hirringDate,String phTopic)
	{
		super(name,email,phoneNumber);
		this.hirringDate=hirringDate;
		this.phTopic=phTopic;
		studentsForEmailNotification=new ArrayList<>();
		studentsForSMSNotification=new ArrayList<>();
		taForEmailNotification=new ArrayList<>();
		taForSMSNotification=new ArrayList<>();
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
		
		
	 
	 
	 
	 
	 

	@Override
	public String updateStudProfByEmail(String taName,Assignment assign,Course course) {
		// TODO Auto-generated method stub
		
		ca=course.getName();
		return name + ca;
		
	}

	@Override
	public String updateStudProfBySMS(String taName,Assignment assing,Course course) {
		ca=course.getName();
		return name + ca;
	}
	
	
	
	public String updateAddExamByEmail(String taName,Exam exam,Course course)
	{
		ca=course.getName();
		return name + ca;
	}
	
	public String updateAddExamBySMS(String taName,Exam exam,Course course)
	{
		ca=course.getName();
		return name + ca;
	}
	
	

	
	
	
	
}
