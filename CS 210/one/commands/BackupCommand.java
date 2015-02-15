/**
 * @author Jenn Nguyen
 * BackupCommand.java
 */
package one.commands;

import database.Database;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to backup to a file.
 */
public class BackupCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*backup\\s+to\\s+'(.+)'\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String filename;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input)
	{
		Matcher matcher = pattern.matcher(input.trim());
		if(matcher.matches())
		{
			filename = matcher.group(1);
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
		try {
			Database.getDB().serialize(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\t=> The backup to \'" + filename + "\' was successful.");
	}
}
