package Users;

import CourseWork.Assignment;
import CourseWork.Exam;
import ProjectCourse.Course;

public interface IStudProfObserver {
	
	
	public void updateStudProfByEmail(String taName,Assignment assign,Course course);
	public void updateStudProfBySMS(String taName,Assignment assign,Course course);
	public void updateAddExamByEmail(String taName,Exam exam,Course course);
	public void updateAddExamBySMS(String taName,Exam exam,Course course);
	public void updatePostAnnouncementsByEmail(String name,String bodyOfAnnoucementns);
	public void updatePostAnnouncementsBySMS(String name,String bodyOfAnnoucementns);
}
