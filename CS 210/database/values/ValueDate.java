/**
 * ValueDate.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValueDate extends Value<ValueDate> {
	private SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
	private final Date date;

	public ValueDate(String value) throws AllExceptions
	{
		date = convert(value);
	}

	public ValueDate(RandomAccessFile file) throws IOException
	{
		date = new Date(file.readLong());
	}

	private Date convert(String value) throws AllExceptions
	{
		dFormat.setLenient(false);
		Date date;

		try 
		{
			date = dFormat.parse(removeQuotes(value));

			if (date.after(dFormat.parse("01/01/2099")) || date.before(dFormat.parse("01/01/1900")))
				throw new AllExceptions("ERROR: Invalid year");
		} 
		catch (ParseException e) { throw new AllExceptions("ERROR: Invalid date"); }	
		
		return date;
	}
	
	@Override
	public void writeTo(RandomAccessFile file) throws IOException
	{
		file.writeLong(date.getTime());
	}
	
	@Override
	public String toString()
	{
		return String.format("| %-10s |", dFormat.format(new Date(date.getTime())));
	}

	@Override
	public int compareTo(ValueDate newValue) 
	{
		long d = date.getTime();
		 return (d < newValue.date.getTime()) ? -1 : ((d == newValue.date.getTime()) ? 0 : 1);
	}
}
