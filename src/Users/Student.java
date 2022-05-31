package users;




import coursework.Assignment;
import coursework.Exam;
import projectcourse.Course;

public class Student extends User implements IStudProfObserver , IStudTAObserver {
	
	
	private int id;
	
	
	public Student(int id,String name,String email,String phoneNumber)
	{
		super(name,email,phoneNumber);
		this.id=id;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public void register(Course course)
	{
		course.StudentsRegistedIn.add(this);
		
	}
	
	
	public void updateStudProfByEmail(String taName,Assignment assign,Course course)
	{

		System.out.println(name + " has recieved the assignment added by " + taName+ ", sent by email "+course.getName());
	}
	
	public void updateStudProfBySMS(String taName,Assignment assign,Course course)
	{
		
		System.out.println(name + " has recieved the assignment added by " + taName+ ", sent by SMS "+course.getName());
		
		
	}
	
	
	
	public void updateStudTAByEmail(String name,Assignment assign,Course course)
	{
		System.out.println(this.name + " has recieved the assignment added by " + name+ ", sent by email "+course.getName());
	}
	
	

	@Override
	public void updateStudTAExamByEmail(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by email "+course.getName());
	}

	@Override
	public void updateStudTAExamBySMS(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by SMS "+course.getName());
	}

	
	
	@Override
	public void updateAddExamByEmail(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by email "+course.getName());
	}

	@Override
	public void updateAddExamBySMS(String name, Exam exam, Course course) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " has recieved the exam added by " + name+ ", sent by SMS "+course.getName());
	}

	
	public void updateStudTABySMS(String name,Assignment assign,Course course)
	{
		System.out.println(this.name + " has recieved the assignment added by " + name+ ", sent by SMS "+course.getName());
	}
	
	

}
