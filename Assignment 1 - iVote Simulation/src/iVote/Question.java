package iVote;

import java.util.ArrayList;
import java.util.Collections;

public class Question 
{
	private String questionAsked;
	private String correctAnswers;
	private ArrayList<String> choices = new ArrayList<String>();
	
	public Question(String asked, String answer, String[] choice)
	{
		this.questionAsked = asked;
		this.correctAnswers = answer;
		Collections.addAll(this.choices, choice);
	}
	public void setChoices(String[] choice)
	{
		Collections.addAll(this.choices, choice);
	}
	public ArrayList<String> getChoices()
	{
		return this.choices;
	}
	public void setQuestionAsked(String question)
	{
		this.questionAsked = question;
	}
	public String getQuestionAsked()
	{
		return this.questionAsked;
	}
	public String getCorrectAnswers()
	{
		return this.correctAnswers;
	}
	public void setCorrectAnswers(String answer)
	{
		this.correctAnswers = answer;
	}
	public void print()
	{
		int count = 0;
		System.out.print("Question: " + this.questionAsked);
		for(int ndx = 0; ndx < this.choices.size(); ndx ++)
		{
			System.out.println(count++ + ": " + this.choices.get(ndx));
		}
	}
}
