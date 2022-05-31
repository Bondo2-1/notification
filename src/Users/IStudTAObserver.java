package Users;

import CourseWork.Assignment;
import CourseWork.Exam;
import ProjectCourse.Course;

public interface IStudTAObserver {
	
	public void updateStudTAByEmail(String name,Assignment assign,Course course); 
	public void updateStudTABySMS(String name,Assignment assign,Course course);
	public void updateStudTAExamByEmail(String name,Exam exam,Course course); 
	public void updateStudTAExamBySMS(String name,Exam exam,Course course); 
	
}
