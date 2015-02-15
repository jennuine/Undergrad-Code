/**
 * ValueInteger.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ValueInteger extends Value<ValueInteger> {
	private final int integer;
	
	public ValueInteger(String value) throws AllExceptions
	{		
		integer = convert(value);
	}
	
	public ValueInteger(RandomAccessFile file) throws IOException
	{
		integer = file.readInt();
	}
	
	private Integer convert(String value) throws AllExceptions 
	{
		try {
			return Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
			throw new AllExceptions("ERROR: Unable to parse " + value + " into an integer");
		}
	}
	
	@Override
	public void writeTo(RandomAccessFile file) throws IOException
	{
		file.writeInt(integer);
	}
	
	@Override
	public String toString()
	{
		return String.format("|  %-8d |", integer);
	}

	@Override
	public int compareTo(ValueInteger newValue) 
	{
		 return (integer < newValue.integer) ? -1 : ((integer == newValue.integer) ? 0 : 1);
	}
}
