package mainForTest;

import java.util.Date;

import CourseWork.Assignment;
import Messages.DailyNewsEmailMessage;
import Messages.DailyNewsMobileMessage;
import Messages.EmailGateway;
import Messages.SMSGateway;
import ProjectCourse.Course;
import Users.Professor;
import Users.Student;
import Users.TA;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*EmailGateway emailgateway=new EmailGateway();
		
		SMSGateway smsGateway=new SMSGateway();
		
		emailgateway.dailyMsgType=new DailyNewsEmailMessage();
		
		
		System.out.println(emailgateway.dailyMsgType.sendDailyMessage());
		
		smsGateway.dailyMsgType=new DailyNewsMobileMessage();
		
		System.out.println(smsGateway.dailyMsgType.sendDailyMessage());*/
		
		
		
		TA yossef=new TA("Youssef","yossefazozz40@gmail.com","01113879559","Software");
		
		TA george=new TA("George","georgemagdy170@gmail.com","01254866345","IS");
		
		
		Student stud1=new Student(1,"Ahmed","ahmed600@gmail.com","645465462");
		
		Student stud2=new Student(2,"Mohamed","mohamed900@gmail.com","98765454354");
		
		
		Date date=new Date(2022,5,31);
		
		Professor prof1=new Professor("Ali","ahmed600@gmail.com","645465462",date,"Computer Arch");
		
		Professor prof2=new Professor("Mostafa","samy600@gmail.com","4asd654as35",date,"AI");
		
		
		Course courseRealtedToUsers=new Course("FrontEnd","Wasdsdb");
		
		stud1.register(courseRealtedToUsers);
		stud2.register(courseRealtedToUsers);
		
		
		
		yossef.register(courseRealtedToUsers);
		george.register(courseRealtedToUsers);
		
		
		prof1.register(courseRealtedToUsers);
		prof2.register(courseRealtedToUsers);
	
	
		yossef.subscribeStudentForEmail(stud1);
		yossef.subscribeStudentForEmail(stud2);
		yossef.subscribeStudentForSMS(stud1);
		yossef.subscribeStudentForSMS(stud2);
		

		
		
		
		
		
		

		
		yossef.subscribeProfessorForEmail(prof1);
		yossef.subscribeProfessorForSMS(prof1);
		yossef.subscribeProfessorForEmail(prof2);
		yossef.subscribeProfessorForSMS(prof2);
		
		
		//yossef.addAssignmentByTA("assign1","Assignment Description",date,courseRealtedToUsers);
		
		yossef.addExam("Exam1", "1 hour", courseRealtedToUsers);
		
		System.out.println("\n");
		System.out.println("\n");
		Date date2=new Date(2022,6,1);
		Course course=new Course("Web development","Wasdsdb");
		yossef.addExam("Exam2", "2 hours", course);
		//yossef.addAssignmentByTA("assign1","Assignment Description",date2,course);
		
		
		
		
		
		
		
		//yossef.courseManagement.addAssignment("assign1","Assignment Description",date2,course);
		
		
		
		
		
		
		
		
		

	}

}
