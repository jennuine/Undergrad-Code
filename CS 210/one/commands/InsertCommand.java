/**
 * @author Jenn Nguyen
 * InsertCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to insert values into a table.
 */
public class InsertCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*insert\\s*\\((.+)\\)\\s*into\\s+(\\S+)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String valueList;
	private String tableName;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());
		
		if(matcher.matches()) 
		{
			valueList = matcher.group(1);
			tableName = matcher.group(2);
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
		Database.getDB().insert(tableName, valueList);
	}
}
