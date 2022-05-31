package Users;

import CourseWork.Assignment;
import CourseWork.Exam;
import ProjectCourse.Course;

public interface IProfObservable {
	

	 public void subscribeTAForEmail(TA t);
	 public void subscribeTAForSMS(TA t); 
	 public void subscribeStudentForEmail(Student p); 
	 public void subscribeStudentForSMS(Student p); 
	 public void unsubscribeTAForEmail(TA t); 
	 public void unsubscribeStudentForSMS(Student p); 
	 public void unsubscribeStudentForEmail(Student p);
	 public void unsubscribeTAForSMS(TA t); 
	 public void notifyAllStudTAsByEmail(Assignment assign,Course course);
	 public void notifyAllStudTAsBySMS(Assignment assign,Course course);
	 public void notifyAllStudTAsByEmail(Exam exam,Course course);
	 public void notifyAllStudTAsBySMS(Exam exam,Course course);
	 public void notifyAllStudProfAnnoucementByEmail(String bodyOfAnn);
	 public void notifyAllStudProfAnnoucementBySMS(String bodyOfAnn);
	
}
