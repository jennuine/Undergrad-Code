/**
 * Table.java
 * @author Jenn Nguyen
 */
package database;

import database.fields.*;
import database.values.Value;
import one.AllExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Allows user to create and store a table
 */
public class Table implements java.io.Serializable {
	protected ArrayList<Field> table;
	protected String tableName;
	private transient RandomAccessFile file;
	private int rowLength = 1;
	protected Dataset data;

	/**
	 *Constructs a table
	 *@param tName the string table name
	 *@param fList the string extended field list
	 * @throws AllExceptions
	 * @throws FileNotFoundException
	 */
	public Table(String tName, String fList) throws AllExceptions, FileNotFoundException
	{
		tableName = tName.toLowerCase();
		file = new RandomAccessFile("Database/Binary Files/" + tableName, "rw");
		fList = fList.toLowerCase();
		table = new ArrayList<Field>();
		Pattern pattern = Pattern.compile("\\s*(\\S+)\\s+(.+)\\s*", Pattern.CASE_INSENSITIVE);

		String[] splitList = fList.split(",".trim());

		for (String contains: splitList)
		{
			Matcher matcher = pattern.matcher(contains.trim());

			if (!matcher.matches())
				throw new AllExceptions("ERROR: \'" + contains + "\' is an invalid input.");

			if (checkFName(matcher.group(1)))
				addField(matcher.group(2), matcher.group(1));
		}
	}

	/**
	 * Constructs a table
	 * @param tName the string table name
	 * @throws FileNotFoundException
	 */
	public Table(String tName) throws FileNotFoundException
	{
		tableName = tName.toLowerCase();
		file = new RandomAccessFile("Database/Binary Files/" + tableName, "rw");
		table = new ArrayList<Field>();
	}

	/**
	 * Adds a field to a table
	 * @param type the string field type
	 * @param fieldName the string field name
	 * @throws AllExceptions if invalid field type
	 */
	public void addField(String type, String fieldName) throws AllExceptions
	{
		Field field = null;

		switch (type)
		{
		case "varchar": field = new FieldVarChar(fieldName); break;
		case "boolean": field = new FieldBoolean(fieldName); break;
		case "date": field = new FieldDate(fieldName); break;
		case "integer": field = new FieldInteger(fieldName); break;
		case "real": field = new FieldReal(fieldName); break;
		default:
			if (type.contains("char("))
				field = new FieldChar(fieldName, type);
			else
				throw new AllExceptions("ERROR: \'" + type + "\' is an invalid field type.");
		}
		table.add(field);

		field.setPosition(rowLength);
		rowLength += field.getBinarySize();

	}

	/**
	 * Returns true when the same field name isn't contained in the table
	 * @param fName the string field name to check
	 * @throws AllExceptions when the table already contains the field name
	 */
	private boolean checkFName(String fName) throws AllExceptions
	{
		for (Field fields : table)
			if (fields.isName(fName))
				throw new AllExceptions("ERROR: There is already a field named \'" + fName + "\'");

		return true;
	}

	/**
	 * Sets the table name to a new name
	 */
	public void setTableName(String newName)
	{
		tableName = newName;
	}

	/**
	 * Returns the contents of a table and of it's fields as a string
	 */
	public String toString()
	{
		String str = tableName + " (";

		for (int i = 0; i < table.size(); i++)
		{
			str += table.get(i).toString();

			if (i != table.size() - 1)
				str += ", ";
		}

		return str + ")\n";
	}

	/**
	 * Returns the contents of a table in XML form
	 */
	public String toXML()
	{
		String str = "\t\t<TABLENAME>" + tableName + "</TABLENAME>\n";

		for (Field field : table)
			str += field.toXML();

		return str;
	}

	/**
	 * Writes converted value list into a binary file
	 * @param valueList the string value list
	 * @throws IOException
	 * @throws AllExceptions
	 */
	public void writeToBinary(String valueList) throws IOException, AllExceptions
	{
		file = new RandomAccessFile("Database/Binary Files/" + tableName, "rw");
		String[] splitList = valueList.toLowerCase().split(",".trim());

		if (table.size() != splitList.length)
			throw new AllExceptions("ERROR: Invalid insert size");

		int fLength = (int) file.length();
		file.seek(fLength);
		file.writeBoolean(true);

		for (int i = 0; i < table.size(); i++)
		{
			try { table.get(i).writeToBinary(splitList[i].trim(), fLength, file); }
			catch (AllExceptions e)
			{
				file.setLength(fLength);
				throw new AllExceptions(e.getMessage() + " and the values were not inserted.");
			}
		}
	}

	public Dataset getData(String whereClause) throws AllExceptions, IOException
	{
		Dataset dataset = new Dataset(this);
		String[] split = null;
		Field whereField = null;
		int fieldPos = -1;


		try { file.seek(1); }
		catch (IOException e) { throw new AllExceptions("ERROR: The table \'" + tableName + "\' is empty"); }

		if (whereClause != null)
		{
			split = whereClause.split("\\s+");
			whereField = whereField(split[0]);
			fieldPos = table.indexOf(whereField);
		}

		file.seek(0);
		while (file.getFilePointer() < file.length())
		{
			int initialPos = (int) file.getFilePointer();

			if (file.readBoolean())
			{
				Row row = new Row();

				for (Field field : table)
					row.addToRow(field.readBinary(initialPos, file));

				if (whereField == null)
					dataset.addToDataset(row);
				else if (compare(row.get(fieldPos), split[1], whereField.convertToValue(split[2])))
					dataset.addToDataset(row);
			}
			else
				file.seek(initialPos + rowLength);
		}
		data = dataset;
		return data;
	}

	public Field whereField(String fieldName) throws AllExceptions
	{
		Field setField = null;

		for (Field field : table)
		{
			if (field.isName(fieldName))
			{
				setField = field;
				break;
			}
		}

		if (setField == null)
			throw new AllExceptions("ERROR: the field \'" + fieldName + "\' was not found");

		return setField;
	}

	@SuppressWarnings("rawtypes")
	private boolean where(Field whereField, String[] split, int seekPos) throws IOException, AllExceptions
	{
		if (whereField == null)
			return true;

		boolean compare = false;
		Value value = whereField.readBinary(seekPos, file);

		if (compare(value, split[1], whereField.convertToValue(split[2])))
			compare = true;

		return compare;
	}

	public void delete(String whereClause) throws AllExceptions, IOException
	{
		if (getData(whereClause).length() == 0)
			throw new AllExceptions("There are not values matching: \'" + whereClause + "\'");

		Field whereField = null;
		String[] split = null;
		if (whereClause != null)
		{
			split = whereClause.split("\\s+");
			whereField = whereField(split[0]);
		}

		file.seek(0);
		while (file.getFilePointer() < file.length())
		{
			int initialPos = (int) file.getFilePointer();

			if (file.readBoolean() && where(whereField, split, initialPos))
			{
				file.seek(initialPos);
				file.writeBoolean(false);
				file.seek(initialPos + rowLength);
			}
			else
				file.seek(initialPos + rowLength);
		}
	}

	public void update(String fieldName, String value, String whereClause) throws IOException, AllExceptions
	{
		if (getData(whereClause).length() == 0)
			throw new AllExceptions("There are not values matching: \'" + whereClause + "\'");

		Field whereField = null;
		String[] split = null;

		if (whereClause != null)
		{
			split = whereClause.split("\\s+");
			whereField = whereField(split[0]);
		}

		Field setField = whereField(fieldName);

		file.seek(0);
		while (file.getFilePointer() < file.length())
		{
			int initialPos = (int) file.getFilePointer();

			if (file.readBoolean() && where(whereField, split, initialPos))
			{
				setField.writeToBinary(value, initialPos, file);
				file.seek(initialPos + rowLength);
			}
			else
				file.seek(initialPos + rowLength);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	protected static boolean compare(Value val, String relop, Value val2) throws AllExceptions
	{
		if (relop.equals("="))
			return (val.compareTo(val2) == 0);
		else if (relop.equals("!="))
			return (val.compareTo(val2) != 0);
		else if (relop.equals("<"))
			return (val.compareTo(val2) < 0);
		else if (relop.equals(">"))
			return (val.compareTo(val2) > 0);
		else if (relop.equals("<="))
			return (val.compareTo(val2) <= 0);
		else if (relop.equals(">="))
			return (val.compareTo(val2) >= 0);
		else
			throw new AllExceptions("ERROR: Invalid relational operator");
	}


	public void restore() throws IOException
	{
		file = new RandomAccessFile("Database/Binary Files/" + tableName, "rw");

		for (int rowNum = 0; rowNum < data.length(); rowNum++)
		{
			file.writeBoolean(true);
			Row row = data.get(rowNum);

			for (int valNum = 0; valNum < row.length(); valNum++)
			{
				row.get(valNum).writeTo(file);
			}
		}
	}

	public BinarySearchTree define(String fieldList) throws AllExceptions, IOException
	{
		Field field = whereField(fieldList);
		int index = table.indexOf(field);

		if (index < 0)
			throw new AllExceptions("ERROR: There is no field named: \'" + fieldList + "\'");

		String path = "Database/Tree Binary Files/" + tableName;
		new File(path).mkdir();

		BinarySearchTree<Value> bst = new BinarySearchTree<Value>();
		createTree(bst, field);
		return bst;
	}

	private void createTree(BinarySearchTree<Value> bst, Field whereField) throws IOException
	{
		Dataset dataset = new Dataset(this);
		file.seek(0);
		while (file.getFilePointer() < file.length())
		{
			int initialPos = (int) file.getFilePointer();

			if (file.readBoolean())
			{
				Row row = new Row();

				for (Field field : table)
				{
					Value val = field.readBinary(initialPos, file);
					if (field.equals(whereField)) 
						bst.insert(val, initialPos);
					
					row.addToRow(val);
				}
				dataset.addToDataset(row);
			}
			else
				file.seek(initialPos + rowLength);
		}
		data = dataset;
	}
}
