/**
 * @author Jenn Nguyen
 * DropCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to drop the table.
 */
public class DropCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*drop\\s+table\\s+(\\S+)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());

		if (matcher.matches()) 
		{
			tableName = matcher.group(1);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see one.commands.ICommand#execute()
	 */
	@Override
	public void execute() throws AllExceptions, FileNotFoundException, IOException 
	{
		Database.getDB().removeTable(tableName);
		System.out.println("\t=> The \'" + tableName + "\' table was successfully dropped.");
	}
}
