/**
 * @author Jenn Nguyen
 * UpdateCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to update a field in a table
 * User has the option for a where clause.
 */
public class UpdateCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*update\\s+(\\S+)\\s+set\\s+(\\S+)\\s*=\\s*(\\S+)(?:\\s+where(.+))?\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String fieldName;
	private String value;
	private String whereClause;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());

		if(matcher.matches()) 
		{
			tableName = matcher.group(1);
			fieldName = matcher.group(2);
			value = matcher.group(3);
			try { whereClause = matcher.group(4).trim(); }
			catch (NullPointerException e) { whereClause = null; }
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
		Database.getDB().update(tableName, fieldName, value, whereClause);
		System.out.println("\t=> The \'" + tableName + "\' table was successfully updated.");
	}
}
