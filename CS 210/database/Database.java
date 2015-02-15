/**
 * @author Jenn Nguyen
 * Database.java
 */
package database;

import one.AllExceptions;
import one.commands.IOperation;
import one.query_statements.*;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that stores all the tables and allows modifications on those tables
 */
public class Database {
	private HashMap<String, Table> tables;
	private static Database db;
	private IOperation[] setCommands = new IOperation[]
			{
					new UnionCommand(),
					new IntersectCommand(),
					new MinusCommand(),
					new JoinCommand(),
					new ProjectCommand(),
					new SelectCommand(),
					new OrderCommand()
			};
	
	/**
	 * Constructs the database
	 */
	private Database() 
	{
		tables = new HashMap<String, Table>();
	}

	/**
	 * Returns the database
	 */
	public static Database getDB()
	{
		if (db == null)
			db = new Database();

		return db;
	}

	/**
	 * Returns true iff the database contains the table
	 * @param tableName the string table name to check
	 */
	private boolean hasTable(String tableName)
	{
		return (tables.containsKey(tableName.toLowerCase()));
	}

	/**
	 * Adds a table to the database
	 * @param tableName the string table name to add
	 * @param fieldList the string extended field list for that table
	 * @throws AllExceptions iff the table name is already taken
	 * @throws FileNotFoundException 
	 */
	public void addTable(String tableName, String fieldList) throws AllExceptions, FileNotFoundException 
	{
		if (hasTable(tableName))
			throw new AllExceptions("ERROR: There is already a table named \'" + tableName + "\'");

		tables.put(tableName, new Table(tableName, fieldList));
	}

	/**
	 * Adds a table to the database
	 * @param tableName the string table name to add
	 * @throws AllExceptions iff the table name is already taken
	 * @throws FileNotFoundException 
	 */
	public void addTable(String tableName) throws AllExceptions, FileNotFoundException 
	{
		if (hasTable(tableName))
			throw new AllExceptions("ERROR: There is already a table named \'" + tableName + "\'");

		tables.put(tableName, new Table(tableName));	
	}

	/**
	 * Returns the specified table
	 * @param tableName the string table name to return
	 * @throws AllExceptions iff there is no table named tableName
	 */
	public Table getTable(String tableName) throws AllExceptions
	{
		if (!hasTable(tableName))
			throw new AllExceptions("ERROR: There is not a table named \'" + tableName + "\'");

		return tables.get(tableName);
	}

	/**
	 * Removes the table from the database
	 * @param tableName the string table name to remove
	 * @throws AllExceptions iff there is no table named tableName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void removeTable(String tableName) throws AllExceptions, FileNotFoundException, IOException 
	{
		if (!hasTable(tableName))
			throw new AllExceptions("ERROR: There is no table named \'" + tableName + "\'");

		tables.remove(tableName);
		removeBinary(tableName);
	}

	/**
	 * Renames the table
	 * @param tableName the string table name to rename
	 * @param newTName the string new table name to replace
	 * @throws AllExceptions iff there is no table name to rename
	 */
	public void renameTable(String tableName, String newTName) throws AllExceptions 
	{
		tableName = tableName.toLowerCase();
		newTName = newTName.toLowerCase();

		Table table = tables.get(tableName);

		if (hasTable(newTName))
			throw new AllExceptions("ERROR: There is already a table named \'" + newTName + "\'");
		else if (table == null)
			throw new AllExceptions("ERROR: There is no table named \'" + tableName + "\'");

		table.setTableName(newTName);
		tables.put(newTName, tables.remove(tableName));
	}	

	/**
	 * Returns all the contents of a database as a string
	 */
	public String toString()
	{
		String str = "Tables:\n";
		for (Table current : tables.values()) 
			str += current.toString();

		return str;
	}

	/**
	 * Returns all the contents of database as a string in XML form
	 */
	public String toXML()
	{
		String str = "<DATABASE>\n\t<TABLE>\n";
		for (Table current : tables.values())
			str += current.toXML();

		str += "\t</TABLE>\n</DATABASE>\n";

		return str;
	}

	/**
	 * Writes the value list into a binary file
	 * @param tName the string table name to insert the value list to
	 * @param valueList the string of values to insert
	 * @throws IOException
	 * @throws AllExceptions
	 */
	public void insert(String tName, String valueList) throws IOException, AllExceptions
	{
		getTable(tName.toLowerCase()).writeToBinary(valueList);
	}

	public Dataset getData(String tName, String whereClause) throws AllExceptions, IOException
	{
		return getTable(tName.toLowerCase()).getData(whereClause);
	}

	public Dataset select(String tName, String whereClause) throws AllExceptions, IOException
	{
		return check(tName.toLowerCase()).select(whereClause);
	}

	private void removeBinary(String tName) throws AllExceptions, FileNotFoundException, IOException
	{
		new RandomAccessFile("Database/Binary Files/" + tName.toLowerCase(), "rw").close();
		new File("Database/Binary Files/" + tName.toLowerCase()).delete();
	}

	public void delete(String tName, String whereClause) throws AllExceptions, IOException
	{
		getTable(tName.toLowerCase()).delete(whereClause);
	}

	public void update(String tName, String fName, String value, String whereClause) throws IOException, AllExceptions
	{
		getTable(tName.toLowerCase()).update(fName.toLowerCase(), value.toLowerCase(), whereClause);
	}

	public Dataset check(String queryStatement) throws IOException, AllExceptions
	{
		Pattern pattern = Pattern.compile("\\s*\\((.*)\\)\\s*");

		Matcher matcher = pattern.matcher(queryStatement);
		if (matcher.matches())
		{
			queryStatement = matcher.group(1);

			for (IOperation command : setCommands)
			{
				if (command.matches(queryStatement + ";"))
					return command.exec();
			}
		}

		return getTable(queryStatement.toLowerCase()).getData(null);
	}

	public Dataset project(String tName, String fieldList) throws AllExceptions, IOException
	{
		return check(tName.toLowerCase()).project(fieldList.toLowerCase());
	}

	public Dataset join(String tNameA, String tNameB) throws AllExceptions, IOException
	{
		return check(tNameA.toLowerCase()).join(check(tNameB.toLowerCase()));
	}
	
	public Dataset orderBy(String tName, String fName, String descending) throws AllExceptions, IOException
	{
		boolean descend;
		
		if (descending == null)
			descend = false;
		else if (descending.equalsIgnoreCase("descending"))
			descend = true;
		else
			throw new AllExceptions("ERROR: \'" + descending + "\' is invalid");
		
		return check(tName.toLowerCase()).orderBy(fName.toLowerCase(), descend);
	}

	public Dataset union(String tNameA, String tNameB) throws AllExceptions, IOException
	{
		return check(tNameA.toLowerCase()).union(check(tNameB.toLowerCase()));
	}
	
	public Dataset intersect(String tNameA, String tNameB) throws AllExceptions, IOException
	{
		return check(tNameA.toLowerCase()).intersect(check(tNameB.toLowerCase()));
	}
	
	public Dataset minus(String tNameA, String tNameB) throws AllExceptions, IOException
	{
		return check(tNameA.toLowerCase()).minus(check(tNameB.toLowerCase()));
	}

	public void serialize(String fileName) throws IOException, AllExceptions
	{
		for (String table : tables.keySet())
		{
			tables.get(table).getData(null);
		}

		FileOutputStream fileStream = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(fileStream);
		out.writeObject(tables);

		out.close();
		fileStream.close();
	}

	@SuppressWarnings("unchecked")
	public void deserialize(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fileStream);
		tables = (HashMap<String, Table>) in.readObject();

		for (String table : tables.keySet())
			tables.get(table).restore();

		in.close();
		fileStream.close();
	}
	
	public BinarySearchTree defineIndex(String tableName, String fieldList) throws AllExceptions, IOException
	{
		return getTable(tableName.toLowerCase()).define(fieldList.toLowerCase());
	}
}
