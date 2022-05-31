package Users;

import ProjectCourse.Course;

public abstract class User {
	
	protected String name;
	protected String email;
	protected String phoneNumber;
	
	User(String name,String email,String phoneNumber)
	{
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}
	
	public abstract void register(Course course);
	


}
