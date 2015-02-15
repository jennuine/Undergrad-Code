/**
 * @author Jenn Nguyen
 * RenameCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to rename the table name.
 */
public class RenameCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*rename\\s+table\\s+(\\S+)\\s+to\\s+(\\S+)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String newTableName;

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
			newTableName = matcher.group(2);
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see one.commands.ICommand#execute()
	 */
	@Override
	public void execute() throws AllExceptions 
	{
		Database.getDB().renameTable(tableName, newTableName);
	}
}
