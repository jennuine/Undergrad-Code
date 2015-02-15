/**
 * @author Jenn Nguyen
 * FieldVarChar.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueVarChar;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Allows creation of field type varchar
 */
public class FieldVarChar extends Field {

	/**
	 * Instantiates a new field varchar
	 * @param fieldName the string field name
	 */
	public FieldVarChar(String fieldName) 
	{
		super(4, "varchar", fieldName);
	}

	/* (non-Javadoc)
	 * @see two.fields.Field#lineTable()
	 */
	public String getLineTable()
	{ 
		return "====================";
	}

	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions
	{
		file.seek(initPos + position);
		new ValueVarChar(value).writeTo(file);
	}

	public ValueVarChar readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueVarChar(file);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions
	{
		return new ValueVarChar(value);
	}
}
