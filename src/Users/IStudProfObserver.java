package users;

import projectcourse.Course;
import coursework.Assignment;
import coursework.Exam;

public interface IStudProfObserver {
	
	
	public String updateStudProfByEmail(String taName,Assignment assign,Course course);
	public void updateStudProfBySMS(String taName,Assignment assign,Course course);
	public void updateAddExamByEmail(String taName,Exam exam,Course course);
	public void updateAddExamBySMS(String taName,Exam exam,Course course);
	
}
