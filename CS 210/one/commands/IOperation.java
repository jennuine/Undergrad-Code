package one.commands;

import database.Dataset;
import one.AllExceptions;

import java.io.IOException;

public interface IOperation extends ICommand {


	
	boolean matches(String input);
	void execute() throws AllExceptions, IOException;
	Dataset exec() throws AllExceptions, IOException;
}
