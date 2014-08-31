import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class JQNguyen03 {
    public static void main(String [] args) throws IOException {
	Scanner input = new Scanner(System.in);
	FileWriter f = new FileWriter(new File("fileName.txt"));
	

	String[] candidate = new String[10];
	int[] voteCount = new int[10];
	String[][] voterList = new String [10][100];
       
	for (int i = 0; i < voteCount.length; i++) 
	    {
		voteCount[i] = 0;
	    }

	System.out.println("Please enter the candidates names.");
	
	for (int i = 0; i < candidate.length; i++)
	    {
		candidate[i] = input.next();
	    }


	int option = menu();

	while (option <= 5)
	    {
		
		switch (option)
		    {
		    case 1:
			listCandidates(candidate);
			System.out.println("What is your name?");
			String votersName = input.next();
			
			System.out.println("Who do you vote for? Please enter the number of the candidate.");
			int vote = input.nextInt();
			
			int votesSoFar = voteCount[vote];
			voterList[vote][votesSoFar] = votersName;
			voteCount[vote]++;
			
			option = menu();
			continue;
		    
		    case 2:
		    	System.out.println("Number of votes for each candidate:\n");
			
		    	for (int i = 0; i < candidate.length; i++)
		    	{
		    		System.out.print(candidate[i] + " - " + voteCount[i] + "  votes.\n" );
		    	}
		    	option = menu();
		    	continue;
			
		    case 3:
		    	System.out.println("Here are the list of candidates.");
		    	
		    	for (int i = 0; i < candidate.length; i++)
		    	{
		    		System.out.print(i + ". " + candidate[i] + " \n");
		    	}
		    	
		    	System.out.println("\nWhich candidate would you like to view?");
		    	int choice = input.nextInt();
		    	
		    	System.out.print("The voters for this candidate are: ");
		    		for (int j = 0; j < voteCount[choice]; j++)
		    		{
		    			System.out.print(voterList[choice][j] + ", ");
		    		}
		    		
		    	option = menu();
		    	continue;
				
		    case 4:
		    	f.write("Candidates" + "\t\t\t\t" + "Votes\n\n");
		    	
		    	for (int i = 0; i < candidate.length; i++)
		    	{
		    		System.out.print(i + ". " + candidate[i] + " - " + voteCount[i] + "\n");
		    		f.write(candidate[i] + "\t\t\t\t\t" + voteCount[i] + "\n");
		    		
		    	}
		    	System.out.println();
		    	
		    	int max = maxVotes(voteCount);
		    	System.out.println("The most number of votes was " + max + " and that means the winner is " + candidate[voteCount[max]] + "!!!!");
		    	
		    	System.out.println("CONGRADULATIONSSSSSSSS!!!!!!!");
		    	System.out.println("Goodbye!");
		    	f.flush();
		    	f.close();
		    	System.exit(0);
				
		    }
	    }
    }
    
    public static int menu() 
    {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("\n\n\nPlease select from the following menu:\n"
    				+ "\t\t1. Vote\n"
    				+ "\t\t2. Results so far\n"
    				+ "\t\t3. Display Voters for a specific Candidate\n"
    				+ "\t\t4. Exit");

    	int option = input.nextInt();
    	return option;
    }
    
    public static int maxVotes(int arr[])
    {
    	int max = 0;
    	
    	for (int i = 0; i < arr.length; i++)
    	{
    		if (arr[i] > max)
    		{
    			max = arr[i];
    		}
    	}
    	return max;
    }
    
    public static void listCandidates(String arr[])
    {
	for (int i = 0; i < arr.length; i++)
	    {
		System.out.print(i + "-"  + arr[i] + " \n");
	    }
	System.out.println();
    }
}