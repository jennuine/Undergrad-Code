/**
 * @author Jenn Nguyen
 * ICommand.java
 */
package one.commands;

import one.AllExceptions;

import java.io.IOException;

/**
 * Interface that all commands implement.
 */
public interface ICommand {

	/**
	 * Checks if user's input matches the command's pattern.
	 * @param input the string to check
	 * @return returns true if user's input matches pattern, returns false if it does not
	 */
	boolean matches(String input);

	/**
	 * executes the command and prints if it is a syntactically correct statement.
	 * @throws AllExceptions the all exceptions
	 */
	void execute() throws AllExceptions, IOException;
}