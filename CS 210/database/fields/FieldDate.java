/**
 * @author Jenn Nguyen
 * FieldDate.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueDate;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Allows creation of field type date
 */
public class FieldDate extends Field {

	/**
	 * Instantiates a new field date
	 * @param fieldName the string field name
	 */
	public FieldDate(String fieldName) 
	{
		super(8, "date", fieldName);
	}

	/* (non-Javadoc)
	 * @see two.fields.Field#lineTable()
	 */
	public String getLineTable()
	{
		return "=============";
	}

	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions
	{
		file.seek(initPos + position);
		new ValueDate(value).writeTo(file);
	}

	public ValueDate readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueDate(file);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions 
	{
		return new ValueDate(value);
	}
}
