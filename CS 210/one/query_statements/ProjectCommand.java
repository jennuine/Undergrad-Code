/**
 * @author Jenn Nguyen
 * ProjectCommand.java
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
 * Allows the user to project a certain query with certain fields.
 */
public class ProjectCommand implements IOperation {
	private Pattern pattern = Pattern.compile("\\s*project\\s+(\\(.+\\)|\\S+)\\s+over\\s+(.+)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String queryList;
	private String fieldList;

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
			fieldList = matcher.group(2);
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
		System.out.println(Database.getDB().project(queryList, fieldList));
	}

	@Override
	public Dataset exec() throws AllExceptions, IOException
	{
		return Database.getDB().project(queryList, fieldList);
	}
}
