package Users;

import CourseWork.Assignment;
import CourseWork.Exam;
import ProjectCourse.Course;

public interface ITAObservable {
	
	
	public void subscribeProfessorForEmail(Professor p); 
	public void subscribeStudentForEmail(Student p); 
	public void subscribeProfessorForSMS(Professor p); 
	public void subscribeStudentForSMS(Student student);
	public void unsubscribeStudentForEmail(Student p); 
	public void unsubscribeProfessorForSMS(Professor p); 
	public void unsubscribeProfessorForEmail(Professor p);
	public void unsubscribeStudentForSMS(Student p); 
	public void notifyAllStudProfsByEmail(Assignment assign,Course course);
	public void notifyAllStudProfsBySMS(Assignment assing,Course course);
	public void notifyAllStudProfsForAddedExamByEmail(Exam exam,Course course);
	public void notifyAllStudProfsForAddedExamBySMS(Exam exam,Course course);
	public void notifyAllStudProfAnnoucementByEmail(String bodyOfTheannoucement);
	public void notifyAllStudProfAnnoucementBySMS(String bodyOfTheannoucement);
	
}
