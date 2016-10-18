package iVote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

// IVoteServices contains all the methods to correctly configure a poll for user.
public class IVoteServices 
{
	private String type;
	private String question;
	private ArrayList<String> candidateAnswer = new ArrayList<String>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private int[] count;
	
	public IVoteServices(Question question, String type)
	{
		this.type = type;
		this.question = question.getQuestionAsked();
		this.candidateAnswer = question.getChoices();
		count = new int[this.candidateAnswer.size()];
	}
	//Adds each student with their answers to a list of student contained in IVoteServices.
	public void addStudent(String[] answers)
	{
		if (this.type.equals("multi") && answers.length > 1)
		{
			students.add(new Student(this.generateID(), answers));
		}
		else if (this.type.equals("single") && answers.length <= 1)
		{
			students.add(new Student(this.generateID(), answers));
		}
	}
	//Uses UUID to generate a unique ID
	private String generateID()
	{
		return UUID.randomUUID().toString();
	}
	//counts the number of students have chosen the choices given for the poll
	private int[] countAnswers()
	{
		for(int ndx = 0; ndx < this.students.size(); ndx++)
		{
			for(int i = 0; i < this.candidateAnswer.size(); i++)
			{
					for(int j = 0; j < this.students.get(ndx).getAnswers().size(); j++)
					{
						if (this.students.get(ndx).getAnswers().get(j).equals(this.candidateAnswer.get(i)))
						{
							this.count[i]++;
						}
					}
			}
		}
		return count;
	}
	//Prints out the number of participants and the results
	public void output()
	{
		this.countAnswers();
		System.out.println("\nNumber of Participants: " + students.size() );
		System.out.println("Results:");
		
		for(int ndx = 0; ndx < this.candidateAnswer.size(); ndx ++)
		{
			System.out.println(this.candidateAnswer.get(ndx) + ": " + this.count[ndx]);
		}
	}

}
