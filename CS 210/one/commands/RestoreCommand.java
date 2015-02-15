/**
 * @author Jenn Nguyen
 * RestoreCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to restore from a file.
 */
public class RestoreCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*restore\\s+from\\s+'(.+)'\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String filename;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());

		if(matcher.matches()) 
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
	public void execute() throws IOException, AllExceptions 
	{
		try {
			Database.getDB().deserialize(filename);
		} catch (ClassNotFoundException e) {
			throw new AllExceptions("An error has occured during restore");
		} catch (FileNotFoundException fe) {
			throw new AllExceptions("Sorry, the file \'" + filename + "\' was not found.");
		}
		System.out.println("\t=> Restore successful! \n\nDatabase dictionary:\n" + Database.getDB().toString()); 
	}
}
