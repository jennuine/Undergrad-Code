/**
 * @author Jenn Nguyen
 *FieldBoolean.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueBoolean;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Allows creation of field type boolean
 */
public class FieldBoolean extends Field {
	
	/**
	 * Instantiates a new field boolean
	 * @param fieldName the string field name
	 */
	public FieldBoolean(String fieldName)
	{
		super(1, "boolean", fieldName);
	}

	public String getLineTable()
	{
		return "============";
	}
	
	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions
	{ 
		file.seek(initPos + position);
		new ValueBoolean(value).writeTo(file);
	}
	
	public ValueBoolean readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueBoolean(file);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions 
	{
		return new ValueBoolean(value);
	}
	
}
