/**
 * @author Jenn Nguyen
 * Driver.java
 */

package one;

import one.commands.*;
import one.query_statements.*;
import org.xml.sax.SAXException;
import three.DatabaseReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Driver program reads and implements commands from the user
 */
public class Driver {
	private ICommand[] commands = new ICommand[] 
			{
			new BackupCommand(),
			new DefineIndexCommand(),
			new DefineTableCommand(),
			new DeleteCommand(),
			new DropCommand(),
			new ExitCommand(),
			new InsertCommand(),
			new IntersectCommand(),
			new JoinCommand(),
			new MinusCommand(),
			new OrderCommand(),
			new PrintCommand(),
			new ProjectCommand(),
			new ReadCommand(),
			new RenameCommand(),
			new RestoreCommand(),
			new SelectCommand(),
			new UnionCommand(),
			new UpdateCommand()
			};

	/**
	 * Main method that uses method run to start the application
	 * @param args
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException 
	{
		System.out.printf("%-10s", "|------------------------------------------------------------------|\n");
		System.out.printf("%-10s %58s", "|","|\n");
		System.out.printf("%-10s %58s", "|","|\n");
		System.out.printf("%-17s %s %24s", "|","(~^o^)~  WELCOME  ~(^o^~) ","|\n");
		System.out.printf("%-10s %58s", "|","|\n");
		System.out.printf("%-6s %5s %10s", "|","* ~(^o^)~ * (/^o^)/ * ~(^o^)~ * \\(^o^\\) * ~(^o^)~ *","|\n");
		System.out.printf("%-10s %58s", "|","|\n");
		System.out.printf("%-10s", "|------------------------------------------------------------------|\n");

		new File("Database").mkdir();
		new File("Database/Binary Files").mkdir();
		new File("Database/Tree Binary Files").mkdir();

		if (new File("Database/XML/database.xml").exists())
		{
			DatabaseReader data = new DatabaseReader();
			try { data.saxReader("Database/XML/database.xml"); } 
			catch (SAXException | IOException e) { System.out.println(e.getMessage()); }
		}

		new Driver().run();
	}

	/**
	 * Creates a new directory
	 * @param dirName the string directory name
	 * @throws AllExceptions when the directory was not successfully created
	 */
	public void mkDir(String dirName) throws AllExceptions
	{
		File directory = new File(dirName);
		boolean dir = directory.mkdir();

		if (!dir)
			throw new AllExceptions("ERROR: Was not able to successfully create the directory");
	}

	/**
	 * Reads the user's input
	 * @param sc the scanner input to read
	 */
	public void read(Scanner sc)  
	{	
		while (sc.hasNextLine()) 
		{
			String last = "";
			while (!last.contains(";") && sc.hasNextLine()) 
			{
				if (sc.hasNextLine()) 
					last += " " + sc.nextLine();
			}	
			try { check(last); }
				catch (AllExceptions e) { System.out.println(e.getMessage()); }	
		}	
	}

	/**
	 * Checks if the specified string is valid; if so runs it
	 * @param str the string to check 
	 * @throws AllExceptions 
	 */
	public void check(String str) throws AllExceptions  
	{
		for(ICommand command : commands) 
		{
			if (command.matches(str)) 
			{
				try { command.execute(); } 
				catch (AllExceptions e) { System.out.println(e.getMessage()); }
				catch (IOException ioe) { throw new AllExceptions("ERROR: a file error has occured");}
				return;
			}
		}
		if (str.contains(";"));
		System.out.println("This is not a correct statement");	
	}

	/**
	 * Runs the console and uses method read
	 */
	public void run()
	{
		Scanner sc = new Scanner(System.in);

		while (true) { read(sc); }	
	}
}
