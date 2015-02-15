/**
 * @author Jenn Nguyen
 * DefineIndexCommand.java
 */
package one.commands;

import database.BinarySearchTree;
import database.Database;
import database.values.Value;
import one.AllExceptions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows the user to define index on the table.
 */
public class DefineIndexCommand implements ICommand {
	private Pattern pattern = Pattern.compile("\\s*define\\s+index\\s+on\\s+(\\S+)\\s*\\(\\s*(\\S+)\\s*\\)\\s*;\\s*", Pattern.CASE_INSENSITIVE);
	private String tableName;
	private String fieldName;

	/* (non-Javadoc)
	 * @see one.commands.ICommand#matches(java.lang.String)
	 */
	@Override
	public boolean matches(String input) 
	{
		Matcher matcher = pattern.matcher(input.trim());

		if(matcher.matches()) 
		{
			tableName = matcher.group(1).trim();
			fieldName = matcher.group(2).trim();
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
		BinarySearchTree<Value> bst = Database.getDB().defineIndex(tableName, fieldName);
		
		System.out.println("To String: ");
		for (Value val : bst)
		{
			System.out.println("Node: " + val.toString());
			System.out.println("Predcessor: " + bst.predecessor(bst.get(val)) + "\nSuccessor " + bst.successor(bst.get(val)) + "\n");
		}
		
		System.out.println("In order: ");
		bst.inOrderWalk();
		
		System.out.println("Reverse order: ");
		bst.reverseWalk();		

	}
}
