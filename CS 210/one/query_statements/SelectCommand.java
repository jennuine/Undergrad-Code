/**
 * @author Jenn Nguyen
 * SelectCommand.java
 */
package one.query_statements;

import database.Database;
import database.Dataset;
import one.AllExceptions;
import one.commands.IOperation;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to select a certain query
 * User has the option for a where clause.
 */
public class SelectCommand implements IOperation {
	private Pattern pattern = Pattern.compile("\\s*select\\s+(\\(.+\\)|\\S+)(?:\\s+where(.+))?\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String queryList;
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
			queryList = matcher.group(1);
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
		System.out.println(Database.getDB().select(queryList, whereClause));
	}

	@Override
	public Dataset exec() throws AllExceptions, IOException
	{
		return Database.getDB().select(queryList, whereClause);
	}
}
