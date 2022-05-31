package CourseWork;

import java.util.Date;

public class Assignment {
	
	
	String name;
	String body;
	Date dueDate;
	
	
	public Assignment(String name,String body,Date date)
	{
		this.name=name;
		this.body=body;
		this.dueDate=date;
	}
	
	public void setName(String assign)
	{
		this.name=assign;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setBody(String body)
	{
		this.body=body;
	}
	
	public String getBody()
	{
		return this.body;
	}
	
	public void setDate(Date date)
	{
		this.dueDate=date;
	}
	
	public Date getDate()
	{
		return this.dueDate;
	}
	
}
