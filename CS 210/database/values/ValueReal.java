/**
 * ValueReal.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ValueReal extends Value<ValueReal> {
	private final double real;

	public ValueReal(String value) throws AllExceptions
	{
		real = convert(value);
	}
	
	public ValueReal(RandomAccessFile file) throws IOException
	{
		real = file.readDouble();
	}
	
	private Double convert(String value) throws AllExceptions 
	{
		try {
			return Double.parseDouble(value.trim());
		} catch(NumberFormatException e) {
			throw new AllExceptions("ERROR: Unable to parse "+ value + " to a double");
		}
	}
	
	@Override 
	public void writeTo(RandomAccessFile file) throws IOException
	{
		file.writeDouble(real);
	}
	
	@Override
	public String toString()
	{
		return String.format("|  %-8.4f |", real);
	}

	@Override
	public int compareTo(ValueReal newValue) 
	{
		 return (real < newValue.real) ? -1 : ((real == newValue.real) ? 0 : 1);
	}
}
