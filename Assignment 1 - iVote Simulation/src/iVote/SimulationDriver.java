package iVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Simulates how a poll works by testing with a single and multi poll.
public class SimulationDriver 
{
	public static void main(String[] args)
	{
		System.out.println("Multiple Choices: ");
		multi();
		System.out.println("\nSingle Choices: ");
		single();
	}
	private static void generateStudents(IVoteServices poll, String[] answers)
	{
		Random rand = new Random();
		int randNum = rand.nextInt(15) + 1;
		
		for(int ndx = 0; ndx < randNum; ndx++)
		{
			String[] ans = generateAnswers(answers);
			poll.addStudent(ans);
		}
	}
	//Generates a array of answers for each student using a random number to do it.
	private static String[] generateAnswers(String[] answers)
	{
		Random rand = new Random();
		int randNum = rand.nextInt(answers.length) + 1;
		
		List<String> studentChoices = new ArrayList<String>();
		for(int ndx = 0; ndx < randNum; ndx++)
		{
			if (!studentChoices.contains(answers[randNum - 1]))
			{
				
				studentChoices.add(answers[ndx]);
			}
		}
		return studentChoices.toArray(new String[0]);		
	}
	private static void multi ()
	{
		String question = "What is 4 + 4 ?";
		String type = "multi";
		String[] choices = {"8", "12", "40", "16", "1", "0"};
		String[] correctAnswer = {"8"};
		
		Question q1 = new Question(question, correctAnswer, choices);
	
		IVoteServices poll = new IVoteServices(q1, type);
		generateStudents(poll, choices);
		q1.print();
		poll.output();
	}
	private static void single()
	{
		String question = "Is the sky blue ?";
		String type = "single";
		String[] choices = {"Yes", "No", "None of the above"};
		String[] correctAnswer = {"Yes"};
		
		Question q2 = new Question(question, correctAnswer, choices);
	
		IVoteServices poll = new IVoteServices(q2, type);
		generateStudents(poll, choices);
		q2.print();
		poll.output();
	}

}
