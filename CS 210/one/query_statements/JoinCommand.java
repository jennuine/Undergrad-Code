/**
 * @author Jenn Nguyen
 * JoinCommand.java
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
 * Allows the user to join two query lists.
 */
public class JoinCommand implements IOperation {
	private Pattern pattern = Pattern.compile("\\s*join\\s+(\\(.+\\)|\\S+)\\s+and\\s+(\\(.+\\)|\\S+)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String queryList1;
	private String queryList2;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());

		if(matcher.matches()) 
		{
			queryList1 = matcher.group(1);
			queryList2 = matcher.group(2);
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
		System.out.println(Database.getDB().join(queryList1, queryList2).joinToString());
	}

	@Override
	public Dataset exec() throws AllExceptions, IOException
	{
		return Database.getDB().join(queryList1, queryList2);
	}
}
