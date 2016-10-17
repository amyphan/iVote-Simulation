package iVote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class IVoteServices 
{
	private String type;
	private String question;
	private ArrayList<String> candidateAnswer = new ArrayList<String>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private int[] count;
	
	public IVoteServices(String question, String type, String[] answers)
	{
		this.type = type;
		this.question = question;
		Collections.addAll(candidateAnswer, answers);
		count = new int[answers.length];
	}
	public void addStudent(String[] answers)
	{
		students.add(new Student(this.generateID(), answers)); 
	}
	private String generateID()
	{
		return UUID.randomUUID().toString();
	}
	private int[] countAnswers()
	{
		for(int ndx = 0; ndx < this.students.size(); ndx++)
		{
			for(int i = 0; i < this.candidateAnswer.size(); i++)
			{
				for(int j = 0; j < this.students.get(ndx).getAnswers().length; j++)
				{
					if (this.students.get(ndx).getAnswers()[j].equals(this.candidateAnswer.get(i)))
					{
						this.count[i]++;
					}
				}
			}
		}
		return count;
	}
	public void output()
	{
		this.countAnswers();
		for(int ndx = 0; ndx < this.candidateAnswer.size(); ndx ++)
		{
			System.out.println(this.candidateAnswer.get(ndx) + " :" + this.count[ndx]);
		}
	}

}
