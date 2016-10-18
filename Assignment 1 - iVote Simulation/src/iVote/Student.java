package iVote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Student class, contains unique id and the choices that the student has chosen as their answer
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
	public ArrayList<String> getAnswers()
	{
		return answers;
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
