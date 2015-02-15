/**
 * ValueChar.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ValueChar extends Value<ValueChar> {
	private final String chars;

	public ValueChar(String value, int size) throws AllExceptions
	{		
		chars = convert(value, size);
	}
	
	public ValueChar(RandomAccessFile file, int size) throws IOException
	{
		String temp = "";
		for (int i = 0; i < size; i++)
			temp += file.readChar();	
		
		chars = temp;
	}
	
	private String convert(String value, int size) throws AllExceptions 
	{	
		if (removeQuotes(value).length() != size)
			throw new AllExceptions("ERROR: Incorrect char length");
		
		return removeQuotes(value);
	}
	
	@Override
	public void writeTo(RandomAccessFile file) throws IOException 
	{
		file.writeChars(chars);
	}
	
	@Override
	public String toString()
	{
		return String.format("|  %-8s |", chars);
	}

	@Override
	public int compareTo(ValueChar newValue) 
	{
		return chars.compareTo(newValue.chars);
	}
}
