package iVote;

import java.util.ArrayList;
import java.util.Collections;

public class Student 
{
	private ArrayList<String> answers = new ArrayList<String>();
	private String id;
	
	public Student(String id, String[] choices)
	{
		this.id = id;
		Collections.addAll(answers, choices);
	}
	public void setAnswers(String answer)
	{
		this.answers.add(answer);
	}
	public String[] getAnswers()
	{
		return (String[]) answers.toArray();
	}
	public String getID()
	{
		return this.id;
	}
	public void setID(String id)
	{
		this.id = id;
	}
	public void print()
	{
		System.out.println("Student: " + this.id);
		System.out.println("Answers Given: " + this.answers.toString());
	}
}
