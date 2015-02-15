/**
 * ValueVarChar.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ValueVarChar extends Value<ValueVarChar> {
	private final String varchar;
	private transient RandomAccessFile varfile;

	public ValueVarChar(String value) throws AllExceptions
	{		
		varchar = removeQuotes(value);	
	}
	
	public ValueVarChar(RandomAccessFile file) throws IOException
	{
		varfile = new RandomAccessFile("Database/Binary Files/VarChars", "r");
		
		int readPos = file.readInt();
		
		varfile.seek(readPos);
		varchar = varfile.readUTF();
		
		varfile.close();
	}
	
	@Override
	public void writeTo(RandomAccessFile file) throws IOException
	{
		varfile = new RandomAccessFile("Database/Binary Files/VarChars", "rw");

		int posVarchar = (int) varfile.length();
		
		file.writeInt(posVarchar);
		varfile.seek(posVarchar);
		varfile.writeUTF(varchar);
		
		varfile.close();
	}
	
	@Override
	public String toString()
	{
		return String.format("|   %-15s |", varchar);
	}

	@Override
	public int compareTo(ValueVarChar newValue) 
	{
		return varchar.compareTo(newValue.varchar);
	}
}
