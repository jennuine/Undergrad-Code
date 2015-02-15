/**
 * @author Jenn Nguyen
 * ExitCommand.java
 */
package one.commands;

import three.XMLWriter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to exit the program.
 */
public class ExitCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*exit\\s*;\\s*", Pattern.CASE_INSENSITIVE);

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());
		return matcher.matches();
	}

	/* (non-Javadoc)
	 * @see one.commands.ICommand#execute()
	 */
	@Override
	public void execute() throws IOException 
	{
		System.out.println("\nBYE BYE");
		
		new XMLWriter().write("database.xml");
		
		System.exit(0);
	}
}
