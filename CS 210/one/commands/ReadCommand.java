/**
 * @author Jenn Nguyen
 * ReadCommand.java
 */
package one.commands;

import one.AllExceptions;
import one.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to read a file and execute the file's commands
 */
public class ReadCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*read\\s+'(.+)'\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String filename;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input)  
	{
		Matcher matcher = pattern.matcher(input.trim());

		if (matcher.matches()) 
		{
			filename = matcher.group(1);
			return true;
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see one.commands.ICommand#execute()
	 */
	@Override
	public void execute() throws AllExceptions, IOException {
		try 
		{ 
			new Driver().read(new Scanner(new File(filename)));

		} catch (FileNotFoundException e) { 
			throw new AllExceptions("Sorry, the file \'" + filename + "\' was not found.");
		}
	}
}