/**
 * Row.java
 * @author Jenn Nguyen
 */
package database;

import database.values.Value;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Row implements Comparable<Row>, java.io.Serializable {
	private ArrayList<Value> values;

	public Row()
	{
		values = new ArrayList<Value>();
	}

	public void addToRow(Value value)
	{
		values.add(value);
	}

	public int length()
	{
		return values.size();
	}

	public Value get(int position)
	{
		return values.get(position);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj)
	{
		Row row = (Row) obj;
		if (this.length() != row.length())
			return false;
				
		for (int valPos = 0; valPos < this.length(); valPos++)
			if (values.get(valPos).compareTo(row.get(valPos)) != 0)
				return false;

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Row row) {
		
		for (int i = 0; i < this.values.size(); i++)
		{
			int compare = (this.values.get(i)).compareTo(row.values.get(i));

			if (compare != 0)
				return compare;
		}
		
		return 0;	
	}
	
	public void join(Row row)
	{
		values.addAll(row.values);
	}

	public String toString()
	{
		String str = "";

		for (Value value : values)
			str += value.toString();
		
		return str + "\n";
	}
	
	public static Comparator<Row> orderBy(final int valPos)
	{
		return new Comparator<Row>()
				{
					@SuppressWarnings("unchecked")
					@Override
					public int compare(Row o1, Row o2) 
					{						
						return (o1.values.get(valPos)).compareTo(o2.values.get(valPos));
					}
				};
	}


}
