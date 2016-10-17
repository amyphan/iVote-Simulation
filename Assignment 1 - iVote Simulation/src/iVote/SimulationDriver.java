package iVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver 
{
	public static void main(String[] args)
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
	private static String[] generateAnswers(String[] answers)
	{
		Random rand = new Random();
		int randNum = rand.nextInt(answers.length);
		
		List<String> studentChoices = new ArrayList<String>();
		for(int ndx = 0; ndx < randNum; ndx++)
		{
			if (!studentChoices.contains(answers[randNum]))
			{
				studentChoices.add(answers[ndx]);
			}
		}
		return studentChoices.toArray(new String[0]);
		
	}

}
