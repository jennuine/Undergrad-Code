/**
 * @author Jenn Nguyen
 * FieldReal.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueReal;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Allows creation of field type real
 */
public class FieldReal extends Field {

	/**
	 * Instantiates a new field real
	 * @param fieldName the string field name
	 */
	public FieldReal(String fieldName) 
	{
		super(8, "real", fieldName);
	}

	/* (non-Javadoc)
	 * @see two.fields.Field#lineTable()
	 */
	public String getLineTable()
	{
		return "=============";
	}
	
	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws AllExceptions, IOException
	{
		file.seek(initPos + position);
		new ValueReal(value).writeTo(file);
	}
	
	public ValueReal readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueReal(file);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions 
	{
		return new ValueReal(value);
	}
}
