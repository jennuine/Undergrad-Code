/**
 * @author Jenn Nguyen
 * DeleteCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to delete a certain table.
 */
public class DeleteCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*delete\\s+(\\S+)(?:\\s+where\\s+(.+))?\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;
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
			try { whereClause = matcher.group(2).trim(); } 
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

		Database.getDB().delete(tableName, whereClause);
		if (whereClause != null)
		{
			System.out.println("\t=> The \'" + tableName + "\' table where \'" + whereClause + "\' was successfully deleted.");
		} else {
			System.out.println("\t=> The \'" + tableName + "\' table was successfully deleted.");
		}
	}
}
