/**
 * Value.java
 * @author Jenn Nguyen
 */
package database.values;

import one.AllExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;


@SuppressWarnings("rawtypes")
public abstract class Value<T extends Value> implements Comparable<T>, java.io.Serializable {

	public abstract void writeTo(RandomAccessFile file) throws IOException;
	public abstract int compareTo(T newValue);
	public abstract String toString();	
	
	protected String removeQuotes(String value) throws AllExceptions
	{ 
		if (!value.trim().matches("'(.+)'"))
			throw new AllExceptions("ERROR: Invalid format");

		return value.trim().replaceAll("'", "");
	}
}
