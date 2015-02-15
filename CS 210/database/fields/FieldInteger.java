/**
 * @author Jenn Nguyen
 * FieldInteger.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueInteger;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Allows creation of field type integer
 */
public class FieldInteger extends Field {

	/**
	 * Instantiates a new field integer
	 * @param fieldName the string field name
	 */
	public FieldInteger(String fieldName) 
	{
		super(4, "integer", fieldName);
	}

	/* (non-Javadoc)
	 * @see two.fields.Field#lineTable()
	 */
	public String getLineTable()
	{	
		return "============";
	}

	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions
	{
		file.seek(initPos + position);
		new ValueInteger(value).writeTo(file);
	}

	public ValueInteger readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueInteger(file);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions 
	{
		return new ValueInteger(value);
	}
}
