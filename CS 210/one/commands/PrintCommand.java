/**
 * @author Jenn Nguyen
 * PrintCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to select print a table and/or dictionary.
 */
public class PrintCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*print\\s+(\\S+)\\s*;\\s*|\\s*print\\s+dictinary\\s*;\\s*", Pattern.CASE_INSENSITIVE);
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
	public void execute() throws AllExceptions, IOException
	{
		if (tableName.equalsIgnoreCase("dictionary"))
			System.out.println(Database.getDB().toString());
		else
		{
			System.out.println(Database.getDB().getData(tableName, null));
		}
	}
}