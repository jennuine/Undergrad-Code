/**
 * Dataset.java
 * @author Jenn Nguyen
 */
package database;

import database.fields.Field;
import one.AllExceptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Dataset implements java.io.Serializable {
	private ArrayList<Row> rows;
	private ArrayList<Field> fields;
	private String tableName;
	private ArrayList<String> joinFields;

	public Dataset(Table table)
	{
		rows = new ArrayList<Row>();
		fields = new ArrayList<Field>(table.table);
		tableName = table.tableName;
	}

	private Dataset()
	{
		rows = new ArrayList<Row>();
		fields = new ArrayList<Field>();
	}

	public int length()
	{
		return rows.size();
	}

	public Row get(int position)
	{
		return rows.get(position);
	}

	public void addToDataset(Row row)
	{
		rows.add(row);
	}
	
	public boolean contains(Row row)
	{
		for (Row r : this.rows)
		{
			if (r.compareTo(row) == 0)
				return true;
		}
				
		return false;
	}

	private void setFieldNames(Dataset data)
	{
		for (Field field : data.fields)
			joinFields.add(data.tableName + "." + field.getFieldName());
	}
	
	public Dataset join(Dataset dataB)
	{
		Dataset joinData = new Dataset();
		joinFields = new ArrayList<String>();

		setFieldNames(this);
		setFieldNames(dataB);

			for (Row rowA : this.rows)
			{
				for (Row rowB : dataB.rows)
				{
					Row row = new Row();
					row.join(rowA);
					row.join(rowB);
				
					joinData.addToDataset(row);
				}
			}

		rows = joinData.rows;
		fields.addAll(dataB.fields);
			
		return this;
	}

	public Dataset union(Dataset dataB) throws AllExceptions
	{
		checkData("union", dataB);

		for (Row row : dataB.rows)
		{
			if (!rows.contains(row))
				rows.add(row);

		}
		return this;
	}
	
	public Dataset intersect(Dataset dataB) throws AllExceptions
	{
		checkData("intersect", dataB);

		rows.retainAll(dataB.rows);
		return this;
	}
	
	public Dataset minus(Dataset dataB) throws AllExceptions
	{
		checkData("minus", dataB);

		rows.removeAll(dataB.rows);
		return this;
	}

	private boolean checkData(String operation, Dataset dataB) throws AllExceptions
	{
		if (this.get(0).length() != dataB.get(0).length())
			throw new AllExceptions("ERROR: Unable to perform " + operation + " because tables do not have same number of fields");

		for (int i = 0; i < this.get(0).length(); i++)
			if (!(this.get(0).get(i).getClass().getCanonicalName()).equals(this.get(0).get(i).getClass().getCanonicalName()))
				throw new AllExceptions("ERROR: Unable to perform " + operation + " because tables are not compatible");

		return true;
	}


	public Dataset orderBy(String fieldName, boolean descending) throws AllExceptions, IOException
	{
		Field field = whereField(fieldName);
		int pos = fields.indexOf(field);

		return this.sort(pos, descending);
	}

	public Dataset project(String fieldList) throws AllExceptions, IOException
	{
		String[] split = fieldList.split("\\s*,\\s*");

		Dataset projData = new Dataset();

		for (int row = 0; row < rows.size(); row++)
		{
			Row currRow = rows.get(row);
			Row newRow = new Row();
			for (int i = 0; i < split.length; i++)
			{
				Field field = whereField(split[i].trim());

				for (int pos = 0; pos < this.fields.size(); pos++)
				{
					if (field.isName(this.fields.get(pos).getFieldName()))
					{
						newRow.addToRow(currRow.get(pos));
						(projData.fields).add(this.fields.get(pos));
					}
				}
			}
			projData.addToDataset(newRow);
		}
		rows = projData.rows;
		fields = projData.fields;

		return this;
	}

	public Dataset select(String whereClause) throws AllExceptions
	{
		if (whereClause == null)
			return this;

		String[] split = whereClause.split("\\s+");
		Field whereField = whereField(split[0]);
		int fieldPos = fields.indexOf(whereField);
		Dataset data = new Dataset();

		for (Row row : rows)
		{
			if (Table.compare(row.get(fieldPos), split[1], whereField.convertToValue(split[2])))
				data.addToDataset(row);
		}
		rows = data.rows;

		return this;
	}

	public Field whereField(String fieldName) throws AllExceptions
	{
		Field setField = null;

		for (Field field : fields)
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

	public Dataset sort(int valPos, boolean descending)
	{
		if (descending)
			Collections.sort(this.rows, Collections.reverseOrder(Row.orderBy(valPos)));
		else
			Collections.sort(this.rows, Row.orderBy(valPos));

		return this;
	}

	public String toString()
	{
		String data = "";

		data += heading();

		for (Row str : rows)
			data += str.toString();

		data += headingLine();

		return data;	
	}

	public String joinToString() throws AllExceptions
	{
		String str = "";

		for (String s : joinFields)
			str += String.format("|   %-15s   |", s.toString());

		str += "\n";

		for (Row row: rows)
			str += row.toString();

		return str;
	}

	public String heading()
	{
		StringBuilder str = new StringBuilder();
		str.append("\n" + headingLine() + "\n");
		for (Field field : fields)
		{
			if (field.isType("varchar"))
				str.append(String.format("|   %-15s |", field.getFieldName()));
			else if (field.isType("date"))
				str.append(String.format("| %-10s |", field.getFieldName()));
			else
				str.append(String.format("|  %-8s |", field.getFieldName()));
		}
		str.append("\n" + headingLine() + "\n");

		return str.toString();
	}

	public String headingLine()
	{
		StringBuilder str = new StringBuilder();

		str.append("+");

		for (Field field : fields)
		{
			str.append(field.getLineTable());
			str.append("+");
		}
		return str.toString();
	}

}
