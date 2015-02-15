/**
 * @author Jenn Nguyen
 * DefineTableCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to define a table.
 */
public class DefineTableCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*define\\s+table\\s+(\\S+)\\s+having\\s+fields\\s*\\((.+)\\)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String extendedFieldList;

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
			extendedFieldList = matcher.group(2);
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see one.commands.ICommand#execute()
	 */
	@Override
	public void execute() throws AllExceptions, FileNotFoundException 
	{
		Database.getDB().addTable(tableName, extendedFieldList);
	}
}
