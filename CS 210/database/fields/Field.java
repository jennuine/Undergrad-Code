/**
 * @author Jenn Nguyen
 * Fields.java
 */
package database.fields;

import database.values.Value;
import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Abstract field class that all fields implement.
 */
public abstract class Field implements java.io.Serializable {
	protected String fieldName;
	protected String fieldType;
	protected int binarySize;
	protected int position;
	protected boolean binarySearch = false;

	/**
	 * Constructs the field
	 * @param fType the string field type
	 * @param fName the string field name
	 */
	public Field(int size, String fType, String fName) 
	{
		fieldName = fName;
		fieldType = fType;
		binarySize = size;
	}
	
	/**
	 * Checks if the field names are the same
	 * @param fName the string field name to check
	 */
	public boolean isName(String fName)
	{
		return fieldName.equals(fName);
	}
	
	/**
	 * Checks if the field types are the same
	 * @param fType the string field type to check
	 */
	public boolean isType(String fType)
	{
		return fieldType.equals(fType);
	}

	/**
	 * Returns contents of field as a string
	 */
	public String toString()
	{
		return fieldName + " " + fieldType;
	}
	
	/**
	 * Returns the contents of the field type as a string in XML format
	 */
	public String toXML()
	{
		return "\t\t\t<FIELD>\n\t\t\t\t<FIELDNAME>" + fieldName + "</FIELDNAME>\n\t\t\t\t<FIELDTYPE>"+ fieldType + "</FIELDTYPE></FIELD>\n";
	}

	/**
	 * Returns the field name
	 */
	public String getFieldName()
	{
		return fieldName;
	}
	
	public int getBinarySize()
	{
		return binarySize;
	}
	
	public void setPosition(int pos)
	{
		position = pos;
	}
	
	/**
	 * Creates a line under heading
	 */
	public abstract String getLineTable();
	public abstract void writeToBinary(String value, int initPos, RandomAccessFile file) throws IOException, AllExceptions;
	@SuppressWarnings("rawtypes")
	public abstract Value readBinary(int initPos, RandomAccessFile file) throws IOException;
	@SuppressWarnings("rawtypes")
	public abstract Value convertToValue(String value) throws AllExceptions;
}