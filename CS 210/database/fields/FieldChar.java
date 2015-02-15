/**
 * @author Jenn Nguyen
 * FieldChar.java
 */
package database.fields;

import database.values.Value;
import database.values.ValueChar;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows creation of field type char
 */
public class FieldChar extends Field {
	private final int size;

	/**
	 * Instantiates a new field char
	 * @param fieldName the string field name
	 * @throws AllExceptions if the type char is entered incorrectly
	 */
	public FieldChar(String fieldName, String size) throws AllExceptions
	{		
		super (2 * checkChar(size), "char", fieldName);
		this.size = checkChar(size);
	}

	/**
	 * Returns the contents of the field type as a string
	 */
	public String toString() 
	{
		return fieldName + " char(" + size + ")";
	}
	
	private static int checkChar(String str) throws AllExceptions 
	{
		Pattern pattern = Pattern.compile("\\s*char\\s*\\(\\s*(\\d+)\\s*\\)\\s*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str.trim());

		if (matcher.matches())
			return Integer.parseInt(matcher.group(1));
		else 
			throw new AllExceptions("ERROR: Field type char is entered incorrectly.");
	}

	/**
	 * Returns the contents of the field type as a string in XML format
	 */
	public String toXML()
	{
		return "\t\t\t<FIELD>\n\t\t\t\t<FIELDNAME>" + fieldName + "</FIELDNAME>\n\t\t\t\t<FIELDTYPE>char</FIELDTYPE>\n\t\t\t\t\t<VALUE>" + size + "</VALUE></FIELD>\n";
	}

	/* (non-Javadoc)
	 * @see two.fields.Field#lineTable()
	 */
	public String getLineTable()
	{
		return "===========";
	}

	public void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions
	{
		file.seek(initPos + position);
		new ValueChar(value, size).writeTo(file);
	}

	public ValueChar readBinary(int initPos, RandomAccessFile file) throws IOException
	{
		file.seek(initPos + position);
		return new ValueChar(file, size);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Value convertToValue(String value) throws AllExceptions 
	{
		return new ValueChar(value, size);
	}
}
