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
		IVoteServices poll = new IVoteServices(question, type, choices);
		generateStudents(poll, choices);
		poll.output();
	}
	private static void generateStudents(IVoteServices poll, String[] answers)
	{
		String[] ans = generateAnswers(answers);
		Random rand = new Random();
		int randNum = rand.nextInt(15) + 1;
		
		for(int ndx = 0; ndx < randNum; ndx++)
		{
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
				studentChoices.add(answers[randNum]);
			}
		}
		
		return studentChoices.toArray(new String[0]);
		
	}

}
