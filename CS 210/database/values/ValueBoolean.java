/**
 * Value.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ValueBoolean extends Value<ValueBoolean> {
	private final boolean bool;

	public ValueBoolean(String value) throws AllExceptions
	{
		bool = convert(value);
	}
	
	public ValueBoolean(RandomAccessFile file) throws IOException
	{
		bool = file.readBoolean();
	}
	
	private boolean convert(String value) throws AllExceptions 
	{	
		if (!value.trim().equalsIgnoreCase("true") & !value.trim().equalsIgnoreCase("false"))
			throw new AllExceptions("ERROR: Invalid boolean");
		
		return Boolean.parseBoolean(value.trim());
	}

	@Override
	public void writeTo(RandomAccessFile file) throws IOException 
	{
		file.writeBoolean(bool);
	}
	
	@Override
	public String toString()
	{
		return String.format("|  %-8b |", bool);
	}

	@Override
	public int compareTo(ValueBoolean newValue) 
	{
		return (bool == newValue.bool) ? 0 : (bool ? 1 : -1);
	}
}
