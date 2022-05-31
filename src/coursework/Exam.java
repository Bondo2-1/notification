package coursework;

import java.util.ArrayList;

public class Exam {
	
	private String name;
	private String duration;
	public static ArrayList<Double> grades;
	
	public Exam()
	{
		
	}
	
	public Exam(String name,String duration)
	{
		this.name=name;
		this.duration=duration;
		grades=new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
