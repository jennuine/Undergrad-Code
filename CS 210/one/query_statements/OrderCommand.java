/**
 * @author Jenn Nguyen
 * OrderCommand.java
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
 * Allows the user to view the query in ascending order
 * User has option to view in descending order.
 */
public class OrderCommand implements IOperation {
	private Pattern pattern = Pattern.compile("\\s*order\\s+(\\(.+\\)|\\S+)\\s+by\\s+(\\S+)(?:\\s+(\\w+))?\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String queryList;
	private String fieldName;
	private String descending;

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
			fieldName = matcher.group(2);
			try { descending = matcher.group(3).trim().toLowerCase(); }
			catch (NullPointerException e) { descending = null; }
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
		System.out.println(Database.getDB().orderBy(queryList, fieldName, descending));
	}

	@Override
	public Dataset exec() throws AllExceptions, IOException
	{
		return Database.getDB().orderBy(queryList, fieldName, descending);
	}
}
